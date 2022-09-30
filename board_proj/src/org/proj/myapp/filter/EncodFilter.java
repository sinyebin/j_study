package org.proj.myapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodFilter implements Filter{
	
	private String charset="UTF-8";
	private String type="text/html; charset=UTF-8";
	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		resp.setCharacterEncoding(charset);
		resp.setContentType(type);
		
		HttpServletRequest req=(HttpServletRequest)request;
		String reqUri = req.getRequestURI();
		String ctxPath=req.getContextPath();
		
		String path=reqUri.substring(ctxPath.length());
		req.setAttribute("path", path);
		
		int index = path.lastIndexOf("/");
		
		String dirPath = path.substring(0,index);
		req.setAttribute("dirPath", dirPath);
		
		String filePath = path.substring(index);
		req.setAttribute("filePath", filePath);
		
		chain.doFilter(req, resp);
		
	}
}
