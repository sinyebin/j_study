<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/top.jsp" %>
    
    <h1>내용 수정</h1>    
<form action="modify?seq=${board.seq }" method="POST">
	<table class="table table-striped">
		<tr>
			<td width="100" align="right"> 제목: &nbsp;	</td>
			<td><input type="text" size="20" maxlength="100" name="title" value=${board.title } /></td>
		</tr>
		<tr>
			<td width="100" align="right"> 글쓴이: &nbsp;	</td>
			<td><input type="text" size="30" maxlength="200" name="writer" value=${board.writer } /></td>
		</tr>
		<tr>
			<td width="100" align="right"> 내용: &nbsp;	</td>
			<td><input type="text" size="67" maxlength="500" name="content" value=${board.content } /></td>
		</tr>
		<tr>
			<td width="100" align="right"></td>
			<td><input type="submit" value="수정"/></td>
		</tr>
	</table>
	<input type="hidden" name="check" value="modify" /> 
</form>    
    
<%@ include file="/inc/bottom.jsp" %>
    