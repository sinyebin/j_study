package org.comstudy21.myweb.bbs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.bbs.service.BoardContentService;
import org.comstudy21.myweb.bbs.service.BoardDeleteService;
import org.comstudy21.myweb.bbs.service.BoardListService;
import org.comstudy21.myweb.bbs.service.BoardUpdateService;
import org.comstudy21.myweb.bbs.service.BoardWriteService;
import org.comstudy21.myweb.controller.HandlerMapping;
import org.comstudy21.myweb.controller.HomeController;
import org.comstudy21.myweb.controller.MyController;
import org.comstudy21.myweb.member.service.MemberUpdateService;

public class BoardController implements MyController{
	
	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println(">>>BoardController ...");
		String fileName=(String)req.getAttribute("fileName"); // boardcontroller에 해당하는 파일이름 가져오기
		//System.out.println(fileName); // 파일명 출력
		String viewName="";
		if(fileName.equals("/list")) { // list 파일명과 일치할 때
			viewName= new BoardListService().service(req, resp);
		}else if(fileName.equals("/write")) {
			viewName= new BoardWriteService().service(req,resp);
		}else if(fileName.equals("/home")) {
			MyController homectrl = new HomeController();
			HandlerMapping handlerMapping = new HandlerMapping();
			homectrl=handlerMapping.getController("");
			viewName= homectrl.handleRequest(req, resp);
		}else if(fileName.equals("/content")) { // 제목 클릭시
			viewName= new BoardContentService().service(req,resp);
		}else if(fileName.equals("/delete")) { // 삭제 클릭시
			viewName= new BoardDeleteService().service(req,resp);
		}else if(fileName.equals("/update")) { // 수정 클릭시
			viewName= new BoardUpdateService().service(req, resp);
		}
		
		return viewName;
	}
}
