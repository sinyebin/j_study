<%@page import="org.constudy21.myweb.model.SaramDTO"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
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
	Connection conn = JdbcUtil.getConnection();
	
	//saram 테이블 내용 읽어 오기
	Statement stmt=conn.createStatement();
	ResultSet rs = stmt.executeQuery("Select*from saram");
	while(rs.next()){
		int id=rs.getInt("id");
		String name=rs.getString("name");
		String phone=rs.getString("phone");
		String email=rs.getString("email");
		SaramDTO dto = new SaramDTO(id,name,phone,email);
		out.println(dto);
				
	}
	JdbcUtil.close(conn, stmt, rs);
	
%>
</body>
</html>