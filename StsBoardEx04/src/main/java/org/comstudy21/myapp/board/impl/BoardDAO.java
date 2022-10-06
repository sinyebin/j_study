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
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		mybatis.insert("BoardMapper.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		mybatis.update("BoardMapper.updeateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		mybatis.delete("BoardMapper.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = (BoardVO)mybatis.selectOne("BoardMapper.getBoard",vo);
		
		
		return board;
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> list = (List)mybatis.selectList("BoardMapper.getBoardList",vo);
		return list;
	}
}
