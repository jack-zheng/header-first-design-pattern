package chapter06;

public class SimpleRemoteControl {
	Command solt;

	public void setCommand(Command cmd) {
		solt = cmd;
	}

	public void buttonWasPressed() {
		solt.execute();
	}
}
