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
<form action="/mybatis_proj2/product/add">
<div>
	<div id="body">
		<label for="pname">상품</label>
		<input type="text" id="pname" name="pname" value="핫브레이크"/>
		<br />
		<label for="ename">금액</label>
		<input type="text" id="price" name="price" value="1500"/>
		<br />
		<input type="submit" value="상품 추가" />
		<br />
		<br />
	</div>
</div>
</form>

<table border="1">
<thead>
<tr>
	<th width="20%">상품 번호</th>
	<th width="50%">상품</th>
	<th width="20%">가격</th>
	<th width="10%">삭제</th>
</tr>
</thead>
<c:forEach var = "pro" items="${list }">
	<tr>
		<td style="text-align:center">${pro.pno }</td>
		<td style="text-align:center">${pro.pname }</td>
		<td style="text-align:center">${pro.price }</td>
		<td style="text-align:center"><button onclick="location.href='/mybatis_proj2/product/delete?pno=${pro.pno}'">삭제</button></td>
	</tr>	
</c:forEach>
</table>

</body>
</html>