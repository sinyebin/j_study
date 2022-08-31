<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action = "/miniProject/index.jsp" id="form1" name="form1" method="get">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td width="70"><label for="name">이름</label> </td>
				<td>
					<input type="text" name="name" id="name" placeholder="이름 입력"  />
					<div id="nameDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="id">ID </label> </td>
				<td>
					<input type="text" name="id" id="id"  placeholder="아이디 입력"/>
					<input type="button" value="중복체크" />
					<div id="idDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="pw">비밀번호 </label> </td>
				<td>
					<input type="password" name="pw" id="pw"  placeholder="비밀번호 입력"/>
					<div id="pwDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="rePw">재확인 </label> </td>
				<td>
					<input type="password" name="rePw" id="rePw"  placeholder="비밀번호 재입력"/>
					<div id="rePwDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="gender">성별</label> </td>
				<td>
					<input type="radio" name="gender" id="gender_m" value="0" checked />
					<label for="gender_m">남자</label>
					<input type="radio" name="gender" id="gender_f" value="1" />
					<label for="gender_f">여자</label>
				</td>
			</tr>
			<tr>
				<td width="70"><label for="email">이메일</label> </td>
				<td>
					<input type="text" name="email1" id="email1"/> @ <input type="text" name="email2" id="email2" placeholder="직접 입력"/>
				</td>
			</tr>
			<tr>
				<td width="70"><label for="phone">핸드폰</label> </td>
				<td>
					<select name="phone1" id="phone1" style="width: 80px">
						<option value="010" selected>010</option>
						<option value="011">011</option>
						<option value="019">019</option>					
					</select>
					<input type="text" style="width:80px" name="phone2" id="phone2"/>
					<input type="text" style="width:80px" name="phone3" id="phone3"/>
				</td>
			</tr>
			<tr>
				<td width="70"><label for="address">주소</label> </td>
				<td>
					<input type="text" readonly/> <input type="button" value="우편번호검색" /> <br />
					<input type="text" readonly placeholder="주소" style="width:350px"/><br />
					<input type="text" placeholder="상세주소" style="width:350px" name="address" id="address"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<input type="button" value="회원가입" onclick="input()"/>
					<input type="reset" value="다시작성" />
				</td>
			</tr>
		</table>		
	</form>
	<script type="text/javascript">
		function input(){
			if(document.getElementById("name").value==""){
				document.getElementById("nameDiv").innerText="이름을 입력하세요";
				document.form1.name.focus();
				return;
			}else if(document.getElementById("id").value==""){
				document.getElementById("idDiv").innerText="아이디를 입력하세요";
				document.form1.id.focus();
				return;
			}else if(document.getElementById("pw").value==""){
				document.getElementById("pwDiv").innerText="비밀번호를 입력하세요";
				document.form1.pw.focus();
				return;
			}else if(document.getElementById("rePw").value==""){
				document.getElementById("rePwDiv").innerText="재확인을 입력하세요";
				document.form1.rePw.focus();
				return;
			}else if(document.getElementById("rePw").value!=document.getElementById("pw").value){
				document.getElementById("rePwDiv").innerText="비밀번호를 확인하세요";
				document.form1.rePw.focus();
				return;
			}else {
				document.form1.submit();
			}
		}
	</script>
</body>
</html>