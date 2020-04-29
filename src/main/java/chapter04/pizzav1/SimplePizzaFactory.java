package chapter04.pizzav1;

import chapter04.CheesePizza;
import chapter04.GreekPizza;
import chapter04.Pizza;

public class SimplePizzaFactory {
	public Pizza createPizza(String type) {
		Pizza pizza;
		if (type.equals("Cheese")) {
			pizza = new CheesePizza();
		} else {
			pizza = new GreekPizza();
		}
		return pizza;
	}
}
