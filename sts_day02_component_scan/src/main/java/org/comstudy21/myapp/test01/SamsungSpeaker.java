package org.comstudy21.myapp.test01;

import org.springframework.stereotype.Component;

@Component("samsungSpeaker")
public class SamsungSpeaker implements Speaker {
	private int sound=4;

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		sound++;
		System.out.println("Samsung Speaker 소리 높이기...");
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		sound--;
		System.out.println("Samsung Speaker 소리 낮추기...");
	}

}
