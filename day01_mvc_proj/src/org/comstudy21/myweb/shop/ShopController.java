package org.comstudy21.myweb.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.controller.MyController;

public class ShopController extends MyController {

   @Override
   public String handler(HttpServletRequest req, HttpServletResponse resp) {
	   System.out.println(">>> ShopController ...");
	   return "shop/list";
   }

}