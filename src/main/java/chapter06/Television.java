package chapter06;

public class Television {
	public void on() {
		System.out.println("TV is on...");
	}

	public void off() {
		System.out.println("TV is off...");
	}

	public void setInputChannel(int num) {
		System.out.println(String.format("TV channel %s...", num));
	}

	public void setVolume(int vol) {
		System.out.println(String.format("TV volume %s", vol));
	}
}
