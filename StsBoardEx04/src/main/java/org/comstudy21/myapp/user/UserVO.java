package org.comstudy21.myapp.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;
	
	public UserVO(String id) {
		this.id = id;
	}
	
	public UserVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
}
