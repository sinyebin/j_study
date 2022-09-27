package org.comstudy21.myapp.bbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.Controller;
import org.comstudy21.myapp.controller.ModelAndView;
import org.comstudy21.myapp.user.UserDTO;

public class BoardController implements Controller{
	BoardListCommand listCommand = new BoardListCommand();
	BoardWriteCommand writeCommand = new BoardWriteCommand();
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String filePath = (String) req.getAttribute("filePath");
		System.out.println("filePath => "+ filePath);
		ModelAndView mav = new ModelAndView(req, resp);
		if("/list.do".equals(filePath)) {
			mav=listCommand.action(req,resp);
		}else if("/write.do".equals(filePath)) {
			mav=writeCommand.action(req, resp);
		}
		
		return mav;
	}

}
