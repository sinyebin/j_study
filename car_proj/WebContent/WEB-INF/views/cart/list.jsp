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
<table border="1" width="100%">
<tr>
   <th>차종</th>
   <th>제조사</th>
   <th>가격</th>
   <th>수량</th>
</tr>
<c:forEach var="p" items="${cartList }">
   <tr align="center">
      <td>${p.proDTO.pname }</td><td>${p.proDTO.company}</td><td>${p.proDTO.price }</td>
      <td>${p.ea }</td>
   </tr>
</c:forEach>

</body>
</html>