package org.comstudy21.myweb.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.controller.MyController;

public class ShopController extends MyController{
	
	@Override
	public String handler(HttpServletRequest req, HttpServletResponse resp) { //추상 클래스로 값을 넘겨줌
		System.out.println(">>> ShopController ...");
		return "shop";
	}
}
