package org.carshop.myweb.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.carshop.myweb.GoHome;

public class LogoutService implements LoginService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		return null;
	}

}
