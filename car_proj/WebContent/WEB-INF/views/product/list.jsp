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
<h1>중고차 매물 정보</h1>
<table border="1" width="100%">
<tr>
   <th>순서</th>
   <th>차종</th>
   <th>제조사</th>
   <th>가격</th>
   <th>수량</th>
   <th>장바구니</th>
</tr>
<c:forEach var="p" items="${productList }">
   <tr align="center">
      <td>${p.pno }</td><td>${p.pname }</td><td>${p.company }</td>
      <td>${p.price }</td>
      <td>
         <select name="ea">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
         </select>
      </td>
      <td><a href="#" onclick="addCart(this, ${p.pno })">장바구니 담기</a></td>
   </tr>
</c:forEach>

<script>
// 바닐라 스크립트 (바닐라 아이스크림)
function addCart(row, pno) {
   var trEl = row.parentElement.parentElement;
   var ea = trEl.querySelector("select[name=ea]").value;
   var addCartUrl = "cart/add.do?cmd=add&pno="+pno+"&ea="+ea;
   location.assign(addCartUrl);
}
</script>
</table>
</body>
</html>