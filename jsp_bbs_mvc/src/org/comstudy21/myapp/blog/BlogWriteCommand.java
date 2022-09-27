package org.comstudy21.myapp.blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.Command;
import org.comstudy21.myapp.controller.ModelAndView;

public class BlogWriteCommand implements Command{
	@Override
	public ModelAndView action(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		if("POST".equals(req.getMethod())) {
			mav.setViewName("redirect:list.do");
		}else if("GET".equals(req.getMethod())){
			mav.setViewName("blog/write");
		}
		return mav;
	}
}
