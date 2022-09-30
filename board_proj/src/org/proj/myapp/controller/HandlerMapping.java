package org.proj.myapp.controller;

import java.util.HashMap;

import org.proj.myapp.board.BoardController;

public class HandlerMapping {
	HashMap<String, Controller> map = new HashMap();
	
	public HandlerMapping() {
		map.put("/board", new BoardController());
	}
	
	public Controller getController(String path) {
		return map.get(path);
	}
}
