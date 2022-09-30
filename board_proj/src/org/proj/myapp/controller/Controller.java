package org.proj.myapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proj.myapp.controller.ModelAndView;

public interface Controller {
	ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
