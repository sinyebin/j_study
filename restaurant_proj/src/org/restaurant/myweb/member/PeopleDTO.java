package org.restaurant.myweb.member;

import org.restaurant.myweb.reserve.ProductDTO;

public class PeopleDTO {
	int pno;
	String name;
	String phone;
	boolean rpay;
	ProductDTO product;
	public PeopleDTO() {
		// TODO Auto-generated constructor stub
	}
	public PeopleDTO(int pno, String name, String phone, boolean rpay, ProductDTO product) {
		this.pno=pno;
		this.name=name;
		this.phone=phone;
		this.rpay=rpay;
		this.product=product;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
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
	public boolean isRpay() {
		return rpay;
	}
	public void setRpay(boolean rpay) {
		this.rpay = rpay;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "PeopleDTO [pno=" + pno + ", name=" + name + ", phone=" + phone + ", rpay=" + rpay + ", product="
				+ product + "]";
	}
	
}
