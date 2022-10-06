package org.comstudy21.myapp.board.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myapp.board.BoardVO;
import org.comstudy21.myapp.common.JDBCUtil;
import org.springframework.stereotype.Repository;


public class BoardDAO_jdbc {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	private final String BOARD_INSERT = "INSERT INTO BOARD_EX(SEQ, TITLE, WRITER, CONTENT) VALUES ((select nvl(max(seq),0)+1 from board_ex), ?,?,?)";
	private final String BOARD_UPDATE = "UPDATE board_ex SET TITLE=?, WRITER=?, CONTENT=? WHERE SEQ=?";
	private final String BOARD_DELETE = "DELETE FROM board_ex WHERE SEQ=?";
	private final String BOARD_GET = "SELECT * FROM board_ex WHERE SEQ=?";
	private final String BOARD_LIST = "SELECT * FROM board_ex ORDER BY SEQ DESC";

	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		System.out.println(vo);
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			int cnt = stmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("===> 입력 완료!");
				conn.commit();
			} else {
				System.out.println("===> 입력 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.setInt(4, vo.getSeq());
			int cnt = stmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("===> 수정 완료!");
				conn.commit();
			} else {
				System.out.println("===> 수정 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			int cnt = stmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("===> 삭제 완료!");
				conn.commit();
			} else {
				System.out.println("===> 삭제 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				int seq = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String content = rs.getString(4);
				Date regdate = rs.getDate(5);
				int cnt = rs.getInt(6);
				board = new BoardVO(seq, title, writer, content, regdate, cnt,null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		
		return board;
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> list = new ArrayList();
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int seq = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String content = rs.getString(4);
				Date regdate = rs.getDate(5);
				int cnt = rs.getInt(6);
				list.add(new BoardVO(seq, title, writer, content, regdate, cnt,null) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return list;
	}
}
