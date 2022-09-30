package org.proj.myapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.ModelAndView;

public interface BoardService {
	BoardDAO boardDAO = new BoardDAO();
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp);
}
