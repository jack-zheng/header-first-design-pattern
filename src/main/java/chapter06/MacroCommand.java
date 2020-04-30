package chapter06;

public class MacroCommand implements Command {
	private Command[] commands;

	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for (Command cmd : commands) {
			cmd.execute();
		}
	}

	@Override
	public void undo() {
		for (Command cmd : commands) {
			cmd.undo();
		}
	}
}
