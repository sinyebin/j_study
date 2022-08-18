package org.comstudy21.myweb.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.member.MemberDAO;
import org.comstudy21.myweb.member.MemberDTO;

public class MemberUpdateService implements MemberService {
	static MemberDTO selectMember=new MemberDTO();
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if("POST".equals(req.getMethod())) {
			//내용을 저장하고 새로고침
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			selectMember.setName(name);
			selectMember.setPhone(phone);
			try {
				memberDAO.update(selectMember);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:list.do";
		}else {
			int num=Integer.parseInt(req.getParameter("no")); //번호를 가져온다.
			selectMember.setNo(num);
			return "member/update";
		}
	}

}
