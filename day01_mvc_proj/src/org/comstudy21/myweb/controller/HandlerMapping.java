package org.comstudy21.myweb.controller;

import java.util.HashMap;

import org.comstudy21.myweb.bbs.BoardController;
import org.comstudy21.myweb.member.MemberController;
import org.comstudy21.myweb.shop.ShopController;

public class HandlerMapping {
	private HashMap<String, MyController> map = new HashMap();
	public HandlerMapping() {
		map.put("/member", new MemberController());
		map.put("/bbs", new BoardController());
		map.put("/shop", new ShopController());
	}
	public MyController getController(String key) {
		return map.get(key);
	}
}
