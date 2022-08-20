<%@page import="org.restaurant.myweb.reserve.ProductDTO"%>
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
	<ul>
		<a href="home.do">home</a>
		<h1>길동이네 식당 메뉴 관리(관리용)</h1>
		<%
			List<ProductDTO> productList = (List<ProductDTO>) request.getAttribute("productList");
		for (ProductDTO product : productList) {
		%>
		<li><%=product.getRno()%> | <%=product.getRtitle()%> | <%=product.getRprice()%>
			<a href="update.do?no=<%=product.getRno()%>"> 수정 </a> <a
			href="delete.do?no=<%=product.getRno()%>">삭제</a></li>
		<%
			}
		%>
	</ul>
	<a href="write.do">메뉴 추가</a>
</body>
</html>