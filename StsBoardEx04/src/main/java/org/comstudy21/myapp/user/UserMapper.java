package org.comstudy21.myapp.user;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	@Select("Select * from Users where id=#{id}")
	public UserVO getUser(UserVO vo);

	
}
