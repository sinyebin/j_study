package org.comstudy21.myweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myweb.bbs.BoardDAO;
import org.comstudy21.myweb.member.MemberDAO;
import org.comstudy21.myweb.shop.ShopDAO;

public interface MyController {
	String handleRequest(HttpServletRequest req, HttpServletResponse resp);
}