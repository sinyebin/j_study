<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입</h1>
<form action="join.do" method="POST">
<label for="">ID: </label>
	<input type="text" name="id" value=""/>
	<label for="">PW: </label>
	<input type="text" name="pw" value=""/>
	<label for="">NAME: </label>
	<input type="text" name="name" value=""/>
	<label for="">PHONE: </label>
	<input type="text" name="phone" value=""/>
	<label for="">EMAIL: </label>
	<input type="text" name="email" value=""/>
</form>
</body>
</html>