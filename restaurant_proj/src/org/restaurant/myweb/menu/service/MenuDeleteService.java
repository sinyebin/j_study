package org.restaurant.myweb.menu.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MenuDeleteService implements MenuService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		int num=Integer.parseInt(req.getParameter("no")); //번호를 가져온다.
		try {
			productDAO.delete(num);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "redirect:list.do";

	}

}
