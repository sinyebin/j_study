package org.restaurant.myweb.member;

public class MemberDTO {
	int mno;	
	String id;
	String pw;
	String name;
	String phone;
	String email;
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(int mno, String id, String pw, String name, String phone, String email) {
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberDTO [mno=" + mno + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
}
