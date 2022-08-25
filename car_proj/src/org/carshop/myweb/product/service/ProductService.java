package org.carshop.myweb.product.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carshop.myweb.product.ProductDAO;

public interface ProductService {
	ProductDAO productDAO = new ProductDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
