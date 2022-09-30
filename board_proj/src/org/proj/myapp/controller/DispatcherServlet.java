package org.proj.myapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.Controller;
import org.proj.myapp.controller.ModelAndView;

public class DispatcherServlet extends HttpServlet{
	HandlerMapping handlerMapping = new HandlerMapping();
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prefix=getInitParameter("prefix");
		String suffix=getInitParameter("suffix");
		
		ViewResolver resolver = new ViewResolver(req, resp);
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		
		String dirPath=(String) req.getAttribute("dirPath");
		
		Controller controller = handlerMapping.getController(dirPath);
		ModelAndView modelAndView = controller.handleRequest(req, resp);
		
		resolver.execute(modelAndView);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		process(req, resp);
	}
}
