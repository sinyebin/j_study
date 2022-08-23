package org.restaurant.myweb.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.restaurant.myweb.DAO;
import org.restaurant.myweb.controller.JdbcUtil;
interface sqlInterface extends DAO<MemberDTO> {
	String SELECT = "SELECT * FROM MEM";
	String INSERT = "INSERT INTO MEM(mno, id,pw, name, phone, email)VALUES(NEXTVAL('SEQ_MEM'),?,?,?,?,?)";
	String DELETE = "DELETE FROM MEM WHERE MNO=?";
	String SELECT_ONE = "SELECT * FROM MEM WHERE MNO=?";
	String UPDATE = "UPDATE MEM SET id=?, pw=?, name=?, phone=?,email=? WHERE mno=?";
	String SEARCH_ID = "SELECT count(*) num FROM MEM WHERE ID=?";
	String CHECK_LOGIN = "SELECT PW passwd FROM MEM WHERE ID=?";
}
public class MemberDAO implements sqlInterface {
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	@Override
	public List<MemberDTO> selectAll() throws SQLException {
		List<MemberDTO> memList=new ArrayList<MemberDTO>();
		conn = JdbcUtil.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT);
		while(rs.next()) {
			MemberDTO dto=new MemberDTO();
			dto.setMno(rs.getInt("MNO"));
			dto.setId(rs.getString("ID"));
			dto.setPw(rs.getString("PW"));
			dto.setName(rs.getString("NAME"));
			dto.setPhone(rs.getString("PHONE"));
			dto.setEmail(rs.getString("EMAIL"));
			memList.add(dto);
		}
		JdbcUtil.close(conn, stmt, rs);
		return memList;
	}

	@Override
	public MemberDTO selectOne(int no) throws SQLException {
		MemberDTO dto = new MemberDTO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			dto = new MemberDTO();
			dto.setMno(rs.getInt("MNO"));
			dto.setId(rs.getString("ID"));
			dto.setPw(rs.getString("PW"));
			dto.setName(rs.getString("NAME"));
			dto.setPhone(rs.getString("PHONE"));
			dto.setEmail(rs.getString("EMAIL"));
		}
		JdbcUtil.close(conn, stmt, rs);
		return dto;
	}

	@Override
	public void insert(MemberDTO dto)throws SQLException{
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(INSERT);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getPhone());
		pstmt.setString(5, dto.getEmail());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}
		JdbcUtil.close(conn, stmt, rs);
	}

	@Override
	public void update(MemberDTO dto) throws SQLException {
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(UPDATE);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getPhone());
		pstmt.setString(5, dto.getEmail());
		pstmt.setInt(6, dto.getMno());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("update success");
		} else {
			System.out.println("update fail");
		}
		JdbcUtil.close(conn, stmt, rs);
	}

	@Override
	public void delete(int no) throws SQLException {
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
	public boolean searchID(String id)throws SQLException{
		boolean check=true;
		conn = JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(SEARCH_ID);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		rs.next();
		int p=rs.getInt("num");
		if (p > 0) {
			check=false;
		}
		JdbcUtil.close(conn, stmt, rs);
		
		return check;
	}
	public boolean login_Ok(String id, String pw)throws SQLException{
		boolean check = true;
		conn = JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(CHECK_LOGIN);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		rs.next();
		String p=rs.getString("passwd");
		if(!p.equals(pw)) {
			check=false;
			System.out.println(p +" "+pw);
			System.out.println("다름");
		}
		JdbcUtil.close(conn, stmt, rs);
		return check;
	}
}
