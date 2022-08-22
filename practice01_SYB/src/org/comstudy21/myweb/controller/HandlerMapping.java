package org.comstudy21.myweb.controller;

import java.util.HashMap;

import org.comstudy21.myweb.bbs.BoardController;
import org.comstudy21.myweb.member.MemberController;
import org.comstudy21.myweb.shop.ShopController;

public class HandlerMapping { //해시맵을 통해 값을 연결?
	private HashMap<String, MyController> map = new HashMap(); //해시맵으로 추상 클래스 값 저장
	public HandlerMapping() {
		// TODO Auto-generated constructor stub
		map.put("/member", new MemberController());
		map.put("/bbs", new BoardController());
		map.put("/shop", new ShopController());
	}
	public MyController getController(String key) {
		return map.get(key); // 어떤 컨트롤러에 접근해야 되는지 알려줌
	}
}
