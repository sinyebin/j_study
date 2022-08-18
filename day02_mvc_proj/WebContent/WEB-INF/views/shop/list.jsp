<%@page import="org.comstudy21.myweb.shop.ShopDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="home.do">home</a>
<h1>상품 목록</h1>
<%
//set한 값 가져오기
List<ShopDTO> shopList = (List<ShopDTO>)request.getAttribute("shopList");
for(ShopDTO shop:shopList){ //for each문으로 전체 출력
%>
<li><a href="detail.do?no=<%=shop.getNo()%>"> <%=shop.getGoods() %></a> </li>
<%
}
%>
</ul>
<a href="write.do">상품 등록</a>
</body>
</html>