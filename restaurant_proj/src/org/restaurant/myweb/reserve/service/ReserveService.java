package org.restaurant.myweb.reserve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.member.PeopleDAO;
import org.restaurant.myweb.product.ProductDAO;

public interface ReserveService {
	PeopleDAO peopleDAO = new PeopleDAO();
	ProductDAO productDAO = new ProductDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
