package chapter04.pizzav3;

import chapter04.Cheese;
import chapter04.Clams;
import chapter04.Dough;
import chapter04.Pepperoni;
import chapter04.Sauce;
import chapter04.Veggies;

public interface PizzaIngredientFactory {
	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();

	public Veggies[] createVeggies();

	public Pepperoni createPepperoni();

	public Clams createClam();
}
