<%@page import="org.comstudy21.myweb.member.MemberDTO"%>
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
<h1>회원 목록</h1>
<%
List<MemberDTO> memList = (List<MemberDTO>)request.getAttribute("memList");
for(MemberDTO member: memList){
%>
<li><a href="detail.do?no=<%=member.getNo()%>"><%=member.getName() %></a></li>
<%
}
%>
</ul>
<a href="join.do">회원 등록</a>
</body>
</html>