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
<body class="container">
    <h1>슈퍼마켓</h1>
    <br />
    <div>
        <div id="body">				
		<label for="ename">상품</label>
		<input type="text" id="pname" name="pname" value="다이제"/>
		<br/>
		<label for="dept">가격</label>
		<input type="text" id="price" name="price" value="2000"/>
		<br/>
		<br/><br/>
        <button id="readBtn" class="btn btn-danger">새 상품 추가</button>
        <hr>
        <button class="choiceDel">선택 삭제</button>
        | 검색 :
		<select  class="keyword" id="searchCondition" name="searchCondition">
			<option value="pname">상품
			<option value="price">가격
		</select>
		<input type="text" class="search" />
        <table id="msg_list" border="1" class="table table-hover"></table>
    </div>
    <script>
    document.getElementById("msg_list").innerHTML = '출력'; 
	
    </script>
    </body>

</html>