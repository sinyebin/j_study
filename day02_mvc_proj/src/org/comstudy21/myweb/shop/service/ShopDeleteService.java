package org.comstudy21.myweb.shop.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopDeleteService implements ShopService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		int num=Integer.parseInt(req.getParameter("no"));
		try {
			shopDAO.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list.do";
	}

}
