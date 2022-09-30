package org.comstudy21.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
	@RequestMapping(value="profile.do",method=RequestMethod.GET)
	public String profile() {
		System.out.println(">>> profile(): ProfileController 호출");
		return "profile";
	}
}
