<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>중고차 쇼핑몰</h1>
<hr />
<%
String id=(String)session.getAttribute("login.id");
if(id!=null){
	%>
	<p><%=id %>님 환영합니다.</p>
	<li><a href="/car_proj/login/logout.do">로그아웃</a></li>
		<ul>
<%
	Map items = (Map)request.getAttribute("items");
	Set keys = items.keySet();
	Iterator iterator = keys.iterator();
	while(iterator.hasNext()){
		String key = (String)iterator.next();
%>
<!-- HTML 코드 -->
	<li><a href="<%=items.get(key) %>"><%=key %></a></li>
<%		
	}
%>
</ul>
<%}else{
	%><li><a href="/car_proj/login/loginpage.do">로그인</a></li>
	
<%}

%>


</body>
</html>