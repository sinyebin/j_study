<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		var rootUrl = location.href;
	    var rootUri = rootUrl.substr(0, rootUrl.lastIndexOf("/"));
	</script>
</head>
<body>
<div>
	<div id="body">
		<label for="pname">상품</label>
		<input type="text" id="pname" name="pname" value="핫브레이크"/>
		<br />
		<label for="ename">금액</label>
		<input type="text" id="price" name="price" value="1500"/>
	</div>



</div>
<c:forEach var = "pro" items="${list }">
	<tr>
		<td>${pro.pno }</td>
		<td>${pro.pname }</td>
		<td>${pro.price }</td>
	</tr>	
</c:forEach>
</body>
</html>