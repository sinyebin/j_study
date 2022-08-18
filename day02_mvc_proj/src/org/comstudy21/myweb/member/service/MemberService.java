package org.comstudy21.myweb.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.member.MemberDAO;

public interface MemberService {
	MemberDAO memberDAO = new MemberDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp) throws SQLException;
}
