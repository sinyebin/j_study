package org.comstudy21.myweb.bbs.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.bbs.BoardDAO;

public class BoardDeleteService implements BoardService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int num=Integer.parseInt(req.getParameter("no")); //번호를 가져온다.
		try {
			BoardDAO.delete(num);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "redirect:list.do";
	}

}
