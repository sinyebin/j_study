package org.comstudy21.myweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.controller.HandlerMapping;
import org.comstudy21.myweb.controller.MyController;
import org.comstudy21.myweb.controller.PathVO;

import static org.comstudy21.myweb.controller.MyUtil.initPathAttr;

public class DispatcherServlet extends HttpServlet{
	private HandlerMapping handlerMapping = new HandlerMapping();
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PathVO pathVO=initPathAttr(req, resp);
		
		String key=pathVO.getDirName();
		MyController ctrl= handlerMapping.getController(key);
		
		String viewName=ctrl.handler(req, resp);
		System.out.println("viewName= "+viewName );
		
		viewName=pathVO.getPrefix()+viewName+pathVO.getSuffix();
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
		
	}
	
}
