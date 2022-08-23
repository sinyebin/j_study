package org.restaurant.myweb.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginpageService implements LoginService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("POST")) {
			
			
			
			return null;
		}else {		
			return "login/loginpage";
		}
		
	}

}
