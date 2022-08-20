package org.restaurant.myweb.menu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.reserve.ProductDAO;
import org.restaurant.myweb.reserve.ProductDTO;

public class MenuListService implements MenuService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		List<ProductDTO> productList=null;
		try {
			productList=ProductDAO.selectAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		req.setAttribute("productList", productList);
		return "menu/list";
	}

}
