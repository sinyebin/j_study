package org.comstudy21.myweb.shop.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.shop.ShopDAO;
import org.comstudy21.myweb.shop.ShopDTO;

public class ShopListService implements ShopService{
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		List<ShopDTO> shopList=null;
		try {
			shopList = shopDAO.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("shopList", shopList);
		return "shop/list";
	}
}
