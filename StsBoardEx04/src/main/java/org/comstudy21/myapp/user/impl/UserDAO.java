package org.comstudy21.myapp.user.impl;


import java.util.List;


import org.comstudy21.myapp.user.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insertUser(UserVO vo) {
		mybatis.insert("UserMapper.insertUser", vo);
	}

	public void updateUser(UserVO vo) {
		mybatis.insert("UserMapper.updateUser", vo);
	}

	public void deleteUser(UserVO vo) {		
		mybatis.insert("UserMapper.deleteUser", vo);
	}

	public UserVO getUser(UserVO vo) {
		UserVO user = (UserVO)mybatis.selectOne("UserMapper.getUser",vo);		
		return user;
	}
	
	public UserVO loginUser(UserVO vo) {
		UserVO user = (UserVO)mybatis.selectOne("UserMapper.loginUser",vo);
		return user;
	}

	public List<UserVO> getUserList(UserVO vo) {
		List<UserVO> list =(List)mybatis.selectList("UserMapper.getUserList",vo);
		return list;
	}
}
