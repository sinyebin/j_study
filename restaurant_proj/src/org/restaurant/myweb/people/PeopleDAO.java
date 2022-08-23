package org.restaurant.myweb.people;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.restaurant.myweb.DAO;
import org.restaurant.myweb.controller.JdbcUtil;
import org.restaurant.myweb.product.ProductDAO;
import org.restaurant.myweb.product.ProductDTO;
interface sqlInterface extends DAO {
	String SELECT = "SELECT * FROM PEOPLE";
	String INSERT = "INSERT INTO PEOPLE(pno, name, phone, rpay, rno)VALUES(NEXTVAL('SEQ_PEOPLE'),?,?,?,?)";
	String DELETE = "DELETE FROM PEOPLE WHERE PNO=?";
	String SELECT_ONE = "SELECT * FROM PEOPLE WHERE pno=?";
	String UPDATE = "UPDATE people SET name=?, phone=?,rpay=?,rno=? WHERE pno=?";
}
public class PeopleDAO implements sqlInterface{
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public  List<Object> selectAll() throws SQLException {
		List<Object> peopleList = new ArrayList();
		conn = JdbcUtil.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT);
		while (rs.next()) {
			PeopleDTO dto = new PeopleDTO();
			ProductDAO productDAO = new ProductDAO();
			dto.setPno(rs.getInt("pno"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setRpay(rs.getBoolean("rpay"));
			int rno=rs.getInt("rno");
			dto.setProduct((ProductDTO) productDAO.selectOne(rno));
			peopleList.add(dto);
		}
		JdbcUtil.close(conn, stmt, rs);
		return peopleList;
	}
	public Object selectOne(int no) throws SQLException {
		PeopleDTO dto = new PeopleDTO();
		ProductDAO productDAO = new ProductDAO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			dto = new PeopleDTO();
			productDAO = new ProductDAO();
			dto.setPno(rs.getInt("pno"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setRpay(rs.getBoolean("rpay"));
			int rno=rs.getInt("rno");
			dto.setProduct((ProductDTO) productDAO.selectOne(rno));
		}
		JdbcUtil.close(conn, stmt, rs);
		return dto;
	}
	public void insert(Object dto) throws SQLException {
		conn=JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(INSERT);
		pstmt.setString(1, ((PeopleDTO) dto).getName());
		pstmt.setString(2, ((PeopleDTO) dto).getPhone());
		if(((PeopleDTO) dto).isRpay()) {
			pstmt.setString(3, "T");
		}else {
			pstmt.setString(3, "F");
		}
		
		pstmt.setInt(4, ((PeopleDTO) dto).getProduct().getRno());
		int cnt=pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}

		JdbcUtil.close(conn, stmt, rs);
	}

	   
	public  void delete(int no)throws SQLException {
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



	@Override
	public void update(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
