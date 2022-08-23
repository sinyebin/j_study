package org.restaurant.myweb.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.member.MemberDTO;

public class LoginJoinService implements LoginService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if (req.getMethod().equals("POST")) {
			String id=req.getParameter("id");
			String pw=req.getParameter("pw");
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			String email=req.getParameter("email");
			MemberDTO dto=new MemberDTO(0, id, pw, name, phone, email);
			try {
				memberDAO.insert(dto);
			}catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			return "redirect:loginpage.do";
		} else {
			return "login/join";
		}
	}

}
