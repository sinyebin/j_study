package org.constudy21.myweb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.constudy21.myweb.util.JdbcUtil;

public class SaramDAO {

	public static final String SELECT = "SELECT * FROM SARAM";
	public static final String INSERT = "INSERT INTO SARAM(NAME,PHONE,EMAIL)VALUES(?,?,?)";
	public static final String UPDATE = "UPDATE SARAM SET NAME=?, PHONE=?, EMAIL=? WHERE ID=?";
	public static final String SELECT_ONE = "SELECT * FROM SARAM WHERE ID=?";
	public static final String SELECT_NAME = "SELECT * FROM SARAM WHERE NAME=?";
	public static final String DELETE = "DELETE FROM SARAM WHERE ID=?";

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<SaramDTO> selectAll() throws SQLException {
		List<SaramDTO> saramList = new ArrayList<SaramDTO>();
		conn = JdbcUtil.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT);
		while (rs.next()) {
			SaramDTO dto = new SaramDTO();
			dto.setId(rs.getInt("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			saramList.add(dto);

		}
		JdbcUtil.close(conn, stmt, rs);
		return saramList;
	}

	public SaramDTO selectOne(int id) throws SQLException {
		SaramDTO saramdto = new SaramDTO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			saramdto = new SaramDTO();
			saramdto.setId(rs.getInt("id"));
			saramdto.setName(rs.getString("name"));
			saramdto.setPhone(rs.getString("phone"));
			saramdto.setEmail(rs.getString("email"));

		}
		JdbcUtil.close(conn, stmt, rs);
		return saramdto;
	}

	public SaramDTO findByName(String name) throws SQLException {
		SaramDTO saramdto = new SaramDTO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			saramdto = new SaramDTO();
			saramdto.setId(rs.getInt("id"));
			saramdto.setName(rs.getString("name"));
			saramdto.setPhone(rs.getString("phone"));
			saramdto.setEmail(rs.getString("email"));

		}
		JdbcUtil.close(conn, stmt, rs);
		return saramdto;
	}

	public void update(SaramDTO dto) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(UPDATE);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPhone());
		pstmt.setString(3, dto.getEmail());
		pstmt.setInt(4, dto.getId());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("update success");
		} else {
			System.out.println("update fail");
		}

		JdbcUtil.close(conn, stmt, rs);

	}

	public void delete(int no) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
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

	public void insert(SaramDTO dto) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(INSERT);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPhone());
		pstmt.setString(3, dto.getEmail());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}

		JdbcUtil.close(conn, stmt, rs);
	}

}