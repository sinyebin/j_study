package org.comstudy21.myweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyController {
	public abstract String handler(HttpServletRequest req, HttpServletResponse resp);
}
