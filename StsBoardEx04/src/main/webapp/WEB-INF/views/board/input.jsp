<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/top.jsp" %>
    
    <h1>새 글 입력</h1>
    
	<form action="input" method="post" enctype="multipart/form-data">
		<table class="table table-striped">
			<tr>
				<th>제목</th>
				<td><input name="title" value="새글 입력 연습" /></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input name="writer" value="홍길동" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="8" cols="50">새글 입력 연습입니다.</textarea></td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input multiple type="file" name="uploadFile" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><div id="previewImg">사진 미리보기 공간</div></td>
			</tr>
		</table>
		<input type="submit" value="입력 완료">
	</form>
	
<%@ include file="/inc/bottom.jsp" %>
   