package org.restaurant.myweb.login.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.restaurant.myweb.controller.HandlerMapping;
import org.restaurant.myweb.controller.HomeController;
import org.restaurant.myweb.controller.MyController;

public class LoginpageService implements LoginService {

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
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			try {
				boolean check = memberDAO.login_Ok(id, pw);
				if (check) {
					HttpSession session = req.getSession();

					session.setAttribute("login.id", id);

					MyController homectrl = new HomeController();
					HandlerMapping handlerMapping = new HandlerMapping();
					homectrl = handlerMapping.getController("");
					return homectrl.handleRequest(req, resp);
				} else {
					out.write("<script>alert('잘못된 id 혹은 비밀번호 입니다.'); location.href='loginpage.do';</script>");
					out.flush();
					out.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} else {
			return "login/loginpage";
		}

	}

}
