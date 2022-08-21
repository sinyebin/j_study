<%@page import="org.restaurant.myweb.product.ProductDTO"%>
<%@page import="java.util.List"%>
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
	<form action="register_cust.do" method="post">
		<p>
			<label for="">예약자 성명</label> <input type="text" name="name"
				value="김고객2" />
		</p>
		<p>
			<label for="">예약 상품</label> <select name="rno">
				<%
					List<ProductDTO> productList = (List<ProductDTO>) request.getAttribute("productList");
				for (ProductDTO product : productList) {
				%>
				<option value=<%=product.toString()%>><%=product.toString()%></option>
				<%
					}
				%>
			</select>
		</p>
		<p>
			<label for="">전화 번호</label> <input type="text" name="phone"
				value="010-0000-0000" />
		</p>
		<p>
			<label for="">결제 상태</label> <input type="radio" name="pay" value="FALSE"
				checked /> 미납 <input type="radio" name="pay" value="True" /> 완납
		</p>
		<p>
			<input type="submit" value="예약" />
		</p>
	</form>
</body>
</html>