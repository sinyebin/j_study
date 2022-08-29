<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		이름: ${param.name } <br/>
		나이: ${param.age } <br/>
		성별: 
		<c:if test="${param.gender=='0' }">
			남자
			<br/>
		</c:if>
		<c:if test="${param.gender=='1' }">
			여자
			<br/>
		</c:if>
		취미: 
		<c:forEach var="data" items="${paramValues.hobby }">	
			${data }
		</c:forEach>
		<br/>
		과목:
		<c:forEach var="data" items="${paramValues.subject }">	
			${data }
		</c:forEach>
		<br/>
		색깔: 
		<c:forEach var="data" items="${paramValues.color }">	
			${data }
		</c:forEach>
		<br/>
	</h3>
	<input type="button" value="다시 작성하기" onclick="javascript:history.go(-1)" />
	<input type="button" value="홈" onclick="javascript:history.go(-2)" />
</body>
</html>