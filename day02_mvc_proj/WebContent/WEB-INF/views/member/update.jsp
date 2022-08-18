<%@page import="org.comstudy21.myweb.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원수정</h1>
<%
MemberDTO selectMem = (MemberDTO)request.getAttribute("selectMember");
%>
<form action="update.do" method="POST">
	<label for="">성명: </label>
	<input type="text" name="name" value="TEST"/>
	<label for="">연락처: </label>
	<input type="text" name="phone" value="010-1212-1112"/>
	<input type="submit" value="수정"/>
</form>
</body>
</html>