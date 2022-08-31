<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.nav{
	width: 20%;
	height:70%;
	float:left;

}
</style>
</head>
<body>
<nav class = "nav">
	<form action = "/miniProject/index.jsp" id="form1" name="form1" method="get">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td width="70"><label for="id">ID </label> </td>
				<td>
					<input type="text" name="id" id="id" required style="color:blue;"/>
				</td>				
			</tr>
			<tr>
				<td width="70"><label for="pw">비밀번호 </label> </td>
				<td>
					<input type="text" name="pw" id="pw" required style="color:blue;"/>
				</td>				
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<input type="submit" value="로그인"/>
					<input type="button" value="회원가입" onclick="location.href='/miniProject/member/writeForm.jsp'"/>
				</td>
			</tr>
		</table>		
	</form>
</nav>
</body>
</html>