package org.comstudy21.myweb.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.member.MemberDAO;
import org.comstudy21.myweb.member.MemberDTO;

public class MemberDetailService implements MemberService {
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		int num=Integer.parseInt(req.getParameter("no")); //번호를 가져온다.
		MemberDTO selectMember=null;
		try {
			selectMember = MemberDAO.selectOne(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //번호로 객체를 불러온다.
		req.setAttribute("selectMember", selectMember); //저장된 객체를 attribute로 설정한다.
		return "member/detail";
	}

}
