package org.comstudy21.myapp.user.impl;

import java.util.List;

import org.comstudy21.myapp.user.UserService;
import org.comstudy21.myapp.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDao;

	@Override
	public void insertUser(UserVO vo) {
		userDao.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		userDao.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		userDao.deleteUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDao.getUser(vo);
	}

	@Override
	public UserVO loginUser(UserVO vo) {
		return userDao.loginUser(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return userDao.getUserList(vo);
	}
}
