package org.restaurant.myweb.menu.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.reserve.ProductDTO;


public class MenuWriteService implements MenuService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			String rtitle=req.getParameter("rtitle");
			int rprice=Integer.parseInt(req.getParameter("rprice"));
			ProductDTO dto=new ProductDTO(0,rtitle,rprice);
			try {
				productDAO.insert(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:list.do";
		}else {
			return "menu/write";
		}
	}

}
