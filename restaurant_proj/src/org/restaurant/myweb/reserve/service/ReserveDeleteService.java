package org.restaurant.myweb.reserve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReserveDeleteService implements ReserveService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		int num=Integer.parseInt(req.getParameter("no"));
		try {
			peopleDAO.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return "redirect:list.do";
	}

}
