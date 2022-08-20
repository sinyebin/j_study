package org.restaurant.myweb.reserve;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.controller.MyController;

public class ReserveController implements MyController{

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(">>>ReserveController ...");
		String fileName=(String)req.getAttribute("fileName");
		System.out.println(fileName);
		String viewName="";
		if(fileName.equals("/register")) {
			if(req.getMethod().equals("POST")) {
				String name=req.getParameter("name");
				String phone=req.getParameter("phone");
				BoardDTO dto=new BoardDTO(0,title,content);
				try {
					boardDAO.insert(dto);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "redirect:list.do";
			}else {
				return "bbs/write";
			}
		}
		return viewName;
	}
	

}
