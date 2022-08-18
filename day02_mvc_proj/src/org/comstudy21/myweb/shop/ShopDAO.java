package org.comstudy21.myweb.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myweb.controller.JdbcUtil;

public class ShopDAO {
	public static final String SELECT = "SELECT * FROM SHOP";
	public static final String INSERT = "INSERT INTO SHOP(GOODS,PRICE)VALUES(?,?)";
	public static final String UPDATE = "UPDATE SHOP SET GOODS=?, PRICE=? WHERE NO=?";
	public static final String SELECT_ONE = "SELECT * FROM SHOP WHERE NO=?";
	public static final String DELETE = "DELETE FROM SHOP WHERE NO=?";
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<ShopDTO> selectAll() throws SQLException{
		List<ShopDTO> shopList = new ArrayList();
		conn= JdbcUtil.getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(SELECT);
		while(rs.next()) {
			ShopDTO dto = new ShopDTO();
			dto.setNo(rs.getInt("no"));
			dto.setGoods(rs.getString("goods"));
			dto.setPrice(rs.getInt("price"));
			shopList.add(dto);
		}
		JdbcUtil.close(conn, stmt, rs);
		return shopList;
	}

	public void insert(ShopDTO dto) throws SQLException {
		conn=JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(INSERT);
		pstmt.setString(1, dto.getGoods());
		pstmt.setInt(2, dto.getPrice());
		int cnt=pstmt.executeUpdate();
		if(cnt>0) {
			System.out.println("insert success");
		}else {
			System.out.println("insert fail");
		}
		JdbcUtil.close(conn, pstmt, rs);
	}

	public ShopDTO selectOne(int no)throws SQLException {
		ShopDTO shopdto=new ShopDTO();
		conn=JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, no);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			shopdto=new ShopDTO();
			shopdto.setNo(rs.getInt("no"));
			shopdto.setGoods(rs.getString("goods"));
			shopdto.setPrice(rs.getInt("price"));
		}
		JdbcUtil.close(conn, pstmt, rs);
		return shopdto;
	}

	public void update(ShopDTO dto) {

	}

	public void delete(int no) throws SQLException {
		conn=JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(DELETE);
		pstmt.setInt(1, no);
		int cnt=pstmt.executeUpdate();
		if(cnt>0) {
			System.out.println("delete success");
		} else {
			System.out.println("delete fail");
		}
		JdbcUtil.close(conn, stmt, rs);
	}

}
