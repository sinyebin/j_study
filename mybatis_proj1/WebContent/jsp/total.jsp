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
	<div id="search_win">
		<header>
			<h2>상품 검색</h2>
		</header>
		<div id="body">
			<form name="searchForm" method="POST" action="search.jsp">
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right">
							<select id="searchCondition" name="searchCondition">
								<option value="pname">상품
								<option value="price">가격
							</select>
							<input id="searchKeyword" name="searchKeyword" type="text" style="width:100px;"/>
							<input type="button" value="조건 검색" id="search_submit_btn" onclick="sendDataOfSearch()"/>
						</td>
					</tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0" id="search_result">
					<tr>
						<th bgcolor="orange" width="100">상품번호</th>
						<th bgcolor="orange" width="150">상품</th>
						<th bgcolor="orange" width="150">가격</th>
					</tr>
					<c:forEach var="vo" items="${searchList}">								
						<tr>
							<td>${vo.pno}</td>
							<td>${vo.pname}</td>
							<td>${vo.price}</td>		
						</tr>
					</c:forEach>					
				</table>
				<br/>						
				<input type="button" value="취소" id="search_cancel_btn" onclick="closeWinOfSearch()"/>	
			</form>
		</div>	
	</div>
	<%
		/*
			search.jsp 페이지에서  true 넘어옴!!
			response.sendRedirect("total.jsp?search_win_is_show=true");
		*/
		String search_win_is_show = request.getParameter("search_win_is_show");
		if(search_win_is_show != null) {
	%>
		<script>
			var searchWin = document.getElementById("search_win");
			searchWin.style.display = "block";
		</script>
	<%
		} // end of if
	%>
	<script type="text/template" id="result_table_tmp">
		<tr>
			<th bgcolor="orange" width="100">상품 번호</th>
					<th bgcolor="orange" width="150">상품</th>
					<th bgcolor="orange" width="150">가격</th>
		</tr>
	</script>
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
		function searchFun(){
			var xhr = new XMLHttpRequest();
			xhr.onload = function(){
				var searchWin=document.getElementById("search_win");
				searchWin.style.display="block";
				document.getElementById("search_result").innerHTML = 
					document.getElementById("result_table_tmp").innerHTML;
			}
			xhr.open("GET","search_result_init.jsp",true);
			xhr.send();
		}
		function sendDataOfSearch(){
			var searchCondition = document.getElementById("searchCondition").value;
			var searchKeyword = document.getElementById("searchKeyword").value;
			
			document.searchForm.submit();	
		}
		function closeWinOfSearch() {
			var updateWin = document.getElementById("search_win");
			updateWin.style.display = "none";
		}
	</script>
	
</body>
</html>