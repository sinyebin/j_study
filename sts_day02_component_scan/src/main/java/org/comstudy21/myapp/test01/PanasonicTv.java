package org.comstudy21.myapp.test01;

public class PanasonicTv implements Tv {

	private String name = "파나소닉";
	private int volume = 5;

	public PanasonicTv() {
		System.out.println(name+"의 생성자...");
	}
	
	@Override
	public void powerOn() {
		System.out.println(name + "tv 전원 켜기!");
	}

	@Override
	public void powerOff() {
		System.out.println(name + "tv 전원 끄기!");
	}

	@Override
	public void volumeUp() {
		volume++;
		System.out.println("소리 높이기: " + volume);
	}

	@Override
	public void volumeDown() {
		volume--;
		System.out.println("소리 낮추기: " + volume);
	}

}
