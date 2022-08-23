package org.restaurant.myweb.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.controller.HandlerMapping;
import org.restaurant.myweb.controller.HomeController;
import org.restaurant.myweb.controller.MyController;
import org.restaurant.myweb.login.service.LoginJoinService;
import org.restaurant.myweb.login.service.LoginpageService;

public class LoginController implements MyController {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String fileName=(String)req.getAttribute("fileName");
		String viewName="";
		if(fileName.equals("/loginpage")) {
			viewName=new LoginpageService().service(req, resp);
		}else if(fileName.equals("/home")) {
			MyController homectrl = new HomeController();
			HandlerMapping handlerMapping = new HandlerMapping();
			homectrl=handlerMapping.getController("");
			viewName= homectrl.handleRequest(req, resp);
		}else if(fileName.equals("/join")) {
			viewName=new LoginJoinService().service(req, resp);
		}
		
		
		return viewName;
	}

}
