package org.carshop.myweb.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.carshop.myweb.DAO;
import org.carshop.myweb.controller.JdbcUtil;
import org.carshop.myweb.member.MemberDAO;
import org.carshop.myweb.member.MemberDTO;
import org.carshop.myweb.product.ProductDAO;
import org.carshop.myweb.product.ProductDTO;

interface sqlInterface extends DAO<CartDTO> {
	String SELECT = "SELECT * FROM CART WHERE MNO=?";
	String INSERT = "INSERT INTO CART(MNO,PNO, EA)VALUES(?,?,?)";
	String DELETE = "DELETE FROM MEM WHERE MNO=?";
	String SELECT_ONE = "SELECT * FROM CART WHERE MNO=? and PNO = ?";
	String UPDATE = "UPDATE CART SET MNO=?, PNO=?, EA=? WHERE CNO=?";
	String CHECK_CART = "SELECT COUNT(*)NUM FROM CART WHERE MNO=? AND PNO=?";
}

public class CartDAO implements sqlInterface {
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;


	public List<CartDTO> selectAll_ID(int no) throws SQLException {
		List<CartDTO> cartList = new ArrayList();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			CartDTO dto = new CartDTO();
			dto.setCno(rs.getInt("CNO"));
			int mno=rs.getInt("MNO");
			int pno=rs.getInt("PNO");
			MemberDAO memDAO=new MemberDAO();
			ProductDAO productDAO = new ProductDAO();
			dto.setMemDTO(memDAO.selectOne(mno));
			dto.setProDTO(productDAO.selectOne(pno));
			dto.setEa(rs.getInt("EA"));
			cartList.add(dto);
		}
		return cartList;
	}
	public boolean checkCart(int mno,int pno)throws SQLException{
		boolean check=true;
		conn = JdbcUtil.getConnection();
		pstmt=conn.prepareStatement(CHECK_CART);
		pstmt.setInt(1, mno);
		pstmt.setInt(2, pno);
		rs = pstmt.executeQuery();
		rs.next();
		int p=rs.getInt("num");
		if (p != 0 ) {
			check=false;
		}
		JdbcUtil.close(conn, stmt, rs);
		
		return check;
	}

	public CartDTO selectOne(int mno,int pno) throws SQLException {
		System.out.println("check");
		CartDTO dto = new CartDTO();
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(SELECT_ONE);
		pstmt.setInt(1, mno);
		pstmt.setInt(2, pno);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			dto.setCno(rs.getInt("CNO"));
			int mNo=rs.getInt("MNO");
			int pNo=rs.getInt("PNO");
			MemberDAO memDAO=new MemberDAO();
			ProductDAO productDAO = new ProductDAO();
			dto.setMemDTO(memDAO.selectOne(mNo));
			dto.setProDTO(productDAO.selectOne(pNo));
			dto.setEa(rs.getInt("EA"));
		}
		return dto;
	}

	@Override
	public void insert(CartDTO obj) throws SQLException {
		// TODO Auto-generated method stub
		conn=JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(INSERT);
		pstmt.setInt(1, obj.getMemDTO().getMno());
		pstmt.setInt(2, obj.getProDTO().getPno());
		pstmt.setInt(3, obj.getEa());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}
		JdbcUtil.close(conn, stmt, rs);
	}

	@Override
	public void update(CartDTO obj) throws SQLException {
		// TODO Auto-generated method stub
		conn=JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(UPDATE);
		pstmt.setInt(1, obj.getMemDTO().getMno());
		pstmt.setInt(2, obj.getProDTO().getPno());
		pstmt.setInt(3, obj.getEa());
		pstmt.setInt(4, obj.getCno());
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
		// TODO Auto-generated method stub

	}

	@Override
	public List<CartDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CartDTO selectOne(int no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
