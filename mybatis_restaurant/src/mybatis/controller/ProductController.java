package mybatis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import mybatis.dao.ProductDAO;
import mybatis.vo.ProductVO;

@WebServlet("/product/*")
public class ProductController extends HttpServlet{
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
		int beginIndex = ctxPath.length();
		int endIndex = reqUri.indexOf(".");
		String path = "";
		if (endIndex != -1) {
			path = reqUri.substring(beginIndex, endIndex);
		} else {
			path = reqUri.substring(beginIndex);
		}
		
		if("/product/loadData".equals(path)) {
			loadData(req,resp);
		}else if("/product/addMenu".equals(path)) {
			addMenu(req,resp);
		}else if("/product/update".equals(path)) {
			update(req,resp);
		}else if("/product/delete".equals(path)) {
			delete(req, resp);
		}
		
		
	
	}
	
	private void loadData(HttpServletRequest req, HttpServletResponse resp) {
		List<ProductVO> list = ProductDAO.getTotal();
		JSONArray jsonArr = new JSONArray(list);
		out.println(jsonArr.toString(1));
	}
	private void addMenu(HttpServletRequest req, HttpServletResponse resp) {
		String rtitle=req.getParameter("rtitle");
		String rprice=req.getParameter("rprice");
		
		ProductDAO.add("0",rtitle,rprice);
		loadData(req,resp);
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		String rno = req.getParameter("rno");
		String rtitle = req.getParameter("rtitle");
		String rprice = req.getParameter("rprice");
		
		ProductDAO.update(rno, rtitle, rprice);
		
		JSONObject obj = new JSONObject(ProductDAO.findByNo(rno));
		
		out.println(obj);
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		String rno = req.getParameter("rno");
		ProductDAO.delete(rno);
		loadData(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
