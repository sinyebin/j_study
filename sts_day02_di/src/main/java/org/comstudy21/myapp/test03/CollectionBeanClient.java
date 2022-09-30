package org.comstudy21.myapp.test03;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		String resource="classpath:applicationContext3.xml";
		AbstractApplicationContext factory=
				new GenericXmlApplicationContext(resource);
		 CollectionBean collectionBean = (CollectionBean) factory.getBean("collectionBean");
		
		 List<String> addressList = collectionBean.getAddressList();
		 System.out.println(addressList);
		 
		 for(String address:addressList) {
			 System.out.println(address);
		 }
	}
}
