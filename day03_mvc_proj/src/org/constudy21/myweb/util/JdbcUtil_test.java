package org.constudy21.myweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil_test {
	public static void main(String[] args) {
		String url = "jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="12345";
		Connection conn=null;
		
		//드라이버
		try {
			Class.forName("org.h2.Driver");
			//System.out.println("드라이버 검색 성공!");
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println(conn);
		} catch (ClassNotFoundException e) {
			//System.out.println("드라이버 검색 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			//System.out.println("접속 실패!");
			e.printStackTrace();
		}
	}
}
