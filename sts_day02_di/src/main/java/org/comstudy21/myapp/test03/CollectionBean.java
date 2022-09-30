package org.comstudy21.myapp.test03;

import java.util.List;

public class CollectionBean {
	private List<String> addressList;
	
	public void setAddressList(List<String> addressList) {
		this.addressList=addressList;
	}
	
	public List<String> getAddressList(){
		return this.addressList;
	}
}
