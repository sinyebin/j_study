package org.comstudy21.myweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyController { //추상 클래스를 사용하여 controller를 사용하도록 함
	public abstract String handler(HttpServletRequest req, HttpServletResponse resp);
}
