package org.comstudy21.myweb.bbs.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.bbs.BoardDAO;
import org.comstudy21.myweb.bbs.BoardDTO;

public class BoardContentService implements BoardService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		int num=Integer.parseInt(req.getParameter("no")); //번호를 가져온다.
		BoardDTO selectTitle = null;
		try {
			selectTitle = BoardDAO.selectOne(num);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("selectTitle", selectTitle);
		return "bbs/content";
	}

}
