package com.gm.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gm.common.Constants;
import com.gm.common.RedisAPI;
import com.gm.pojo.User;
/**
 * 自定义拦截器
 * @author Administrator
 *
 */
public class SysInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = Logger.getLogger(SysInterceptor.class);
	@Resource
	private RedisAPI redisAPI;
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		HttpSession session = request.getSession();
		String urlPath = request.getRequestURI();
		User user = (User)session.getAttribute(Constants.SESSION_USER);
		if(user == null){
			response.sendRedirect("/");
			return false;
		}else{
			String key = "Role"+user.getRoleId()+"UrlList";
			String urls = "url:"+redisAPI.get(key);
			if(urls != null && !urls.equals("") && urls.indexOf(urlPath)>0){
				return true;
			}else{
				response.sendRedirect("/401.html");
				return false;
				//return true;
			}
		}
		
	}
	
	

}
