<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="join.do" method="POST">
	<label for="">성명: </label>
	<input type="text" name="name" value="TEST"/>
	<label for="">연락처: </label>
	<input type="text" name="phone" value="010-1212-1112"/>
	<input type="submit" value="등록"/>
</form>
</body>
</html>