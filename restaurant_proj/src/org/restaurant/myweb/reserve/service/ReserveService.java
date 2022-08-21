package org.restaurant.myweb.reserve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restaurant.myweb.member.PeopleDAO;

public interface ReserveService {
	PeopleDAO peopleDAO = new PeopleDAO();
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
