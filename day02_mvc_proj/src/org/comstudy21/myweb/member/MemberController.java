package org.comstudy21.myweb.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.controller.HandlerMapping;
import org.comstudy21.myweb.controller.HomeController;
import org.comstudy21.myweb.controller.MyController;
import org.comstudy21.myweb.controller.PathVO;
import org.comstudy21.myweb.member.service.MemberDeleteService;
import org.comstudy21.myweb.member.service.MemberDetailService;
import org.comstudy21.myweb.member.service.MemberJoinService;
import org.comstudy21.myweb.member.service.MemberListService;
import org.comstudy21.myweb.member.service.MemberUpdateService;

public class MemberController implements MyController {
	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println("----- MemberController -----");
		
		String fileName = (String)req.getAttribute("fileName");
		//System.out.println("fileName => " +fileName);
		String viewName="";
		if("/list".equals(fileName)) {
			viewName=new MemberListService().service(req, resp);
		}else if("/join".equals(fileName)){
			viewName=new MemberJoinService().service(req,resp);
		}else if(fileName.equals("/home")) { // 홈 클릭시
			MyController homectrl = new HomeController();
			HandlerMapping handlerMapping = new HandlerMapping();
			homectrl=handlerMapping.getController("");
			viewName= homectrl.handleRequest(req, resp);
		}else if(fileName.equals("/detail")) { //회원 정보 클릭시
			viewName= new MemberDetailService().service(req, resp);
		}else if(fileName.equals("/delete")) { // 삭제 클릭시
			viewName= new MemberDeleteService().service(req, resp);
		}else if(fileName.equals("/update")) { // 수정 클릭시
			viewName= new MemberUpdateService().service(req, resp);
		}
		return viewName;
	}
	
}
