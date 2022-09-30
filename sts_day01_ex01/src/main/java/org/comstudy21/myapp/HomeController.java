package org.comstudy21.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("userName","홍길동");
		model.addAttribute("serverTime", formattedDate );
		List<HashMap<String, String>> menuItemList=new ArrayList();
		HashMap<String, String>menu1=new HashMap();
		menu1.put("title", "NAVER");
		menu1.put("url", "https://www.naver.com/");
		menuItemList.add(menu1);
		
		HashMap<String, String>menu2=new HashMap();
		menu2.put("title", "Profile");
		menu2.put("url", "profile.do");
		menuItemList.add(menu2);
		
		HashMap<String, String>menu3=new HashMap();
		menu3.put("title", "Gallery");
		menu3.put("url", "gallery.do");
		menuItemList.add(menu3);
		
		HashMap<String, String>menu4=new HashMap();
		menu4.put("title", "Board");
		menu4.put("url", "board/list.do");
		menuItemList.add(menu4);
		
		model.addAttribute("menuItemList",menuItemList);
		return "home";
	}
	
}
