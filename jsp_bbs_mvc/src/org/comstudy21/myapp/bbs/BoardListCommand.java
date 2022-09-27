package org.comstudy21.myapp.bbs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.Command;
import org.comstudy21.myapp.controller.ModelAndView;

public class BoardListCommand implements Command{

	@Override
	public ModelAndView action(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		List<BoardDTO> boardList=BoardDAO.getTotal();
		req.setAttribute("boardList", boardList);
		mav.setViewName("bbs/list");
		return mav;
	}
	
}
