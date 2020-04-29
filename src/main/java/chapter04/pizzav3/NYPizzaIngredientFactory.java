package chapter04.pizzav3;

import chapter04.Cheese;
import chapter04.Clams;
import chapter04.Dough;
import chapter04.FreshClams;
import chapter04.Garlic;
import chapter04.MarinaraSauce;
import chapter04.Mushroom;
import chapter04.Pepperoni;
import chapter04.ReggianoCheese;
import chapter04.Sauce;
import chapter04.SlicedPepperoni;
import chapter04.ThinCrustDough;
import chapter04.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		return new Veggies[] {new Garlic(), new Mushroom()};
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}
}
