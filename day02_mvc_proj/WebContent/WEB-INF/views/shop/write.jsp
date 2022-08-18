<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품 등록</h1>
<form action="write.do" method="POST">
	<label for="">상품: </label>
	<input type="text" name="goods" value="상품"/>
	<label for="">가격: </label>
	<input type="text" name="price" value="2000"/>
	<input type="submit" value="등록"/>
</form>
</body>
</html>