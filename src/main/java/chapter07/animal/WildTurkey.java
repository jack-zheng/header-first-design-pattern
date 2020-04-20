package chapter07.animal;

public class WildTurkey implements Turkey {
	@Override
	public void gobble() {
		System.out.println("Gobble...");
	}

	@Override
	public void fly() {
		System.out.println("Flying a short distance...");
	}
}
