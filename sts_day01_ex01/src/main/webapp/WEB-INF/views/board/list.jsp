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

<h1>게시글 목록</h1>
<table border="1">
   <tr>
      <th>번호</th>
      <th>제목</th>
      <th>글쓴이</th>
      <th>날짜</th>
   </tr>
   <c:forEach var="row" items="${boardList }">
      <tr>
         <td><c:out value="${row.seq }"></c:out></td>
         <td><a href="detail.do?seq=${row.seq }"><c:out value="${row.title }"></c:out></a></td>
         <td><c:out value="${row.writer }"></c:out></td>
         <td><c:out value="${row.regDate }"></c:out></td>
      </tr>
   </c:forEach>
</table>
</body>
</html>