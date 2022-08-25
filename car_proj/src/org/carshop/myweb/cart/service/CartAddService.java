package org.carshop.myweb.cart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.carshop.myweb.cart.CartDTO;
import org.carshop.myweb.member.MemberDAO;
import org.carshop.myweb.member.MemberDTO;
import org.carshop.myweb.product.ProductDAO;
import org.carshop.myweb.product.ProductDTO;

public class CartAddService implements CartService {
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		int pno=Integer.parseInt(req.getParameter("pno"));
		String cmd=req.getParameter("cmd");
		int ea=Integer.parseInt(req.getParameter("ea"));
		HttpSession session = req.getSession();
		int no=(int) session.getAttribute("login.no");


		ProductDAO dao = new ProductDAO();
		ProductDTO product = null;
		try {
			product = dao.selectOne(pno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDAO mdao= new MemberDAO();
		MemberDTO mdto = null;
		try {
			mdto=mdao.selectOne(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(!cartDAO.checkCart(no, pno)) {
				
			}else {
				CartDTO cartDTO= new CartDTO(0,mdto,product,ea);
				cartDAO.insert(cartDTO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<CartDTO> cartList=null;
		try {
			cartList=cartDAO.selectAll_ID(no);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		req.setAttribute("cartList", cartList);
		return "cart/list";
	}

}
