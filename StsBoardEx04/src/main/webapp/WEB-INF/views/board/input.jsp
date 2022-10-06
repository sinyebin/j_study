<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/top.jsp" %>
    
    <h1>게시 글 입력</h1>
<form action="input" method="POST">
	<table class="table table-striped">
		<tr>
			<th>제목</th>
			<td><input type="text" size="20" maxlength="100" name="title" /></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><input type="text" size="30" maxlength="200" name="writer" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" size="67" maxlength="500" name="content" /></td>
		</tr>
		<tr>
			<td width="100" align="right"></td>
			<td><input type="submit" value="쓰기"/>
			<button type="button" onClick="location.href='list.do'">글 목록</button>
			</td>
		</tr>
	</table>
	
</form>    
       
<%@ include file="/inc/bottom.jsp" %>
   