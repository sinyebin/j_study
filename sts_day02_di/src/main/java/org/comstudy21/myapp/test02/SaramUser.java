package org.comstudy21.myapp.test02;

public class SaramUser {
	public static void main(String args[]) {
		//Saram saram = new Saram(); 불가능
		Saram saram = Saram.getInstance();
		saram.move();
	}
}
