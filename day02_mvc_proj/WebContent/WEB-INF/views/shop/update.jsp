<%@page import="org.comstudy21.myweb.shop.ShopDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품수정</h1>
<%
ShopDTO selectGoods = (ShopDTO)request.getAttribute("selectGoods");
%>
<form action="update.do" method="POST">
	<label for="">상품: </label>
	<input type="text" name="goods" value="상품"/>
	<label for="">가격: </label>
	<input type="text" name="price" value="2000"/>
	<input type="submit" value="수정" />
</form>
</body>
</html>