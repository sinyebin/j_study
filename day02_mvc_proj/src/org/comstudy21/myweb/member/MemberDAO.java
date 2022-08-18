package org.comstudy21.myweb.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.comstudy21.myweb.controller.JdbcUtil;




public class MemberDAO {
	public static final String SELECT = "SELECT * FROM MEMBER";
	public static final String INSERT = "INSERT INTO MEMBER(NAME,PHONE)VALUES(?,?)";
	public static final String UPDATE = "UPDATE MEMBER SET NAME=?, PHONE=? WHERE NO=?";
	public static final String SELECT_ONE = "SELECT * FROM MEMBER WHERE NO=?";
	public static final String DELETE = "DELETE FROM MEMBER WHERE NO=?";
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public static List<MemberDTO> selectAll() throws SQLException {
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		conn = JdbcUtil.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT);
		while (rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			memberList.add(dto);

		}
		//System.out.println(memberList);
		JdbcUtil.close(conn, stmt, rs);
		return memberList;
	}
	public static void insert(MemberDTO dto) throws SQLException {
		conn=JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(INSERT);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPhone());
		int cnt=pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}

		JdbcUtil.close(conn, stmt, rs);
	}
	   
	public static MemberDTO selectOne(int no) throws SQLException{
		MemberDTO memdto=new MemberDTO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			memdto = new MemberDTO();
			memdto.setNo(rs.getInt("no"));
			memdto.setName(rs.getString("name"));
			memdto.setPhone(rs.getString("phone"));
		}
		JdbcUtil.close(conn, stmt, rs);
		return memdto;
	}
	   
	public static void update(MemberDTO dto) throws SQLException {
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(UPDATE);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPhone());
		pstmt.setInt(3, dto.getNo());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("update success");
		} else {
			System.out.println("update fail");
		}
		JdbcUtil.close(conn, stmt, rs);
	}
	   
	public static void delete(int no)throws SQLException {
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(DELETE);
		pstmt.setInt(1, no);
		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("delete success");
		} else {
			System.out.println("delete fail");
		}
		JdbcUtil.close(conn, stmt, rs);
	}

}
