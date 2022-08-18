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
<ul>
<a href="home.do">home</a>
<h1>상품 정보</h1>
<%
ShopDTO selectGoods = (ShopDTO)request.getAttribute("selectGoods");
%>
<li><%=selectGoods.getNo()%> | <%=selectGoods.getGoods() %> | <%=selectGoods.getPrice() %></li>

</ul>
<h1><a href="list.do">상품 목록</a></h1>
<h1><a href="delete.do?no=<%=selectGoods.getNo()%>">상품 삭제</a></h1>
<h1><a href="update.do?no=<%=selectGoods.getNo()%>">상품 수정</a></h1>
</body>
</html>