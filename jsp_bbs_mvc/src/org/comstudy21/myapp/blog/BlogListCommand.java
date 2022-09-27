package org.comstudy21.myapp.blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.Command;
import org.comstudy21.myapp.controller.ModelAndView;

public class BlogListCommand implements Command {

	@Override
	public ModelAndView action(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView(req, resp);
		mav.setViewName("blog/list");
		return mav;
	}

}
