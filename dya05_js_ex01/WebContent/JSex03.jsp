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
	<input type="text" id="no" value="4" size="4" />
	<input type="text" id="name" value="ahn" size="4" />
	<input type="text" id="phone" value="010-1234-4444" size="8" />
	<input type="text" id="email" value="email@b.com" size="6" />
	<input type="button" value="Add" id="add_btn" />
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
var okBtn = document.querySelector(".okBtn");
var addBtn = document.querySelector("#add_btn");
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
const $ = function(selector) {
	   let domSel = document.querySelectorAll(selector);
	   
	   if(domSel.length == 1){
	      return domSel[0];
	   } else {
	      return domSel;
	   }
	};

	var maxNo = -1000;
	const loadDataFn = function() {
	   tbl.innerHTML = "";
	   rowList.forEach(function(item) {
	      if(Number(maxNo) < item.no) {
	         maxNo = Number(item.no);
	      }
	      let tempStr = `<tr>
	         <td>\${item.no}</td>
	         <td>\${item.name}</td>
	         <td>\${item.phone}</td>
	         <td>\${item.email}</td>
	      </tr>`;
	      tbl.innerHTML += tempStr;
	   });
	   $('#no').value = Number(maxNo)+1;
	}

	addBtn.onclick = function() {
	   const newData = {
	      no: $('#no').value,
	      name:$('#name').value,
	      phone:$('#phone').value,
	      email: $('#email').value
	   }
	   rowList.push(newData);
	   loadDataFn();
	}

	</script>
</body>
</html>