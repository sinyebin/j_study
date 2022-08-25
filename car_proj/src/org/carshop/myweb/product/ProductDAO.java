package org.carshop.myweb.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.carshop.myweb.DAO;
import org.carshop.myweb.controller.JdbcUtil;
import org.carshop.myweb.member.MemberDTO;

interface sqlInterface extends DAO<ProductDTO> {
	String SELECT = "SELECT * FROM CAR";
	String INSERT = "INSERT INTO CAR(PNAME, COMPANY, PRICE, EA)VALUES(?,?,?,?)";
	String DELETE = "DELETE FROM CAR WHERE PNO=?";
	String SELECT_ONE = "SELECT * FROM CAR WHERE PNO=?";
	String UPDATE = "UPDATE CAR SET PNAME=?, COMPANY=?, PRICE=?, EA=? WHERE PNO=?";
}

public class ProductDAO implements sqlInterface {
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		List<ProductDTO> productList = new ArrayList();
		conn = JdbcUtil.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT);
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setPno(rs.getInt("PNO"));
			dto.setPname(rs.getString("PNAME"));
			dto.setCompany(rs.getString("COMPANY"));
			dto.setPrice(rs.getInt("PRICE"));
			dto.setEa(rs.getInt("EA"));
			productList.add(dto);
		}
		JdbcUtil.close(conn, stmt, rs);
		return productList;
	}

	@Override
	public ProductDTO selectOne(int no) throws SQLException {
		ProductDTO dto = new ProductDTO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			dto=new ProductDTO();
			dto.setPno(rs.getInt("PNO"));
			dto.setPname(rs.getString("PNAME"));
			dto.setCompany(rs.getString("COMPANY"));
			dto.setPrice(rs.getInt("PRICE"));
			dto.setEa(rs.getInt("EA"));
		}
		JdbcUtil.close(conn, stmt, rs);
		return dto;
	}

	@Override
	public void insert(ProductDTO obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProductDTO obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
