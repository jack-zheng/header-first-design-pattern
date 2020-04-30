package chapter06;

public class RemoteControlWithUndo {
	private Command[] onCommands;
	private Command[] offCommands;
	private Command undoCommand;

	public RemoteControlWithUndo() {
		onCommands = new Command[7];
		offCommands = new Command[7];

		NoCommand noCommand = new NoCommand();

		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}

		undoCommand = noCommand;
	}

	public void setCommand(int slot, Command onCmd, Command offCmd) {
		onCommands[slot] = onCmd;
		offCommands[slot] = offCmd;
	}

	public void onButtonPressed(int slot) {
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}

	public void offButtonPressed(int slot) {
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}

	public void undoButtonPressed() {
		undoCommand.undo();
	}

	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + " " + offCommands[i].getClass().getName() + "\n");
		}

		stringBuff.append("[undo command] " + undoCommand);
		return stringBuff.toString();
	}
}
