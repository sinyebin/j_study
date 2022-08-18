<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 작성</h1>
<form action="write.do" method="POST">
	<label for="">제목: </label>
	<input type="text" name="title" value="TEST"/>
	<label for="">내용: </label>
	<input type="text" name="content" value="내용"/>
	<input type="submit" value="등록"/>
</form>
</body>
</html>