package org.proj.myapp.board;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.ModelAndView;

public class BoardUpdateService implements BoardService {

	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		String check = req.getParameter("check");
		System.out.println(check);
		if ("POST".equals(req.getMethod()) && check.equals("check")) {
			String num = req.getParameter("num");
			String passwd = req.getParameter("passwd");
			BoardDTO dto = boardDAO.findByNum(num);
			if (dto.getPasswd().equals(passwd)) {
				mav.setViewName("board/update");
				mav.addObject("board", dto);
			} else {
				try {
					PrintWriter out = resp.getWriter();
					out.println("<script>alert('비밀번호 불일치');history.go(-1);</script>");
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if ("POST".equals(req.getMethod())) {
			String num = req.getParameter("num");
			String author = req.getParameter("author");
			String email = req.getParameter("email");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String passwd = req.getParameter("passwd");
			boardDAO.update(num, author, email, title, content, passwd, "0");
			mav.setViewName("redirect:list.do");
		}
		return mav;
	}

}
