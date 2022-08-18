package org.comstudy21.myweb.shop.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.shop.ShopDTO;

public class ShopDetailService implements ShopService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		int num=Integer.parseInt(req.getParameter("no"));
		ShopDTO selectGoods=null;
		try {
			selectGoods=shopDAO.selectOne(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("selectGoods", selectGoods);
		return "shop/detail";
	}

}
