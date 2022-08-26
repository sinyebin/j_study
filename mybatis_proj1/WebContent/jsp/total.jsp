<%@page import="mybatis.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@page import="mybatis.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL 적용 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width: 500px;
		border-collapse: collapse;
	}
	table, table th, table>tbody td {
		border: 1px solid black;
		padding: 4px;
	}
	table thead>tr:first-child>th { border: 0px; }
	
	#add_win, #update_win, #search_win {
		width: 250px;
		border: 1px solid black;
		background-color: #fff;
		position: absolute;
		top: 100px;
		left:580px;
		display: none;
	}
	
	#search_win {
		width: 500px;
		border: 1px solid black;
		background-color: #fff;
		position: absolute;
		top: 100px;
		left:580px;
		display: none;
	}
	
	#add_win input[type=text] {
		width: 90px;
		padding: 3px;
		border: 1px solid black;
		margin-bottom: 5px;
	}	
</style>
</head>
<body>
	<header>
		<h1>상품 목록</h1>
	</header>
	<article>
		<table>
			<caption>상품 목록을 위한 테이블</caption>
			<thread>
				<tr>
					<th colspan="4" style="text-align:right;">
						<input type="button" value="상품 추가" id="add_btn" onclick="addFun()"/>
						<input type="button" value="검색" id="search_btn" onclick="searchFun()"/>						
					</th>
				</tr>
				<tr>
					<th bgcolor="orange">상품</th>
					<th bgcolor="orange">가격</th>
					<th bgcolor="orange"></th>
					<th bgcolor="orange"></th>
				</tr>
			</thread>
			<tbody>
				<%
					List<ProductVO> list = ProductDAO.getTotal();
					request.setAttribute("list", list);
				%>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.pname }</td>
						<td>${vo.price }</td>
						<td width="60"><button onclick="showUpdate(${vo.pname},'${vo.price}')">수정</button></td>						
						<td width="60"><button onclick="location.href='delete.jsp?pno=${vo.pno}'">삭제</button></td>	
					</tr>
				</c:forEach>
			</tbody>			
		</table>
	</article>
	<div id="add_win">
		<header>
			<h2>상품 추가</h2>
		</header>
		<div id="body">
			<form name="addForm" method="POST" action="add.jsp">				
				<label for="pname">상품</label>
				<input type="text" id="pname" name="pname"/>
				<br/>
				
				<label for="price">가격</label>
				<input type="text" id="price" name="price"/>
				<br/>
							
				<input type="button" value="추가" id="append_btn" onclick="sendData()"/>
				<input type="button" value="취소" id="cancel_btn" onclick="closeWin()"/>
			</form>
			<br/>
		</div>
	</div>
	<script>
		function addFun(){
			var addWin=document.getElementById("add_win");
			addWin.style.display="block";
		}
		function sendData(){
			var pname=document.getElementById("pname").value;
			var price=document.getElementById("price").value;
			document.addForm.submit();
		}
		function closeWin(){
			var addWin = document.getElementById("add_win");
			addWin.style.display = "none";
		}
	
	
	</script>
	
</body>
</html>