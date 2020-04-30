package chapter06;

public class NoCommand implements Command {
	@Override
	public void execute() {
		System.out.println("No command set...");
	}

	@Override
	public void undo() {
		System.out.println("No command set...");
	}
}
