<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>예약 등록</h1>
	<form action="register.do" method="post">
		<label for="">예약자 성명</label> 
		<input type="text" name="name"value="김고객2" /> 
		<label for="">전화 번호</label> 
		<input type="text"	name="phone" value="010-0000-0000" /> 
		<label for="">결제 상태</label> 
		<input type="radio" name="pay" value="미납" checked /> 미납 
		<input type="radio"	name="pay" value="완납" /> 완납
		<input type="submit" value="예약"/>
	</form>
</body>
</html>