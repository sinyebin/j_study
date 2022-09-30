package org.proj.myapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.ModelAndView;

public class BoardDetailService implements BoardService {

	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		String num = req.getParameter("num");
		BoardDTO dto=boardDAO.findByNum(num);
		mav.addObject("board", dto);
		mav.setViewName("board/detail");
		return mav;
	}

}
