package org.carshop.myweb.cart.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carshop.myweb.cart.CartDAO;

public interface CartService {
	CartDAO cartDAO = new CartDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
