package org.carshop.myweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtil {
	public static PathVO initPathAttr(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		int beginIndex = ctxPath.length();
		int endIndex = reqUri.lastIndexOf(".");
		String path = reqUri.substring(beginIndex, endIndex);
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		req.setAttribute("path", path);
		req.setAttribute("suffix", suffix);
		req.setAttribute("prefix", prefix);

		// 파일명은 확장자 앞에 있다.
		// 파일명은 마지막 /부터 . 앞에까지
		int midIndex = path.lastIndexOf("/");
		String fileName = path.substring(midIndex);
		String dirPath= path.substring(0,midIndex);
		int dirIndex=dirPath.lastIndexOf("/");
		String dirName = path.substring(0,midIndex);
		if(dirIndex>0) {
			dirName=path.substring(dirIndex, midIndex);
		}
		
		req.setAttribute("dirName", dirName);
		req.setAttribute("fileName", fileName);
		System.out.println(dirName);
		/*
		 * beginIndex = reqUri.lastIndexOf("/"); endIndex=reqUri.lastIndexOf(".");
		 * String fileName=path.substring(beginIndex,endIndex); String
		 * dirName=path.substring(0,path.lastIndexOf(fileName));
		 */

		// System.out.println(">>>DispatcherServlet...");
		// System.out.println("reqUri: "+reqUri);
		 System.out.println("ctxPath: "+ctxPath);
		// System.out.println("path= "+path);
		// System.out.println("dirName= "+dirName);
		// System.out.println("fileName= "+fileName);

		PathVO pathVO = new PathVO(path, fileName, dirName, suffix, prefix);
		req.setAttribute("pathVO", pathVO);

		return pathVO;

	}
}
