package chapter04.pizzav2;

import chapter04.ChicagoStyleCheesePizza;
import chapter04.ChicagoStyleGreekPizza;
import chapter04.NYStyleCheesePizza;
import chapter04.NYStyleGreekPizza;
import chapter04.Pizza;

public class ChicagoStylePizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		Pizza pizza;
		if (type.equals("Cheese")) {
			pizza = new ChicagoStyleCheesePizza();
		} else {
			pizza = new ChicagoStyleGreekPizza();
		}
		return pizza;
	}
}
