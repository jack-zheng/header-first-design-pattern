package chapter04.pizzav3;

public class NYPizzaStore extends PizzaStoreV3 {
	PizzaV3 pizza = null;
	PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

	@Override
	public PizzaV3 createPizza(String type) {
		if (type.equals("cheese")) {
			pizza = new CheesePizzaV3(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		}
		return pizza;
	}
}
