package org.comstudy21.myweb.bbs.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.bbs.BoardDAO;

public interface BoardService {
	BoardDAO boardDAO= new BoardDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
