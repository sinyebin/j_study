package org.comstudy21.myweb.shop.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.shop.ShopDAO;

public interface ShopService {
	ShopDAO shopDAO = new ShopDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
