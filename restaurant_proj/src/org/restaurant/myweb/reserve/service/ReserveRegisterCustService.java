package org.restaurant.myweb.reserve.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.controller.HandlerMapping;
import org.restaurant.myweb.controller.HomeController;
import org.restaurant.myweb.controller.MyController;
import org.restaurant.myweb.member.PeopleDAO;
import org.restaurant.myweb.member.PeopleDTO;
import org.restaurant.myweb.menu.service.MenuService;
import org.restaurant.myweb.product.ProductDAO;
import org.restaurant.myweb.product.ProductDTO;

public class ReserveRegisterCustService implements ReserveService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			String pay = req.getParameter("pay");
			boolean rpay;
			if(pay.equals("TRUE")) {
				rpay=true;
			}else {
				rpay=false;
			}
			int rno =Integer.parseInt(req.getParameter("rno"));
			

			ProductDTO pdto=new ProductDTO();
			try {
				pdto = ProductDAO.selectOne(rno);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PeopleDTO dto=new PeopleDTO(0,name,phone,rpay,pdto);
			try {
				peopleDAO.insert(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MyController homectrl = new HomeController();
			HandlerMapping handlerMapping = new HandlerMapping();
			homectrl=handlerMapping.getController("");
			String viewName= homectrl.handleRequest(req, resp);
			return viewName;
		}else {
			List<ProductDTO> productList=null;
			try {
				productList=ProductDAO.selectAll();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			req.setAttribute("productList", productList);
			return "reserve/register_cust";
		}
	}

}
