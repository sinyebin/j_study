package org.proj.myapp.board;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.proj.myapp.board.BoardDTO;
import org.proj.myapp.controller.FactoryService;


public class BoardDAO {
	public List<BoardDTO> getTotal() {
		SqlSession ss = FactoryService.getFactory().openSession();
		List<BoardDTO> list = ss.selectList("board.total");
		ss.close();
		return list;
	}

	public void add(String num, String author, String email, String title, String content, String passwd,
			String writeday) {
		Map<String, String> map = new Hashtable();
		map.put("author", author);
		map.put("email", email);
		map.put("title", title);
		map.put("content", content);
		map.put("passwd", passwd);

		SqlSession ss = FactoryService.getFactory().openSession(true);

		ss.insert("board.add", map);
		ss.close();
	}

	public BoardDTO findByNum(String num) {
		SqlSession ss = FactoryService.getFactory().openSession();
		Map<String, String> map = new Hashtable<String, String>();
		map.put("num", num);
		BoardDTO dto = ss.selectOne("board.findByNum", map);
		ss.close();
		return dto;
	}
	
	public void update(String num, String author, String email, String title, String content, String passwd,
			String writeday) {
		Map<String, String> map = new Hashtable();
		map.put("num", num);
		map.put("author", author);
		map.put("email", email);
		map.put("title", title);
		map.put("content", content);
		map.put("passwd", passwd);

		SqlSession ss = FactoryService.getFactory().openSession(true);

		ss.insert("board.update", map);
		ss.close();
	}
	
	public void delete(String num) {
		Map<String, String> map = new Hashtable();
		map.put("num", num);
		SqlSession ss = FactoryService.getFactory().openSession(true);

		ss.delete("board.delete", map);
		ss.close();
		
	}
}
