package chapter04.pizzav3;

import chapter04.Cheese;
import chapter04.Clams;
import chapter04.Dough;
import chapter04.Pepperoni;
import chapter04.Sauce;
import chapter04.Veggies;

public abstract class PizzaV3 {
	String name;
	Dough dough;
	Sauce sauce;

	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;

	public abstract void prepare();

	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
