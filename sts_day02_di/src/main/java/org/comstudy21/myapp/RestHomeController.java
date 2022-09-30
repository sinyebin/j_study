package org.comstudy21.myapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHomeController {
	
	@RequestMapping(value="/rest/")
	public String restHome() {
		return String.format("{\"name\":\"%s\",\"address\":\"%s\"}", "홍길동","서울시 강남구 서초동");
	}
}
