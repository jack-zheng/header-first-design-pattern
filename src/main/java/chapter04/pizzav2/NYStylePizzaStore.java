package chapter04.pizzav2;

import chapter04.NYStyleCheesePizza;
import chapter04.NYStyleGreekPizza;
import chapter04.Pizza;

public class NYStylePizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		Pizza pizza;
		if (type.equals("Cheese")) {
			pizza = new NYStyleCheesePizza();
		} else {
			pizza = new NYStyleGreekPizza();
		}
		return pizza;
	}
}
