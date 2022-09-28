<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BBSLIST</h1>
<table border="1">
<thead>
<tr>
	<th >번호</th>
	<th >제목</th>
	<th >작성자</th>
	<th>이메일</th>
	<th>날짜</th>
</tr>
</thead>
<c:forEach var = "bbs" items="${boardList}">
	<tr>
		<td style="text-align:center">${bbs.num }</td>
		<td style="text-align:center">${bbs.title }</td>
		<td style="text-align:center">${bbs.author }</td>
		<td style="text-align:center">${bbs.email }</td>
		<td style="text-align:center">${bbs.writeday }</td>
	</tr>	
</c:forEach>
</table>
<a href="write.do">글쓰기</a>
</body>
</html>