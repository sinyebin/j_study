package org.comstudy21.myweb.bbs.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.bbs.BoardDAO;
import org.comstudy21.myweb.bbs.BoardDTO;

public class BoardListService implements BoardService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		List<BoardDTO> boardList=null;
		try {
			boardList = BoardDAO.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 모두 불러옴
		req.setAttribute("boardList", boardList);
		return "bbs/list";
	}

}
