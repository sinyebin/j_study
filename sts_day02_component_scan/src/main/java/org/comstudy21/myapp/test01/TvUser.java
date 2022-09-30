package org.comstudy21.myapp.test01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {
	
	public static void main(String[] args) {
		String resource = "classpath:applicationContext.xml";
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext(resource);
		Tv tv = (Tv)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		Tv tv2 = (Tv)factory.getBean(args[0]);
		tv2.powerOn();
	}

}
