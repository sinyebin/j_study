<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%!// 데클라레이션 (선언 부)
   // Class의 멤버 필드 및 메소드 선언%>
<%
   // 스크립트 릿 (함수 실행 부분)
// 서비스 메소드 내부
String title = "즐겁고 행복한 JSP 코딩 수업";
String id = "HONG";
String passwd = "1234";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title%></title>
</head>
<body>
   <h1><%=title%></h1>
<%
session.setAttribute("id", id);
session.setAttribute("name", "홍길동");

application.setAttribute("appId", id);
application.setAttribute("appName", "김길동");

response.sendRedirect("home.jsp");
%>
</body>
</html>