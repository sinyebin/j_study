<%@page import="org.comstudy21.myweb.bbs.BoardDTO"%>
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
<h1>게시글 목록</h1>
<%
//set한 값 가져오기
List<BoardDTO> boardList = (List<BoardDTO>)request.getAttribute("boardList");
for(BoardDTO board:boardList){ //for each문으로 전체 출력
%>
<li><a href="content.do?no=<%=board.getNo()%>"><%=board.getTitle() %></a></li>
<%
}
%>
</ul>
<a href="write.do">글쓰기</a>
</body>
</html>