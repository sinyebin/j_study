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
<ul>
<a href="home.do">home</a>
<%
BoardDTO selectTitle = (BoardDTO)request.getAttribute("selectTitle");
%>
<h1><%=selectTitle.getNo()%></h1>
<li><%=selectTitle.getTitle() %></li>
<%=selectTitle.getContent() %>
</ul>
<h1><a href="list.do">글 목록</a></h1>
<h1><a href="delete.do?no=<%=selectTitle.getNo()%>">글 삭제</a></h1>
<h1><a href="update.do?no=<%=selectTitle.getNo()%>">글 수정</a></h1>
</body>
</html>