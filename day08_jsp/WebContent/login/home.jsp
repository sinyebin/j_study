<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userId = (String)session.getAttribute("id");
String userName = (String)session.getAttribute("name");

String userId_app = (String)application.getAttribute("appId");
String userName_app = (String)application.getAttribute("appName");
%>

User ID : <%=userId %><br/>
User Name : <%=userName %><br />
<hr/>
User ID(application) : <%=userId_app %><br/>
User Name(application) : <%=userName_app %><br />
<hr/>
<a href="logout.jsp">Log out</a>
<a href="login.html">Log in</a>
</body>
</html>