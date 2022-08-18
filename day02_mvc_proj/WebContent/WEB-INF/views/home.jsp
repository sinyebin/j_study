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
<h3>Welcome</h3>
<h1>홈페이지 - home</h1>
<hr />
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

</body>
</html>