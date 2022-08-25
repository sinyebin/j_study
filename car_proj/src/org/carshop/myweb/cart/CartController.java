package org.carshop.myweb.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carshop.myweb.cart.service.CartAddService;
import org.carshop.myweb.cart.service.CartListService;
import org.carshop.myweb.controller.MyController;

public class CartController implements MyController{

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String fileName = (String) req.getAttribute("fileName");
		String viewName = "";
		System.out.println(fileName);
		if (fileName.equals("/add")) {
			viewName= new CartAddService().service(req, resp);
		}else if(fileName.equals("/list")) {
			viewName=new CartListService().service(req, resp);
		}
		return viewName;
	}

}
