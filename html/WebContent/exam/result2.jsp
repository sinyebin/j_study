<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="../img/img2.png" width="30" height="30" onclick="location.href='../index.jsp'" style="cursor:pointer">
	<h3>
		${param.x }+${param.y } = ${param.x+param.y } <br/>		
	</h3>
	<input type="button" value="다시 계산하기" onclick="javascript:history.go(-1)" />
</body>
</html>