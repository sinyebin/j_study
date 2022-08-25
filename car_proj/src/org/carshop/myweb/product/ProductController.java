package org.carshop.myweb.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carshop.myweb.controller.MyController;
import org.carshop.myweb.product.service.ProductListService;

public class ProductController implements MyController {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String fileName = (String) req.getAttribute("fileName");
		String viewName = "";
		if(fileName.equals("/list")) {
			viewName=new ProductListService().service(req, resp);
		}
		
		return viewName;
	}

}
