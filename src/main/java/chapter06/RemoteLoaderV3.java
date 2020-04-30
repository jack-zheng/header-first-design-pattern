package chapter06;

public class RemoteLoaderV3 {
	public static void main(String[] args) {
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);

		Stereo stereo = new Stereo();
		StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
		StereoOffWithCDCommand stereoOffWithCDCommand = new StereoOffWithCDCommand(stereo);

		Command[] onCmds = new Command[] { lightOnCommand, stereoOnWithCDCommand};
		MacroCommand partOnCmds = new MacroCommand(onCmds);

		Command[] offCmds = new Command[] { lightOffCommand, stereoOffWithCDCommand};
		MacroCommand partOffCmds = new MacroCommand(offCmds);

		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		remoteControl.setCommand(0, partOnCmds, partOffCmds);

		remoteControl.onButtonPressed(0);
		remoteControl.offButtonPressed(0);
		remoteControl.undoButtonPressed();
		System.out.println(remoteControl);
	}
}
