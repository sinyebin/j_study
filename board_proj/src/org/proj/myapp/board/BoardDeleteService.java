package org.proj.myapp.board;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.ModelAndView;

public class BoardDeleteService implements BoardService{

	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		String num = req.getParameter("num");
		String passwd = req.getParameter("passwd"); 
		BoardDTO dto=boardDAO.findByNum(num);
		if(dto.getPasswd().equals(passwd)) {
			System.out.println("비밀번호 일치");
			boardDAO.delete(num);
			List<BoardDTO> boardList = boardDAO.getTotal();
			mav.addObject("boardList", boardList);
			mav.setViewName("board/list");
		}else {
			System.out.println("비밀번호 불일치");
			try {
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('비밀번호 불일치');history.go(-1);</script>");
				out.close();
			}catch(Exception e) {
				e.printStackTrace();
		    }
		}
		return mav;
	}

}
