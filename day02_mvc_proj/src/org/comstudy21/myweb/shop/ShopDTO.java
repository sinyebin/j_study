package org.comstudy21.myweb.shop;

public class ShopDTO {
	int no;
	String goods;
	int price;
	
	public ShopDTO() {
		
	}
	
	public ShopDTO(int no, String goods,int price){
		this.no=no;
		this.goods=goods;
		this.price=price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShopDTO [no=" + no + ", goods=" + goods + ", price=" + price + "]";
	}

}
