package chapter03.starbuzz;

public class Espresso extends Beverage {
	public Espresso() {
		desciption = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}
}
