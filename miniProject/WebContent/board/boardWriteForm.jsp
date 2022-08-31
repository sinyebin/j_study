<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="form1" name="form1" method="get">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td width="40"><label for="subject">제목 </label> </td>
				<td>
					<textarea rows="1" cols="40" placeholder="제목을 입력하세요" required></textarea>
					<div id="idDiv"></div>
				</td>				
			</tr>
			<tr>
				<td width="40"><label for="content">내용 </label> </td>
				<td>
					<textarea rows="40" cols="70" placeholder="내용을 입력하세요" required></textarea>
				</td>				
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<input type="submit" value="글쓰기"/>
					<input type="reset" value="다시작성"/>
					<input type="button" value="목록" onclick="location.href='./boardList.jsp'"/>
				</td>
			</tr>
		</table>		
	</form>

</body>
</html>