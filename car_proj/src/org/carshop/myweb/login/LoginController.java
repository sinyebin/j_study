package org.carshop.myweb.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carshop.myweb.GoHome;
import org.carshop.myweb.controller.HandlerMapping;
import org.carshop.myweb.controller.HomeController;
import org.carshop.myweb.controller.MyController;
import org.carshop.myweb.login.service.LoginJoinService;
import org.carshop.myweb.login.service.LoginpageService;
import org.carshop.myweb.login.service.LogoutService;

public class LoginController implements MyController {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String fileName = (String) req.getAttribute("fileName");
		String viewName = "";
		if (fileName.equals("/loginpage")) {
			viewName = new LoginpageService().service(req, resp);
		} else if (fileName.equals("/home")) {
			GoHome goHome = new GoHome();
			viewName = goHome.homeService(req, resp);
		} else if (fileName.equals("/join")) {
			viewName = new LoginJoinService().service(req, resp);
		} else if (fileName.equals("/logout")) {
			viewName = new LogoutService().service(req, resp);
			GoHome goHome = new GoHome();
			viewName = goHome.homeService(req, resp);
		}

		return viewName;
	}

}
