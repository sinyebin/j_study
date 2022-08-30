package mybatis.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.dao.ProductDAO;
import mybatis.vo.ProductVO;

@WebServlet("/product/*")
public class productController extends HttpServlet{
	HttpSession session = null;
	ServletContext context = null;
	PrintWriter out = null;
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		session = req.getSession();
		context = req.getServletContext();
		out = resp.getWriter();
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		String prefix="/WEB-INF/";
		String suffix=".jsp";
		int beginIndex = ctxPath.length();
		int endIndex = reqUri.indexOf(".");
		System.out.println(endIndex);
		String path = "";
		if(endIndex != -1) {
			path = reqUri.substring(beginIndex, endIndex);
		} else {
			path = reqUri.substring(beginIndex);
		}
		System.out.println(">>> path => " + path);
		String viewname="";
		if(path.equals( "/product/list")) {
			List<ProductVO>list = ProductDAO.getTotal();
			req.setAttribute("list", list);
			viewname=prefix+path+suffix;
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewname);
			dispatcher.forward(req, resp);
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

}
