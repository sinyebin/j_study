package org.comstudy21.myweb.bbs.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.bbs.BoardDTO;

public class BoardWriteService implements BoardService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			BoardDTO dto=new BoardDTO(0,title,content);
			try {
				boardDAO.insert(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:list.do";
		}else {
			return "bbs/write";
		}
	}

}
