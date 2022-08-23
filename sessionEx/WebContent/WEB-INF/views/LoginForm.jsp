<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="GET">
		<input type="hidden" name="address" value="서울"> <input
			type="hidden" name="email" value="test@a.b"> <input
			type="hidden" name="tel" value="111-2222">
		<h1>Login Form</h1>
		<table border="1" cellpadding="5" cellspacing="0" width="600"
			bordercolordark="white">
			<tr>
				<td width="200">
					<p align="right">사용자 아이디</p>
				</td>
				<td width="400"><input type="text" name="userID" /></td>
			</tr>
			<tr>
				<td width="200">
					<p align="right">비밀번호</p>
				</td>
				<td width="400"><input type="password" name="passwd" /></td>
			</tr>
			<tr>
				<td width="200">
					<p>&nbsp;</p>
				</td>
				<td width="400"><input type="submit" value="전송" /><input
					type="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>