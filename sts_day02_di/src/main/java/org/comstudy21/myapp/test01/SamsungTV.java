package org.comstudy21.myapp.test01;

public class SamsungTV implements Tv {
	private String name = "삼성";
	private int volume = 5;

	private Speaker speaker;

	public SamsungTV() {
		System.out.println(name + "의 생성자...");
	}

	// DI를 사용하기 위한 생성자
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}

	public SamsungTV(String name, Speaker speaker) {
		this.name = name;
		this.speaker = speaker;
	}

	// DI를 사용하기 위한 세터
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void initMethod() {
		System.out.println(">>> initMethod(): SamsungTV");
	}

	public void destroyMethod() {
		System.out.println(">>> destroyMethod(): SamsungTV");
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
		//volume++;
		//System.out.println("소리 높이기: " + volume);
		speaker.soundUp();
	}

	@Override
	public void volumeDown() {
		//volume--;
		//System.out.println("소리 낮추기: " + volume);
		speaker.soundDown();
	}
}
