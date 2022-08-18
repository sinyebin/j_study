package org.comstudy21.myweb.member.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.member.MemberDAO;
import org.comstudy21.myweb.member.MemberDTO;

public class MemberListService implements MemberService{
	public String service(HttpServletRequest req, HttpServletResponse resp)  {
		List<MemberDTO> memList=null;
		try {
			memList = MemberDAO.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("memList", memList);
		return "member/list";
	}
}
