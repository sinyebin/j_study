package org.proj.myapp.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.proj.myapp.controller.Controller;
import org.proj.myapp.controller.ModelAndView;

public class BoardController implements Controller{
	BoardListService listService = new BoardListService();
	BoardWriteService writeService = new BoardWriteService();
	BoardDetailService detailService = new BoardDetailService();
	BoardUpdateService updateService= new BoardUpdateService();
	BoardDeleteService deleteService = new BoardDeleteService();
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String filePath = (String)req.getAttribute("filePath");
		ModelAndView mav = new ModelAndView(req, resp);
		if(filePath.equals("/list.do")) {
			mav=listService.service(req, resp);
		}else if(filePath.equals("/write.do")) {
			mav=writeService.service(req, resp);
		}else if(filePath.equals("/detail.do")) {
			mav=detailService.service(req, resp);
		}else if(filePath.equals("/update.do")) {
			mav=updateService.service(req, resp);
		}else if(filePath.equals("/delete.do")) {
			mav=deleteService.service(req, resp);
		}
		return mav;
	}

}
