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
<ul>
<a href="home.do">home</a>
<h1>회원 정보</h1>
<%
MemberDTO selectMem = (MemberDTO)request.getAttribute("selectMember");
%>
<li><%=selectMem.getNo()%> | <%=selectMem.getName() %> | <%=selectMem.getPhone() %></li>

</ul>
<h1><a href="list.do">회원 목록</a></h1>
<h1><a href="delete.do?no=<%=selectMem.getNo()%>">회원 삭제</a></h1>
<h1><a href="update.do?no=<%=selectMem.getNo()%>">회원 수정</a></h1>
</body>
</html>