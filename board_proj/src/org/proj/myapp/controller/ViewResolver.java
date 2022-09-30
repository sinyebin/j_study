package org.proj.myapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.ModelAndView;

public class ViewResolver {
	private String prefix;
	private String suffix;
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ViewResolver(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;

	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;

	}

	public void execute(ModelAndView modelAndView) throws ServletException, IOException {
		String viewName = modelAndView.getViewName();
		if (viewName.indexOf("redirect:") == 0) {
			int beginIndex = "redirect:".length();
			resp.sendRedirect(viewName.substring(beginIndex));
		} else {
			RequestDispatcher view = req.getRequestDispatcher(prefix + viewName + suffix);
			view.forward(req, resp);
		}
	}
}
