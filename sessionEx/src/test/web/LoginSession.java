package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSession extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String pass = req.getParameter("pass");
		HttpSession session = req.getSession();
		if(session.isNew()) {
			session.setAttribute("login.name", name);
			session.setAttribute("login.id", id);
			session.setAttribute("login.pass", pass);
		}
		out.print("<html><body><center>안녕하세요");
		out.print(name);
		out.print("님</center>");
		out.print("<a href=show>회원정보보기</a>");
		out.print("</body></html>");
	}
}
