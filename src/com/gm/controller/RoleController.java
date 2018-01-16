package com.gm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.common.Constants;
import com.gm.pojo.Role;
import com.gm.pojo.User;
import com.gm.service.role.RoleService;
import com.gm.service.user.UserService;

@Controller
public class RoleController extends BaseController{
	private Logger logger = Logger.getLogger(RoleController.class);
	
	@Resource
	private RoleService roleService;
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/backend/addRole.html")
	@ResponseBody
	public Object addRole(HttpSession session,@RequestParam String role){
		if(role == null || "".equals(role)){
			return "nodata";		
		}else{
			JSONObject roleObject = JSONObject.fromObject(role);
			Role roleObj = (Role)JSONObject.toBean(roleObject,Role.class);
			roleObj.setCreateDate(new Date());
			roleObj.setIsStart(1);
			roleObj.setCreatedBy(((User)session.getAttribute(Constants.SESSION_USER)).getLoginCode());
			try {
				if(roleService.getRoleR(roleObj) != null){
					return "rename";
				}else{
					roleService.addRole(roleObj);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "failed";
			}
			return "success";
		}
	}	
	@RequestMapping(value = "/backend/modifyRole.html")
	@ResponseBody
	public Object modifyRole(HttpSession session,@RequestParam String role){
		if(role == null || "".equals(role)){
			return "nodata";
		}else{
			JSONObject roleObject = JSONObject.fromObject(role);
			Role roleObj = (Role)JSONObject.toBean(roleObject,Role.class);
			roleObj.setCreateDate(new Date());
			roleObj.setCreatedBy(this.getCurrentUser().getLoginCode());
			try {
				roleService.gm_modifyRole(roleObj);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "failed";
			}
			return "success";
		}
	}
	
	
	@RequestMapping(value = "/backend/delRole.html")
	@ResponseBody
	public Object delRole(HttpSession session,@RequestParam String role){
		if(role == null || role.equals("")){
			return "data";
		}else{
			JSONObject roleObject = JSONObject.fromObject(role);
			Role roleObj = (Role)JSONObject.toBean(roleObject,Role.class);
			try {
				User u = new User();
				List<User> ulist = null;
				u.setRoleId(roleObj.getId());
				ulist = userService.getUserListBySearch(u);
				if(ulist == null || ulist.size() == 0){
					roleService.deleteRole(roleObj);
				}else{
					String flag = "";
					for (int i = 0; i < ulist.size(); i++) {
						flag +=ulist.get(i).getLoginCode();
						flag +=",";
					}
					return flag;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "failed";
			}
			return "success";
		}
	}
	
	@RequestMapping(value = "/backend/rolelist.html")
	public ModelAndView roleList(HttpSession session,Model model){
		Map<String, Object> baseModel = (Map<String, Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			List<Role> roleList = null;
			Role role = new Role();
			try {
				roleList = roleService.getRoleList();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				roleList = null;
			}
			model.addAllAttributes(baseModel);
			model.addAttribute(roleList);
			return new ModelAndView("/backend/rolelist");
		}
	
	
	}
}
