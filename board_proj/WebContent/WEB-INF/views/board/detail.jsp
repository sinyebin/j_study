<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  method="POST">
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td width="100" align="right">작성자: &nbsp;</td>
			<td>${board.author }</td>
		</tr>
		<tr>
			<td width="100" align="right">전자메일: &nbsp;</td>
			<td>${board.email }</td>
		</tr>
		<tr>
			<td width="100" align="right">제목: &nbsp;</td>
			<td>${board.title }</td>
		</tr>
		<tr>
			<td width="100" align="right">작성일: &nbsp;</td>
			<td>${board.writeday }</td>
		</tr>
		<tr>
			<td width="100" align="right">내용: &nbsp;</td>
			<td>${board.content }</td>
		</tr>
		<tr>
			<td width="100" align="right">비밀번호: &nbsp;</td>
			<td><input type="password" size="10" maxlength="12"name="passwd" /></td>
			<td>&nbsp;(글 수정/삭제시 필요합니다)</td>
		</tr>
		<tr>
			<td width="100" align="right"></td>
			<td><button type="button" onClick="location.href='list.do'">글 목록</button>
			<button type="submit"  formaction="update.do?num=${board.num }">수정</button>
			<button type="submit"  formaction="delete.do?num=${board.num }">삭제</button>
			</td>
		</tr>
	</table>
	<input type="hidden" name="check" value="check" /> 
</form>
</body>
</html>