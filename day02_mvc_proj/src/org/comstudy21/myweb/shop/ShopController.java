package org.comstudy21.myweb.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.controller.HandlerMapping;
import org.comstudy21.myweb.controller.HomeController;
import org.comstudy21.myweb.controller.MyController;
import org.comstudy21.myweb.shop.service.ShopDeleteService;
import org.comstudy21.myweb.shop.service.ShopDetailService;
import org.comstudy21.myweb.shop.service.ShopListService;
import org.comstudy21.myweb.shop.service.ShopUpdateService;
import org.comstudy21.myweb.shop.service.ShopWriteService;

public class ShopController implements MyController{
	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String fileName = (String)req.getAttribute("fileName");
		//System.out.println("fileName => " +fileName);
		String viewName="";
		if(fileName.equals("/list")) {
			viewName=new ShopListService().service(req,resp);
		}else if(fileName.equals("/write")) {
			viewName=new ShopWriteService().service(req, resp);
		}else if(fileName.equals("/home")) {
			MyController homectrl = new HomeController();
			HandlerMapping handlerMapping = new HandlerMapping();
			homectrl=handlerMapping.getController("");
			viewName= homectrl.handleRequest(req, resp);
		}else if(fileName.equals("/detail")) {
			viewName=new ShopDetailService().service(req, resp);
		}else if(fileName.equals("/delete")) {
			viewName=new ShopDeleteService().service(req, resp);
		}else if(fileName.equals("/update")) {
			viewName=new ShopUpdateService().service(req,resp);
		}
		
		return viewName;
	}
}
