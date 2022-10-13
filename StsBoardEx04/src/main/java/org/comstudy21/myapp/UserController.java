package org.comstudy21.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.comstudy21.myapp.board.BoardVO;
import org.comstudy21.myapp.user.UserService;
import org.comstudy21.myapp.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		List<UserVO> list = userService.getUserList(null);
		mav.addObject("list",list);
		mav.setViewName("user/list");
		return mav;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(UserVO vo,ModelAndView mav) { 
		UserVO user = userService.getUser(vo);
		mav.addObject("user",user);
		mav.setViewName("user/detail");
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(UserVO vo,ModelAndView mav) {
		userService.deleteUser(vo);
		mav.setViewName("redirect:/user/list");
		return mav;
	}
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginProcess(UserVO vo, HttpSession session, ModelAndView mav) {
		UserVO user = userService.loginUser(vo);
		if(user!=null) {
			// session에 로그인 처리
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("role", vo.getRole());
			mav.setViewName("redirect:/board/list");
			return mav;
		}else {
			mav.addObject("msg", "로그인 실패");
			mav.addObject("url", "/user/login");
			mav.setViewName("redirect");
			return mav;
		}
		
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "user/login";
	}
}
