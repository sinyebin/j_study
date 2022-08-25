package org.carshop.myweb.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carshop.myweb.product.ProductDTO;

public class ProductListService implements ProductService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		
		List<ProductDTO> productList = null;
		try {
			productList=productDAO.selectAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		req.setAttribute("productList", productList);
		return "product/list";
	}

}
