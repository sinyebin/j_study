<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메뉴 추가</h1>
<form action="write.do" method="POST">
	<label for="">예약 명: </label>
	<input type="text" name="rtitle" value=""/>
	<label for="">금액: </label>
	<input type="text" name="rprice" value=""/>
	<input type="submit" value="등록"/>
</form>
</body>