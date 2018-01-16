package com.gm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.common.Constants;
import com.gm.common.RedisAPI;
import com.gm.pojo.Authority;
import com.gm.pojo.Function;
import com.gm.pojo.Menu;
import com.gm.pojo.Role;
import com.gm.pojo.RoleFunctions;
import com.gm.pojo.User;
import com.gm.service.authority.AuthorityService;
import com.gm.service.function.FunctionService;
import com.gm.service.role.RoleService;


@Controller
public class AuthorityController extends BaseController{
	private Logger logger = Logger.getLogger(AuthorityController.class);
	@Resource
	private RoleService roleService;
	@Resource
	private FunctionService functionService;
	@Resource 
	private AuthorityService authorityService;
	@Resource
	private LoginController loginController;
	@Resource
	private RedisAPI redisAPI;
	/**
	 * 进入到权限管理首页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/backend/authoritymanage.html")
	public ModelAndView authorityManage(HttpSession session,Model model){
		Map<String, Object> baseModel = (Map<String, Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			List<Role> roleList = null;
			try {
				roleList = roleService.getRoleIdAndNameList();//获得所有启用的角色列表
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				roleList = null;
			}
			model.addAllAttributes(baseModel);
			model.addAttribute("roleList", roleList);
			return new ModelAndView("/backend/authoritymanage");
		}
		
	}
	
	//获取菜单功能列表
	@RequestMapping(value = "/backend/functions.html",produces={"text/html;charset=utf-8"})
	@ResponseBody
	public Object functions(){
		String result = "nodata";
		Function function = new Function();
		try {
			function.setId(0);
			List<Function> fList = functionService.getSubFuncList(function);
			List<RoleFunctions> rList = new ArrayList<RoleFunctions>();
			if(fList != null){
				for(Function func : fList){
					RoleFunctions rFunctions = new RoleFunctions();
					rFunctions.setMainFunction(func);
					rFunctions.setSubFunctions(functionService.getSubFuncList(func));
					rList.add(rFunctions);
				}
				result = JSONArray.fromObject(rList).toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return result;
	}
	
	@RequestMapping(value="/backend/getAuthorityDefault.html",produces={"text/html;charset=UTF-8"})
	@ResponseBody
	public Object getAuthorityDefault(@RequestParam Integer rid,@RequestParam Integer fid){
		String result = "nodata";
		try {
			Authority authority = new Authority();
			authority.setRoleId(rid);
			authority.setFunctionId(fid);
			if(authorityService.getAuthority(authority) != null){
				result = "success";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@RequestMapping(value = "/backend/modifyAuthority.html",produces={"text/html;charset=UTF-8"})
	@ResponseBody
	public Object modifyAuthority(HttpSession session,@RequestParam String ids){
		String result = "nodata";
		try {
			if(ids != null){
				String[] idsArr = StringUtils.split(ids, "-");
				if(idsArr.length > 0){
					User user = this.getCurrentUser();
					//权限表的更新操作（roleId functionids）
					//先把该角色下的所有功能授权删除，然后进行重新授权(运用事务)
					authorityService.gm_addAuthority(idsArr, user.getLoginCode());
					List<Menu> mList = null;
					mList = loginController.getFuncByCurrentUser(Integer.valueOf(idsArr[0]));
					JSONArray jsonArray = JSONArray.fromObject(mList);
					redisAPI.set("menuList"+idsArr[0], jsonArray.toString());
					//get all role url list to redis
					Authority authority = new Authority();
					authority.setRoleId(Integer.valueOf(idsArr[0]));
					List<Function> functionList = functionService.getFunctionListByRoleId(authority);
					if(functionList != null && functionList.size() >= 0){
						StringBuffer sb = new StringBuffer();
						for(Function function : functionList){
							sb.append(function.getFuncUrl());
						}
						redisAPI.set("Role"+idsArr[0]+"UrlList", sb.toString());
					}
					result = "success";
					logger.debug("result =============================="+result);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
