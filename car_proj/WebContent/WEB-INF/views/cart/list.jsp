<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>장바구니 목록</h1>

<c:forEach var="car" items="${cartList }">
<p><c:out value="${car }"></c:out><a href="cart_process.jsp?cmd=remove&pno=${car.pno }&ea=0">제거</a></p>
</body>
</html>