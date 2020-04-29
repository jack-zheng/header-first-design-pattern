package chapter04.pizzav3;

import chapter04.Pizza;

public abstract class PizzaStoreV3 {
	PizzaV3 orderPizza(String type) {
		PizzaV3 pizza;

		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	public abstract PizzaV3 createPizza(String type);
}
