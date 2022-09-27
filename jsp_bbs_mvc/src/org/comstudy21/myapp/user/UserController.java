package org.comstudy21.myapp.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.blog.BlogDTO;
import org.comstudy21.myapp.controller.Controller;
import org.comstudy21.myapp.controller.ModelAndView;

public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView(req, resp);
		List<UserDTO> list = null;
		mav.setViewName("user/list");
		return mav;
	}

}
