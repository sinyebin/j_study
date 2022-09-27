<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="write.do" method="POST">
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td width="100" align="right"> 작성자: &nbsp;	</td>
			<td><input type="text" size="20" maxlength="100" name="author" /></td>
		</tr>
		<tr>
			<td width="100" align="right"> 전자메일: &nbsp;	</td>
			<td><input type="text" size="30" maxlength="200" name="email" /></td>
		</tr>
		<tr>
			<td width="100" align="right"> 제목: &nbsp;	</td>
			<td><input type="text" size="67" maxlength="500" name="title" /></td>
		</tr>
		<tr>
			<td width="100" align="right" valign="top"><br> 내용: &nbsp;	</td>
			<td><textarea rows="10" cols="65" maxlength="4000" name="content" ></textarea></td>
		</tr>
		<tr>
			<td width="100" align="right"> 비밀번호: &nbsp;	</td>
			<td><input type="password" size="10" maxlength="12" name="passwd" /></td>
			<td>&nbsp;(글 수정/삭제시 필요합니다)</td>
		</tr>
		<tr>
			<td width="100" align="right"></td>
			<td><input type="submit" value="쓰기"/></td>
		</tr>
	</table>
	
</form>
</body>
</html>