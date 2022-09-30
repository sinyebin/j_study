package org.comstudy21.myapp.test02;

public class Saram {
	
	private Saram() {
		
	}
	private static Saram instance;
	public static Saram getInstance() {
		if(instance==null) {
			instance=new Saram();
		}
		return instance;
	}

	public void move() {
		System.out.println(">>> 사람이 움직인다...");
	}
}
