package org.proj.myapp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.ModelAndView;

public class BoardListService implements BoardService {
	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		List<BoardDTO> boardList = boardDAO.getTotal();
		mav.addObject("boardList", boardList);
		mav.setViewName("board/list");
		return mav;
	}
}
