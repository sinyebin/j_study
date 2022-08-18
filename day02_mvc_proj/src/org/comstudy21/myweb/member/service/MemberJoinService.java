package org.comstudy21.myweb.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.member.MemberDTO;

public class MemberJoinService implements MemberService{
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if("POST".equals(req.getMethod())) {
			//내용을 저장하고 새로고침
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			MemberDTO dto=new MemberDTO(0,name,phone);
			try {
				memberDAO.insert(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:list.do";
		}else {
			return "member/join";
		}

	}
}
