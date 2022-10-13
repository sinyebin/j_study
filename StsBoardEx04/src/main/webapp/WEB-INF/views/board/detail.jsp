<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/top.jsp" %>

<h1>상세보기</h1>
<hr />
<table class="table table-striped">
	<tr>
		<th>번호</th>
		<td><c:out value="${board.seq }"></c:out></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><c:out value="${board.title }"></c:out></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td><c:out value="${board.cnt }"></c:out></td>
	</tr>
	<tr>
		<th>날짜</th>
		<td><c:out value="${board.regdate }"></c:out></td>
	</tr>
	<tr>
		<th>글쓴이</th>
		<td><c:out value="${board.writer }"></c:out></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<c:out value="${board.content }"></c:out>
			<c:if test="${board.fileName !=null}">
				<img src="/upload/${board.fileName }"/>
			</c:if>
		</td>
	</tr>
</table>
<hr/>
    <a href="modify?seq=${board.seq }">수정</a> | 
    <a href="delete?seq=${board.seq }">삭제</a> | 
    <a href="list">목록</a>
<%@ include file="/inc/bottom.jsp" %>
