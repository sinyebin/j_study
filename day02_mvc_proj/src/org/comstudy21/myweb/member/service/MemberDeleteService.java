package org.comstudy21.myweb.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.member.MemberDAO;
import org.comstudy21.myweb.member.MemberDTO;

public class MemberDeleteService implements MemberService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		int num=Integer.parseInt(req.getParameter("no")); //번호를 가져온다.
		try {
			MemberDAO.delete(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list.do";
	}

}
