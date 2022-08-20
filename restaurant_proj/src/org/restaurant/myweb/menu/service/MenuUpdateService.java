package org.restaurant.myweb.menu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.reserve.ProductDTO;

public class MenuUpdateService implements MenuService {
	static ProductDTO selectProduct = new ProductDTO();
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			String rtitle=req.getParameter("rtitle");
			int rprice=Integer.parseInt(req.getParameter("rprice"));
			selectProduct.setRtitle(rtitle);
			selectProduct.setRprice(rprice);
			try {
				productDAO.update(selectProduct);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}					
			return "redirect:list.do";
		}else {
			int num=Integer.parseInt(req.getParameter("no"));
			selectProduct.setRno(num);
			return "menu/update";
		}
	}

}
