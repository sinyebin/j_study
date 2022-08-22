package org.comstudy21.myweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtil {
	public static PathVO initPathAttr(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUri=req.getRequestURI(); // 프로젝트+파일 경로
		String ctxPath=req.getContextPath(); // 프로젝트 경로
		int beginIndex = ctxPath.length(); //프로젝트 경로 길이
		int endIndex = reqUri.lastIndexOf("."); //.do로 끝나 마지막 .이 나오는 위치
		String path=reqUri.substring(beginIndex, endIndex); //파일 경로
		String prefix="/WEB-INF/views/";
		String suffix=".jsp";
		req.setAttribute("path", path); // path 저장
		req.setAttribute("suffix", suffix); // suffix 저장
		req.setAttribute("prefix", prefix); // prefix 저장
		
		int midIndex=path.lastIndexOf("/"); // path에서 파일명은 마지막 /이후
		String fileName=path.substring(midIndex); // 파일명
		String dirName=path.substring(0, midIndex); // 파일 경로에서 파일명 제외
		
		PathVO pathVO=new PathVO(path, fileName, dirName, suffix, prefix); //생성자
		req.setAttribute("pathVO", pathVO); //pathVO 저장
		
		return pathVO;
	
	}
}
