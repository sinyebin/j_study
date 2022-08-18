package org.comstudy21.myweb.bbs.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.bbs.BoardDTO;

public class BoardUpdateService implements BoardService {
	static BoardDTO selectBoard = new BoardDTO();
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			selectBoard.setTitle(title);
			selectBoard.setContent(content);
			try {
				boardDAO.update(selectBoard);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}					
			return "redirect:list.do";
		}else {
			int num=Integer.parseInt(req.getParameter("no"));
			selectBoard.setNo(num);
			return "bbs/update";
		}
	}
}
