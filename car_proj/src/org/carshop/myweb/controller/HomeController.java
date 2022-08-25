package org.carshop.myweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements MyController {
	static Map<String, String> items= null;
	//String jsonStr="";
	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {		
		String ctxPath = req.getContextPath();
		if(items==null) {	
			items=new HashMap();
			items.put("상품 목록",ctxPath+"/product/list.do");
			items.put("장바구니 목록",ctxPath+"/cart/list.do");
		}		
		req.setAttribute("message", "Hello World!");
		req.setAttribute("items", items);
		return "home";
	}

}
