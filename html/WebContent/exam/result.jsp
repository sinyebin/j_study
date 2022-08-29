<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		당신의 이름은 ${param.user_name } 입니다. 
		<br /> 
		<input type="button" value="뒤로" onclick="javascript:history.go(-1)" />
	</h3>
</body>
</html>