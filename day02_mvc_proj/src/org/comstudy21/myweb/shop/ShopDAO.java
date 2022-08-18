package org.comstudy21.myweb.shop;

import java.util.ArrayList;
import java.util.List;


public class ShopDAO {
	private static List<ShopDTO> shopList;
	private static int no=1;
	static {
		shopList=new ArrayList<ShopDTO>();
		shopList.add(new ShopDTO(no++,"아이스티",3000));
	}
	public static List<ShopDTO> selectAll(){
		return shopList;
	}
	public void insert(ShopDTO dto) {
		dto.setNo(no++);
		shopList.add(dto);
		//System.out.println(boardList);
	}
	   
	public ShopDTO selectOne(ShopDTO dto) {
		return null;
	}
	   
	public void update(ShopDTO dto) {
	      
	}
	   
	public void delete(ShopDTO dto) {
	      
	}

}
