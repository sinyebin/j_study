<%@page import="mybatis.dao.ProductDAO"%>
<%@page import="mybatis.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String searchCondition = request.getParameter("searchCondition");
	String searchKeyword = request.getParameter("searchKeyword");

	List<ProductVO> searchList = ProductDAO.conditionSearch(searchCondition, searchKeyword);
	session.setAttribute("searchList", searchList);
	
	response.sendRedirect("total.jsp?search_win_is_show=true");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>