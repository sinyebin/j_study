package org.carshop.myweb.cart.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.carshop.myweb.cart.CartDTO;

public class CartListService implements CartService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		List<CartDTO> cartList=null;
		HttpSession session = req.getSession();
		int no=(int) session.getAttribute("login.no");
		try {
			cartList=cartDAO.selectAll_ID(no);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		req.setAttribute("cartList", cartList);
		return "cart/list";
	}

}
