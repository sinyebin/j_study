package org.carshop.myweb.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.carshop.myweb.cart.CartController;
import org.carshop.myweb.login.LoginController;
import org.carshop.myweb.product.ProductController;

public class HandlerMapping {
	private static Map<String, MyController> ctrlMap = new HashMap();
	static {
		// 생성자보다 먼저 실행된다.
		ctrlMap.put("", new HomeController());
		ctrlMap.put("/product", new ProductController());
		ctrlMap.put("/cart", new CartController());
		ctrlMap.put("/login", new LoginController());
	}

	public static void appendController(String key, MyController newCtrl) {
		ctrlMap.put(key, newCtrl);
	}

	public HandlerMapping() {
		// TODO Auto-generated constructor stub
	}

	public HandlerMapping(Map<String, MyController> ctrlMap) {
		// TODO Auto-generated constructor stub
		if (ctrlMap != null) {
			Iterator<String> iter = ctrlMap.keySet().iterator();
			this.ctrlMap.clear();
			while (iter.hasNext()) {
				String key = iter.next();
				this.ctrlMap.put(key, ctrlMap.get(key));
			}
			// this.ctrlMap.putAll(ctrlMap);
		}
	}

	public MyController getController(String key) {
		return ctrlMap.get(key);
	}
}
