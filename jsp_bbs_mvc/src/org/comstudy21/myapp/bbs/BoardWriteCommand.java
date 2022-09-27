package org.comstudy21.myapp.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.Command;
import org.comstudy21.myapp.controller.ModelAndView;

public class BoardWriteCommand implements Command {
	@Override
	public ModelAndView action(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		if("POST".equals(req.getMethod())) {
			String author=req.getParameter("author");
			String email=req.getParameter("email");
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String passwd=req.getParameter("passwd");
			
			BoardDAO.add("0",author,email,title,content,passwd,"0");
			mav.setViewName("redirect:list.do");
		}else if("GET".equals(req.getMethod())){
			mav.setViewName("bbs/write");
		}
		return mav;
	}
}
