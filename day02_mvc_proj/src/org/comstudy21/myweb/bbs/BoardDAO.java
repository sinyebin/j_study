package org.comstudy21.myweb.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myweb.controller.JdbcUtil;
import org.comstudy21.myweb.member.MemberDTO;

public class BoardDAO {
	public static final String SELECT = "SELECT * FROM BOARD";
	public static final String INSERT = "INSERT INTO BOARD(TITLE,CONTENT)VALUES(?,?)";
	public static final String UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE NO=?";
	public static final String SELECT_ONE = "SELECT * FROM BOARD WHERE NO=?";
	public static final String DELETE = "DELETE FROM BOARD WHERE NO=?";
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public static List<BoardDTO> selectAll() throws SQLException {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		conn = JdbcUtil.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT);
		while (rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			boardList.add(dto);
		}
		JdbcUtil.close(conn, stmt, rs);
		return boardList;
	}

	public void insert(BoardDTO dto) throws SQLException {
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(INSERT);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}

		JdbcUtil.close(conn, stmt, rs);
		// System.out.println(boardList);
	}

	public static BoardDTO selectOne(int no) throws SQLException {
		BoardDTO boardDto = new BoardDTO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			boardDto = new BoardDTO();
			boardDto.setNo(rs.getInt("no"));
			boardDto.setTitle(rs.getString("title"));
			boardDto.setContent(rs.getString("content"));
		}
		JdbcUtil.close(conn, stmt, rs);
		return boardDto;
	}

	public void update(BoardDTO dto) throws SQLException{
		conn=JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(UPDATE);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setInt(3, dto.getNo());
		int cnt=pstmt.executeUpdate();
		if(cnt>0) {
			System.out.println("update success");
		}else {
			System.out.println("update fail");
		}
		JdbcUtil.close(conn, pstmt, rs);
	}

	public static void delete(int no) throws SQLException {
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
