package org.comstudy21.myweb.member;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemberDAO {
	private static List<MemberDTO> memberList;
	static {
		memberList = Arrays.asList(
	    new MemberDTO(1,"KIM","010-1111-1111"),
	    new MemberDTO(2,"LEE","010-1111-2222"),
	    new MemberDTO(3,"PARK","010-1111-3333"));
	} 
	public List<MemberDTO> selectAll(){
		return memberList;
	}
	public void insert(MemberDTO dto) {
		memberList.add(dto);
	}
	   
	public MemberDTO selectOne(MemberDTO dto) {
		return null;
	}
	   
	public void update(MemberDTO dto) {
	      
	}
	   
	public void delete(MemberDTO dto) {
	      
	}

}
