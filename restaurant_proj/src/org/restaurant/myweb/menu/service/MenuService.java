package org.restaurant.myweb.menu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.reserve.ProductDAO;

public interface MenuService {
	ProductDAO productDAO = new ProductDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
