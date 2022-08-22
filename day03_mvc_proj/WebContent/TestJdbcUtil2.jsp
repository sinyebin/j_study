<%@page import="java.sql.PreparedStatement"%>
<%@page import="org.constudy21.myweb.util.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 데이터가 테이블에 입력되도록 한다.
String name="TEST";
String phone = "010-1234-5555";
String email="test@aaa.com";
Connection conn = JdbcUtil.getConnection();
// Statement를 상속 받음
String sql="insert into saram (name,phone,email) values(?,?,?)";
PreparedStatement pstmt=conn.prepareStatement(sql);
// 변수를 대입한다
pstmt.setString(1,name);
pstmt.setString(2,phone);
pstmt.setString(3,email);

int cnt_result = pstmt.executeUpdate();
if(cnt_result>0){
	System.out.println("입력 성공!");
}else{
	System.out.println("입력 실패!");
}
JdbcUtil.close(conn, pstmt, null);
response.sendRedirect("TestJdbcUtil.jsp");
%>
</body>
</html>