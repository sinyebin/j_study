package org.proj.myapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.ModelAndView;

public class BoardWriteService implements BoardService {

	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		if ("POST".equals(req.getMethod())) {
			String author = req.getParameter("author");
			String email = req.getParameter("email");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String passwd = req.getParameter("passwd");
			boardDAO.add("0", author, email, title, content, passwd, "0");
			mav.setViewName("redirect:list.do");
		} else if ("GET".equals(req.getMethod())) {
			mav.setViewName("board/write");
		}
		return mav;
	}
}
