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
		PathVO pathVO=initPathAttr(req,resp); //MyUtil을 통해 pathVO 호출, uri값 가져옴
		
		String key=pathVO.getDirName(); //디렉토리 이름 가져옴, 이를 키값으로 줌
		MyController ctrl = handlerMapping.getController(key); // 키값으로 추상 클래스를 이용하여 어떤 컨트롤러에 접근하는지 알려줌
		
		String viewName=ctrl.handler(req, resp)+pathVO.getFileName(); // view의 파일명 받아옴
		System.out.println("viewName= "+viewName);
		
		viewName=pathVO.getPrefix()+viewName+pathVO.getSuffix(); //접근하려는 view명
		
		RequestDispatcher view=req.getRequestDispatcher(viewName); //RequestDispatcher 객체 생성
		view.forward(req, resp); //forward()를 통해 페이지 전환
		
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
