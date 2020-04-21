package chapter03.starbuzz;

public abstract class Beverage {
	String desciption = "Unknown Beverage";
	public String getDescription() {
		return desciption;
	}

	public abstract double cost();
}
