package org.restaurant.myweb.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.restaurant.myweb.menu.MenuController;
import org.restaurant.myweb.reserve.ReserveController;


public class HandlerMapping {
	private static Map<String, MyController> ctrlMap = new HashMap();
	static {
		// 생성자보다 먼저 실행된다.	
		ctrlMap.put("", new HomeController());
		ctrlMap.put("/reserve", new ReserveController());
		//ctrlMap.put("/bbs", new BoardController());
		ctrlMap.put("/menu", new MenuController());
	}
	public static void appendController(String key, MyController newCtrl){
		ctrlMap.put(key, newCtrl);
	}
	public HandlerMapping() {
		// TODO Auto-generated constructor stub
	}
	public HandlerMapping(Map<String, MyController> ctrlMap) {
		// TODO Auto-generated constructor stub
		if(ctrlMap!=null) {
			Iterator<String>iter= ctrlMap.keySet().iterator();
			this.ctrlMap.clear();
			while(iter.hasNext()) {
				String key=iter.next();
				this.ctrlMap.put(key, ctrlMap.get(key));
			}
			//this.ctrlMap.putAll(ctrlMap);
		}
	}
	public MyController getController(String key) {
		return ctrlMap.get(key);
	}
}
