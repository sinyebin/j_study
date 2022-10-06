package org.comstudy21.myapp;

import java.util.List;

import org.comstudy21.myapp.board.BoardVO;
import org.comstudy21.myapp.user.UserService;
import org.comstudy21.myapp.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
