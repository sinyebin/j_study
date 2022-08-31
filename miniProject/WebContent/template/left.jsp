<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#menubar{
	background: #ffe0e5;
	text-align: center;
}
#menubar ul{
	margin: 0;
	padding: 0;
	width: 100%;
}
#menubar ul li{
	display:inline-block;
	list-style-type:none;
	padding: 0px 15px;
}
#menubar ul li a{
	color:white;
	text-decoration: none;
}
#menubar ul li a:hover{
	background:aliceblue;
}
</style>
</head>
<body>
<div id="menubar">
	<ul>
	<li><a href="./member/writeForm.jsp">회원가입</a></li>
	<li><a href="./member/loginForm.jsp">로그인</a></li>
	<li><a href="#">로그아웃</a></li>
	<li><a href="#">회원정보수정</a></li>
	<li><a href="./board/boardWriteForm.jsp">글쓰기</a></li>
	<li><a href="./board/boardList.jsp">목록</a></li>
	</ul>
</div>
</body>
</html>