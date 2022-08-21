package org.restaurant.myweb.reserve.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.member.PeopleDTO;

public class ReserveListService implements ReserveService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		List<PeopleDTO> peopleList=null;
		try {
			peopleList = peopleDAO.selectAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		req.setAttribute("peopleList",peopleList );
		return "reserve/list";
	}

}
