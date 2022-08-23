package org.restaurant.myweb.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.member.MemberDAO;

public interface LoginService {
	MemberDAO memberDAO=new MemberDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
