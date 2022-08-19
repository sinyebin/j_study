<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th, td {
	border: 1px solid gray;
}

table {
	width: 100%;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<button class="okBtn">Load Data</button>
	<hr />
	<table class="tbl">
   <thead>
      <tr>
         <th>NO</th>
         <th>NAME</th>
         <th>PHONE</th>
         <th>EMAIL</th>
      </tr>
   </thead>
   <tbody></tbody>
</table>

	<script>
var okBtn=document.querySelector(".okBtn");
var tbl = document.querySelector(".tbl tbody");
const rowList =[ { //자바스크립트 객체 map과 비슷
		no:1,
		name:'Kim',
		phone:'010-1111-1234',
		email:"kim@a.com"
},{
	no:2,
	name:'Lee',
	phone:'010-1111-1234',
	email:"lee@a.com"
},{
	no:3,
	name:'Park',
	phone:'010-1111-1234',
	email:"park@a.com"
}];
console.log(okBtn);
okBtn.onclick=function(){//html에 글씨 추가
	   tbl.innerHTML = "";
	rowList.forEach(function(item){
	let tempStr= `<tr> 
		<td>\${item.no}</td>
		<td>\${item.name}</td>
		<td>\${item.phone}</td>
		<td>\${item.email}</td>
		</tr>`;
	tbl.innerHTML += tempStr; 
});
	

	
	
}
</script>
</body>
</html>