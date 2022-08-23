package org.restaurant.myweb.login.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.member.MemberDTO;

public class LoginJoinService implements LoginService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html; charset=UTF-8");		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (req.getMethod().equals("POST")) {
			String id=req.getParameter("id");
			String pw=req.getParameter("pw");
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			String email=req.getParameter("email");
			MemberDTO dto=new MemberDTO(0, id, pw, name, phone, email);
			try {
				boolean check = memberDAO.searchID(id);
				if(check) {
					memberDAO.insert(dto);
					return "redirect:loginpage.do";
				}else {
					out.write("<script>alert('등록된 id 입니다.'); location.href='join.do';</script>");
					out.flush();
					out.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			return null;
		} else {
			return "login/join";
		}
	}

}
