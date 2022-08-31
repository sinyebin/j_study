<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	 border: 1px solid #444444;
	 border-collapse:collapse;
}
th{
	border: 1px solid #444444;
}
td, th{

	text-align:center;
	padding:5px;
	height:15px
}
td, th:nth-child(1){
	width: 5px;
}
td, th:nth-child(2){
	width: 250px;
}
td, th:nth-child(3){
	width: 130px;
}
td, th:nth-child(4){
	width: 130px;
}
td, th:nth-child(5){
	width: 130px;
}
tbody td{
	border-left: 1px solid #444444;
}
tbody tr:nth-child(even){ /*1번부터*/
	 background: pink;
}
tbody tr:hover{
	background: aliceblue;
}
</style>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>	
		</tr>
		<tbody>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</thead>
</table>
<br />
<input type="button" value="홈" onclick="location.href='../index.jsp'"/>
<input type="button" value="글쓰기" onclick="location.href='./boardWriteForm.jsp'"/>
</body>
</html>