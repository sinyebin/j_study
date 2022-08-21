package org.restaurant.myweb.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.restaurant.myweb.controller.JdbcUtil;


public class ProductDAO {
	public static final String SELECT = "SELECT * FROM product";
	public static final String INSERT = "INSERT INTO product(rno,rtitle,rprice)VALUES(NEXTVAL('SEQ_PRODUCT'),?,?)";
	public static final String UPDATE = "UPDATE product SET rtitle=?, rprice=? WHERE rno=?";
	public static final String SELECT_ONE = "SELECT * FROM product WHERE rNO=?";
	public static final String DELETE = "DELETE FROM product WHERE rNO=?";
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public static List<ProductDTO> selectAll() throws SQLException {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		conn = JdbcUtil.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT);
		while (rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setRno(rs.getInt("rno"));
			dto.setRtitle(rs.getString("rtitle"));
			dto.setRprice(rs.getInt("rprice"));
			productList.add(dto);

		}
		//System.out.println(memberList);
		JdbcUtil.close(conn, stmt, rs);
		return productList;
	}
	public static void insert(ProductDTO dto) throws SQLException {
		conn=JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(INSERT);
		pstmt.setString(1, dto.getRtitle());
		pstmt.setInt(2, dto.getRprice());
		int cnt=pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}

		JdbcUtil.close(conn, stmt, rs);
	}
	   
	public static ProductDTO selectOne(int no) throws SQLException{
		ProductDTO dto=new ProductDTO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			dto = new ProductDTO();
			dto.setRno(rs.getInt("rno"));
			dto.setRtitle(rs.getString("rtitle"));
			dto.setRprice(rs.getInt("rprice"));
		}
		JdbcUtil.close(conn, stmt, rs);
		return dto;
	}
	   
	public static void update(ProductDTO dto) throws SQLException {
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(UPDATE);
		pstmt.setString(1, dto.getRtitle());
		pstmt.setInt(2, dto.getRprice());
		pstmt.setInt(3, dto.getRno());
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
