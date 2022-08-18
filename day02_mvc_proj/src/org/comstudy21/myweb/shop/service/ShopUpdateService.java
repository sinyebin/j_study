package org.comstudy21.myweb.shop.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.shop.ShopDTO;

public class ShopUpdateService implements ShopService {
	static ShopDTO selectGoods = new ShopDTO();
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			String goods=req.getParameter("goods");
			int price=Integer.parseInt(req.getParameter("price"));
			selectGoods.setGoods(goods);
			selectGoods.setPrice(price);
			try {
				shopDAO.update(selectGoods);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:list.do";
		}else {
			int num=Integer.parseInt(req.getParameter("no"));
			selectGoods.setNo(num);
			return "shop/update";
		}
	}

}
