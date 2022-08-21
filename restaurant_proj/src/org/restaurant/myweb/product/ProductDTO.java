package org.restaurant.myweb.product;

public class ProductDTO {
	int rno;
	String rtitle;
	int rprice;
	public ProductDTO() {
		
	}
	public ProductDTO(int rno, String rtitle, int rprice) {
		this.rno=rno;
		this.rtitle=rtitle;
		this.rprice=rprice;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public int getRprice() {
		return rprice;
	}
	public void setRprice(int rprice) {
		this.rprice = rprice;
	}
	@Override
	public String toString() {
		return  rno + " - "+ rtitle + " - " +rprice + "원";
	}
	
}
