<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
// saram 테이블에서 name 필드가 'test'인 행 삭제하는 jdbc 구현.
Connection conn = JdbcUtil.getConnection();
// Statement를 상속 받음
//String sql="delete from saram where name=TEST";
String sql= "DELETE FROM SARAM WHERE NAME=?";
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setString(1,"TEST");

pstmt.executeUpdate();
JdbcUtil.close(conn, pstmt, null);
response.sendRedirect("TestJdbcUtil.jsp");
%>
</body>
</html>