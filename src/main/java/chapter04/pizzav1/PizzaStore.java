package chapter04.pizzav1;

import chapter04.Pizza;

public class PizzaStore {
	SimplePizzaFactory simplePizzaFactory;

	public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
		this.simplePizzaFactory = simplePizzaFactory;
	}

	Pizza orderPizza(String type) {
		Pizza pizza;

		pizza = simplePizzaFactory.createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	public static void main(String[] args) {
		PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
		pizzaStore.orderPizza("Cheese");
		pizzaStore.orderPizza("Greek");
	}

}
