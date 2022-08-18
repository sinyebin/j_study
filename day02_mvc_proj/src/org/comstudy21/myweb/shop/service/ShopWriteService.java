package org.comstudy21.myweb.shop.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.shop.ShopDTO;

public class ShopWriteService implements ShopService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			String goods=req.getParameter("goods");
			int price=Integer.parseInt(req.getParameter("price"));
			ShopDTO dto=new ShopDTO(0,goods,price);
			try {
				shopDAO.insert(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:list.do";
		}else {
			return "shop/write";
		}
		
	}

}
