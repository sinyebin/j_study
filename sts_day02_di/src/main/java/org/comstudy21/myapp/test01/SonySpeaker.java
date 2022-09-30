package org.comstudy21.myapp.test01;

public class SonySpeaker implements Speaker {
	private int sound=4;

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		sound++;
		System.out.println("Sony Speaker 소리 높이기...");
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		sound--;
		System.out.println("Sony Speaker 소리 낮추기...");
	}

}
