<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp" %>

<h1>사용자 목록</h1>
<table class="table table-striped">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>역할</th>
	</tr>
	<c:forEach var="row" items="${list }">
		<tr>
			<td><c:out value="${row.id }"></c:out></td>
			<td><a href="detail?id=${row.id }"><c:out value="${row.name }"></c:out></a></td>
			<td><c:out value="${row.role }"></c:out></td>
		</tr>
	</c:forEach>
</table>
<%@ include file="/inc/bottom.jsp" %>