package chapter06;

public class RemoteLoaderV2 {
	public static void main(String[] args) {
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);

		Stereo stereo = new Stereo();
		StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
		StereoOffWithCDCommand stereoOffWithCDCommand = new StereoOffWithCDCommand(stereo);

		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
		remoteControl.setCommand(1, stereoOnWithCDCommand, stereoOffWithCDCommand);

		remoteControl.onButtonPressed(0);
		remoteControl.offButtonPressed(0);
		remoteControl.undoButtonPressed();
		System.out.println(remoteControl);

		remoteControl.onButtonPressed(1);
		remoteControl.offButtonPressed(1);
		remoteControl.undoButtonPressed();
		System.out.println(remoteControl);

		remoteControl.onButtonPressed(2);
		remoteControl.offButtonPressed(2);
		remoteControl.undoButtonPressed();
		System.out.println(remoteControl);
	}
}
