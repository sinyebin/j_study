<%@page import="org.comstudy21.myweb.bbs.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 수정</h1>
<%
BoardDTO selectTitle = (BoardDTO)request.getAttribute("selectTitle");
%>
<form action="update.do" method="POST">
	<label for="">제목: </label>
	<input type="text" name="title" value="title"/>
	<label for="">내용: </label>
	<input type="text" name="content" value="content"/>
	<input type="submit" value="수정"/>
</form>
</body>
</html>