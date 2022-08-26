<%@page import="mybatis.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	String pname=request.getParameter("pname");
	String price=request.getParameter("price");
	
	int cnt= ProductDAO.add("0", pname, price);
	
	response.sendRedirect("total.jsp");
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