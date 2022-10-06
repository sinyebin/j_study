<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/top.jsp" %>

<h1>상세보기</h1>
<hr />
<table class="table table-striped">
	<tr>
		<th>아이디</th>
		<td><c:out value="${user.id }"></c:out></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><c:out value="${user.password }"></c:out></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><c:out value="${user.name }"></c:out></td>
	</tr>
	<tr>
		<th>역할</th>
		<td><c:out value="${user.role }"></c:out></td>
	</tr>
</table>
<hr/>
    <a href="modify?id=${user.id }">수정</a> | 
    <a href="delete?id=${user.id }">삭제</a> | 
    <a href="list">목록</a>
<%@ include file="/inc/bottom.jsp" %>
