package org.comstudy21.myweb.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.shop.ShopDAO;
import org.comstudy21.myweb.shop.ShopDTO;

public class ShopListService implements ShopService{
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		List<ShopDTO> shopList= ShopDAO.selectAll();
		req.setAttribute("shopList", shopList);
		return "shop/list";
	}
}
