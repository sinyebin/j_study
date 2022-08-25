package org.carshop.myweb.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carshop.myweb.member.MemberDAO;

public interface LoginService {
	MemberDAO memberDAO = new MemberDAO();

	public String service(HttpServletRequest req, HttpServletResponse resp);
}
