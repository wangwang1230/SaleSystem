package com.gm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.common.Constants;
import com.gm.common.RedisAPI;
import com.gm.pojo.Affiche;
import com.gm.pojo.Authority;
import com.gm.pojo.Function;
import com.gm.pojo.Information;
import com.gm.pojo.Menu;
import com.gm.pojo.User;
import com.gm.service.affiche.AfficheService;
import com.gm.service.function.FunctionService;
import com.gm.service.information.InformationService;
import com.gm.service.user.UserService;

@Controller
public class LoginController extends BaseController {
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserService userService;
	@Resource
	private FunctionService functionService;
	@Resource
	private RedisAPI redisAPI;
	@Resource
	private InformationService informationService;
	@Resource
	private AfficheService afficheService;
	
	@RequestMapping("/main.html")
	public ModelAndView main(HttpSession session){
		logger.debug("main======================== " );
		List<Information> infoList = null;
		List<Affiche> afficheList = null;
		Information information = new Information();
		Affiche affiche = new Affiche();
		information.setStarNum(0);
		information.setPageSize(5);
		information.setState(1);
		affiche.setStarNum(0);
		affiche.setPageSize(5);
		 try {
			 infoList = informationService.getInformationList(information);
			 afficheList = afficheService.getPortalAfficheList(affiche);
		} catch (Exception e) {
			infoList = null;
			afficheList = null;
		}
		
		//menu list
		User user = this.getCurrentUser();
		List<Menu> mList = null;
		if(null != user){
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("user", user);
			/**
			 * key:menuList+roleID---eg:"menuList2"
			 * value:mList
			 */
			//redis里有没有数据
			if(!redisAPI.exist("menuList"+user.getRoleId())){//redis没数据
				//根据当前用户获取菜单列表mList
				mList = getFuncByCurrentUser(user.getRoleId());
				//json
				if(null != mList){
					JSONArray jsonArray = JSONArray.fromObject(mList);
					String jsonString = jsonArray.toString();
					logger.debug("jsonString : " + jsonString);
					model.put("mList", jsonString);
					redisAPI.set("menuList"+user.getRoleId(), jsonString);
				}
			}else{// redis里有数据,直接从redis里取数据
				String redisMenuListKeyString = redisAPI.get("menuList"+user.getRoleId());
				logger.debug("menuList from redis: " + redisMenuListKeyString);
				if(null != redisMenuListKeyString && !"".equals(redisMenuListKeyString)){
					model.put("mList", redisMenuListKeyString);
				}else {
					return new ModelAndView("redirect:/");
				}
			}
			if(!redisAPI.exist("Role"+user.getRoleId()+"UrlList")){
				try {
					//get all role url list to redis
					Authority authority = new Authority();
					authority.setRoleId(user.getRoleId());
					List<Function> functionList = functionService.getFunctionListByRoleId(authority);
					if(functionList != null){
						StringBuffer sBuffer = new StringBuffer();
						for(Function f:functionList){
							sBuffer.append(f.getFuncUrl());
						}
						redisAPI.set("Role"+user.getRoleId()+"UrlList", sBuffer.toString());
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			model.put("infoList", infoList);
    		model.put("afficheList", afficheList);
			session.setAttribute(Constants.SESSION_BASE_MODEL, model);
			return new ModelAndView("main",model);
		}
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * 根据当前用户角色id获取功能列表（对应的菜单）
	 * @param roleId
	 * @return
	 */
	protected List<Menu> getFuncByCurrentUser(int roleId){
		List<Menu> menuList = new ArrayList<Menu>();
		Authority authority = new Authority();
		authority.setRoleId(roleId);
		
		try {
			List<Function> mList = functionService.getMainFunctionList(authority);
			if(mList != null){
				for(Function function:mList){
					Menu menu = new Menu();
					menu.setMainMenu(function);
					function.setRoleId(roleId);
					List<Function> subList = functionService.getSubFunctionList(function);
					if(null != subList){
						menu.setSubMenus(subList);
					}
					menuList.add(menu);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return menuList;
	}
	
	@RequestMapping("/login.html")
	@ResponseBody
	public Object login(HttpSession session,@RequestParam String user){
		logger.debug("login===================");
		if(user == null || "".equals(user)){
			return "nodata";
		}else{
			JSONObject userObject = JSONObject.fromObject(user);
			User userObj= (User)userObject.toBean(userObject, User.class);
			
			try {
				if(userService.loginCodeIsExit(userObj) == 0){//不存在这个登录账号
					return "nologincode";
				}else{
					User _user = userService.getLoginUser(userObj);
					if(null != _user){//登录成功
						//当前用户存到session中
						session.setAttribute(Constants.SESSION_USER, _user);
						//更新当前用户登录的lastLoginTime
						User updateLoginTimeUser = new User();
						updateLoginTimeUser.setId(_user.getId());
						updateLoginTimeUser.setLastLoginTime(new Date());
						userService.modifyUser(updateLoginTimeUser);
						updateLoginTimeUser = null;
						return "success";
					}else{//密码错误
						return "pwderror";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				return "failed";
			}
			
			
		}
	}
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout.html")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.SESSION_USER);
		session.invalidate();
		this.setCurrentUser(null);
		return "index";
	}
	//没有权限访问
	@RequestMapping("/401.html")
	public ModelAndView noRole(){
		return new ModelAndView("401");
	}
	
}
