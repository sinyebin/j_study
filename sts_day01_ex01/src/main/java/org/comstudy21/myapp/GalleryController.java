package org.comstudy21.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {
	@RequestMapping(value="gallery.do",method=RequestMethod.GET)
	public String gallery() {
		System.out.println(">>> gallery(): GalleryController 호출");
		return "gallery";
	}
}
