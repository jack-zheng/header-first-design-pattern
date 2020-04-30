package chapter06;

public class Stereo {
	public void on() {
		System.out.println("Stereo is on...");
	}
	public void off() {
		System.out.println("Stereo is off...");
	}

	public void setCd() {
		System.out.println("CD is loaded...");
	}

	public void setVolume(int vol) {
		System.out.println("Volume to " + vol + "...");
	}
}
