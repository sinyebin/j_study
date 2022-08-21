package org.restaurant.myweb.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.restaurant.myweb.controller.JdbcUtil;
import org.restaurant.myweb.product.ProductDAO;
import org.restaurant.myweb.product.ProductDTO;

public class PeopleDAO {
	public static final String SELECT = "SELECT * FROM PEOPLE";
	public static final String INSERT = "INSERT INTO PEOPLE(pno, name, phone, rpay, rno)VALUES(NEXTVAL('SEQ_PEOPLE'),?,?,?,?)";
	//public static final String UPDATE = "UPDATE product SET rtitle=?, rprice=? WHERE rno=?";
	//public static final String SELECT_ONE = "SELECT * FROM product WHERE rNO=?";
	public static final String DELETE = "DELETE FROM PEOPLE WHERE PNO=?";
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public static List<PeopleDTO> selectAll() throws SQLException {
		List<PeopleDTO> peopleList = new ArrayList<PeopleDTO>();
		conn = JdbcUtil.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT);
		while (rs.next()) {
			PeopleDTO dto = new PeopleDTO();
			dto.setPno(rs.getInt("pno"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setRpay(rs.getBoolean("rpay"));
			int rno=rs.getInt("rno");
			dto.setProduct(ProductDAO.selectOne(rno));
			peopleList.add(dto);
		}
		JdbcUtil.close(conn, stmt, rs);
		return peopleList;
	}
	public static void insert(PeopleDTO dto) throws SQLException {
		conn=JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(INSERT);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPhone());
		if(dto.isRpay()) {
			pstmt.setString(3, "T");
		}else {
			pstmt.setString(3, "F");
		}
		
		pstmt.setInt(4, dto.getProduct().getRno());
		int cnt=pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
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