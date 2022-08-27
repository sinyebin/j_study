package org.comstudy21.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;


@WebServlet("/emp/*")
public class EmpController extends HttpServlet {
	HttpSession session = null;
	ServletContext context = null;
	PrintWriter out = null;
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		System.out.println(endIndex);
		String path = "";
		if(endIndex != -1) {
			path = reqUri.substring(beginIndex, endIndex);
		} else {
			path = reqUri.substring(beginIndex);
		}

		//System.out.println(">>> path => " + path);
		if("/emp/search".equals(path)) {
			search(req, resp);
		} else if("/emp/delete".equals(path)) {
			delete(req, resp);
		} else if("/emp/update".equals(path)) {
			update(req, resp);
		} else if("/emp/score".equals(path)) {
			score(req, resp);
		} else if("/emp/loadData".equals(path)) {
			loadData(req, resp);
		} else if("/emp/data".equals(path)) {
			data(req, resp);
		}
	}
	
	private void search(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println(">>> search 기능");
		String keyword = req.getParameter("keyword");
		String word = req.getParameter("word");
		
		List<EmpVO> searchList = EmpDAO.conditionSearch(keyword, word);
		
		out.println(new JSONArray(searchList).toString(1));
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println(">>> delete 기능");
		String empno = req.getParameter("empno");
		EmpDAO.delete(empno);
		
		String delType = req.getParameter("delType");
		if(delType != null && "choice".equals(delType)) {
			return;
		}
		loadData(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println(">>> update 기능");
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		String dept = req.getParameter("dept");
		String position = req.getParameter("position");
		
		//System.out.println(new EmpVO(Integer.parseInt(empno), ename, dept, position));
		EmpDAO.update(empno, ename, dept, position);
		
		JSONObject obj = new JSONObject(EmpDAO.findByNo(empno));
		
		out.println(obj);
	}

	private void score(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(">>> score 기능");
	}

	private void loadData(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println(">>> loadData 기능");
		List<EmpVO> list = EmpDAO.getTotal();
		JSONArray jsonArr = new JSONArray(list);
		//System.out.println(jsonArr.toString(1));
		
		out.println(jsonArr.toString(1));
	}

	private void data(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println(">>> data 입력 기능");
		String ename = req.getParameter("ename");
		String dept = req.getParameter("dept");
		String position = req.getParameter("position");
		
		//EmpVO vo = new EmpVO(0, ename, dept, position);
		//System.out.println(vo);
		EmpDAO.add("0", ename, dept, position);
		
		loadData(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
