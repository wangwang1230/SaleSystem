package com.gm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.common.Constants;
import com.gm.common.JsonDateValueProcessor;
import com.gm.common.PageSupport;
import com.gm.common.SQLTools;
import com.gm.pojo.GoodsInfo;
import com.gm.pojo.User;
import com.gm.service.goodsinfo.GoodsInfoService;
import com.mysql.jdbc.StringUtils;

@Controller
public class GoodsInfoController extends BaseController{
	@Resource
	private GoodsInfoService goodsInfoService;
	
	
	@RequestMapping("/backend/goodsinfolist.html")
	public ModelAndView getGoodsInfoList(HttpSession session,Model model,
			@RequestParam(value="currentpage",required=false) Integer currentpage,
			@RequestParam(value="s_goodsName",required=false) String s_goodsName,
			@RequestParam(value="s_state",required=false) String s_state){
		Map<String, Object> baseModel = (Map<String, Object>) session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			//设置查询条件-放入goodsInfo对象中
			GoodsInfo goodsInfo = new GoodsInfo();
			if(null != s_goodsName)
				goodsInfo.setGoodsName("%"+SQLTools.transfer(s_goodsName)+"%");
			if(!StringUtils.isNullOrEmpty(s_state))
				goodsInfo.setState(Integer.valueOf(s_state));
			else
				goodsInfo.setState(null);
			//pages
			PageSupport page = new PageSupport();
			try {
				page.setTotalCount(goodsInfoService.count(goodsInfo));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				page.setTotalCount(0);
			}
			if(page.getTotalCount()>0){
				if(currentpage != null)
					page.setPage(currentpage);
				if(page.getPage() <= 0)
					page.setPage(1);
				if(page.getPage() > page.getPageCount())
					page.setPage(page.getPageCount());
				goodsInfo.setStarNum((page.getPage()-1)*page.getPageSize());
				goodsInfo.setPageSize(page.getPageSize());
				
				List<GoodsInfo> goodsInfoList = null;
				try {
					goodsInfoList = goodsInfoService.getGoodsInfoList(goodsInfo);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					goodsInfoList = null;
					if(page == null){
						page = new PageSupport();
						page.setItems(null);
					}
				}
				page.setItems(goodsInfoList);
			}else{
				page.setItems(null);
			}
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			
			model.addAttribute("s_goodsName", s_goodsName);
			model.addAttribute("s_state", s_state);
			return new ModelAndView("/goods/goodsinfolist");
		}
		
	}
	
	@RequestMapping(value="/backend/addgoodsinfo.html",method=RequestMethod.POST)
	public ModelAndView addGoodsInfo(HttpSession session,@ModelAttribute("addGoodsInfo") GoodsInfo addGoodsInfo){
		if(session.getAttribute(Constants.SESSION_BASE_MODEL) == null){
			return new ModelAndView("redirect:/");
		}else{
			try {
				addGoodsInfo.setCreateTime(new Date());
				addGoodsInfo.setLastUpdateTime(new Date());
				addGoodsInfo.setCreatedBy(((User)session.getAttribute(Constants.SESSION_USER)).getLoginCode());
				
				goodsInfoService.addGoodsInfo(addGoodsInfo);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/backend/goodsinfolist.html");
		}
	}
	
	@RequestMapping(value="/backend/getgoodsinfo.html",produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public Object getGoodsInfo(@RequestParam(value="id",required=false) String id){
			String str = "";
			if(null == id || "".equals(id)){
				return "nodata";
			}else{
				try {
					GoodsInfo goodsInfo = new GoodsInfo();
					goodsInfo.setId(Integer.valueOf(id));
					goodsInfo = goodsInfoService.getGoodsInfoById(goodsInfo);
					JsonConfig jsonConfig = new JsonConfig();
					jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
					JSONObject jo = JSONObject.fromObject(goodsInfo,jsonConfig);
					str = jo.toString();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return "failed";
				}
				return str;
			}
	}
	
	@RequestMapping(value="/backend/modifygoodsinfo.html",method=RequestMethod.POST)
	public ModelAndView modifyGoodsInfo(HttpSession session,@ModelAttribute("modfiyGoodsInfo") GoodsInfo modifyGoodsInfo){
		if(session.getAttribute(Constants.SESSION_BASE_MODEL) == null){
			return new ModelAndView("redirect:/");
		}else{
			try {
				modifyGoodsInfo.setLastUpdateTime(new Date());
				goodsInfoService.modifyGoodsInfo(modifyGoodsInfo);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/backend/goodsinfolist.html");
		}
	}
	
	
}
