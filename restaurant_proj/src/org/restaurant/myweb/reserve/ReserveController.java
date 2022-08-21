package org.restaurant.myweb.reserve;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.controller.HandlerMapping;
import org.restaurant.myweb.controller.HomeController;
import org.restaurant.myweb.controller.MyController;
import org.restaurant.myweb.reserve.service.ReserveDeleteService;
import org.restaurant.myweb.reserve.service.ReserveListService;
import org.restaurant.myweb.reserve.service.ReserveRegisterCustService;
import org.restaurant.myweb.reserve.service.ReserveRegisterService;

public class ReserveController implements MyController{

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(">>>ReserveController ...");
		String fileName=(String)req.getAttribute("fileName");
		System.out.println(fileName);
		String viewName="";
		if(fileName.equals("/list")) {
			viewName=new ReserveListService().service(req, resp);
		}else if(fileName.equals("/home")) {
			MyController homectrl = new HomeController();
			HandlerMapping handlerMapping = new HandlerMapping();
			homectrl=handlerMapping.getController("");
			viewName= homectrl.handleRequest(req, resp);
		}else if(fileName.equals("/delete")) {
			viewName=new ReserveDeleteService().service(req, resp);
		}else if(fileName.equals("/register")) {
			viewName = new ReserveRegisterService().service(req, resp);
		}else if(fileName.equals("/register_cust")) {
			viewName = new ReserveRegisterCustService().service(req, resp);
		}
		return viewName;
	}
	

}
