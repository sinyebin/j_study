package org.carshop.myweb.cart;

import org.carshop.myweb.member.MemberDTO;
import org.carshop.myweb.product.ProductDTO;

public class CartDTO {
	int cno;
	MemberDTO memDTO;
	ProductDTO proDTO;
	int ea;

	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int cno, MemberDTO memDTO, ProductDTO proDTO, int ea) {
		this.cno = cno;
		this.memDTO = memDTO;
		this.proDTO = proDTO;
		this.ea = ea;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public MemberDTO getMemDTO() {
		return memDTO;
	}

	public void setMemDTO(MemberDTO memDTO) {
		this.memDTO = memDTO;
	}

	public ProductDTO getProDTO() {
		return proDTO;
	}

	public void setProDTO(ProductDTO proDTO) {
		this.proDTO = proDTO;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	@Override
	public String toString() {
		return "CartDTO [cno=" + cno + ", memDTO=" + memDTO + ", proDTO=" + proDTO + ", ea=" + ea + "]";
	}

}
