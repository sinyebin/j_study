<%@page import="org.restaurant.myweb.reserve.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메뉴 수정</h1>
<%
ProductDTO selectProduct = (ProductDTO)request.getAttribute("selectProduct");
%>
<form action="update.do" method="POST">
	<label for="">예약 명: </label>
	<input type="text" name="rtitle" value=""/>
	<label for="">금액: </label>
	<input type="text" name="rprice" value=""/>
	<input type="submit" value="수정"/>
</form>
</body>
</html>