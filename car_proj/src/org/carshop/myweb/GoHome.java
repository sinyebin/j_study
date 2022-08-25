package org.carshop.myweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carshop.myweb.controller.HandlerMapping;
import org.carshop.myweb.controller.HomeController;
import org.carshop.myweb.controller.MyController;

public class GoHome {
	public String homeService(HttpServletRequest req, HttpServletResponse resp) {
		MyController homectrl = new HomeController();
		HandlerMapping handlerMapping = new HandlerMapping();
		homectrl = handlerMapping.getController("");
		return homectrl.handleRequest(req, resp);
	}
}
