package org.restaurant.myweb.controller;

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
			items.put("예약 신청(고객용)",ctxPath+"/reserve/register_cust.do");
			items.put("길동이네 식당 예약 고객 목록(관리용)",ctxPath+"/reserve/list.do");
			items.put("길동이네 식당 메뉴 관리(관리용)",ctxPath+"/menu/list.do");
		}
		/*jsonStr="{\"예약 신청(고객용)\":"+items.get("예약 신청(고객용)")+
				",\"길동이네 식당 예약 고객 목록(관리용)\":"+items.get("길동이네 식당 예약 고객 목록(관리용)")+
				",\"길동이네 식당 메뉴 관리(관리용)\":"+items.get("길동이네 식당 메뉴 관리(관리용)");*/
		//System.out.println(">>> HomeController ...");
		
		req.setAttribute("message", "Hello World!");
		req.setAttribute("items", items);
		//req.setAttribute("title", jsonStr);
		return "home";
	}

}
