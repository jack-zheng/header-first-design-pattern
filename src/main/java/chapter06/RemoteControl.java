package chapter06;

public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;

	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];

		for (int i = 0; i < 7; i++) {
			onCommands[i] = new NoCommand();
			offCommands[i] = new NoCommand();
		}
	}

	public void setCommand(int slot, Command onCmd, Command offCmd) {
		onCommands[slot] = onCmd;
		offCommands[slot] = offCmd;
	}

	public void onButtonPressed(int slot) {
		onCommands[slot].execute();
	}

	public void offButtonPressed(int slot) {
		offCommands[slot].execute();
	}

	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + " " + offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}
}
