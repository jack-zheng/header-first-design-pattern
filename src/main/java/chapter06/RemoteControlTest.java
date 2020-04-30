package chapter06;

public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl control = new SimpleRemoteControl();

		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);

		GarageDoor garageDoor = new GarageDoor();
		GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);

		control.setCommand(lightOnCommand);
		control.buttonWasPressed();

		control.setCommand(garageDoorOpenCommand);
		control.buttonWasPressed();
	}
}
