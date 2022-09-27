package org.comstudy21.myapp.bbs;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.comstudy21.myapp.controller.FactoryService;



public class BoardDAO {
	public static List<BoardDTO> getTotal(){
		SqlSession ss = FactoryService.getFactory().openSession();
		List<BoardDTO> list = ss.selectList("board.total");
		ss.close();
		return list;
	}
	
	public static void add(String num, String author, String email,String title, String content, String passwd, String writeday) {
		Map<String,String>map = new Hashtable();
		map.put("author", author);
		map.put("email", email);
		map.put("title", title);
		map.put("content", content);
		map.put("passwd", passwd);
		
		SqlSession ss = FactoryService.getFactory().openSession(true);
		
		ss.insert("board.add", map);
		ss.close();
	}
}
