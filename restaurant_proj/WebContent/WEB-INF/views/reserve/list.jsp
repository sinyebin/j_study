<%@page import="org.restaurant.myweb.people.PeopleDTO"%>
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
		<h1>예약 내역 조회</h1>
		<%
			List<PeopleDTO> peopleList = (List<PeopleDTO>) request.getAttribute("peopleList");
		for (PeopleDTO people : peopleList) {
		%>
		<li><%=people.getPno()%> | <%=people.getName()%> | <%=people.getPhone()%>
			|<%
			if (people.isRpay()){
			%> 완납 <%
			} else {
		%> 미납<%
			}
		%> | <%=people.getProduct().toString()%>
			<a href="delete.do?no=<%=people.getPno()%>">삭제</a></li>
		<%
			}
		%>
	</ul>
	<a href="register.do">예약 등록</a>|
	<a href="home.do">home</a>
</body>
</html>