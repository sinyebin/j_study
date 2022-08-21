package org.restaurant.myweb.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.controller.HandlerMapping;
import org.restaurant.myweb.controller.HomeController;
import org.restaurant.myweb.controller.MyController;
import org.restaurant.myweb.menu.service.MenuDeleteService;
import org.restaurant.myweb.menu.service.MenuListService;
import org.restaurant.myweb.menu.service.MenuUpdateService;
import org.restaurant.myweb.menu.service.MenuWriteService;
import org.restaurant.myweb.product.ProductDAO;
import org.restaurant.myweb.product.ProductDTO;



public class MenuController implements MyController {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String fileName=(String)req.getAttribute("fileName");
		String viewName="";
		if(fileName.equals("/list")) { // list 파일명과 일치할 때
			viewName=new MenuListService().service( req, resp);
		}else if(fileName.equals("/home")) {
			MyController homectrl = new HomeController();
			HandlerMapping handlerMapping = new HandlerMapping();
			homectrl=handlerMapping.getController("");
			viewName= homectrl.handleRequest(req, resp);
		}else if(fileName.equals("/write")) {
			viewName=new MenuWriteService().service(req, resp);
		}else if(fileName.equals("/delete")) {
			viewName=new MenuDeleteService().service(req, resp);
		}else if(fileName.equals("/update")) {
			viewName=new MenuUpdateService().service(req, resp);
		}
		return viewName;
	}

}
