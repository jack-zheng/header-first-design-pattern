package chapter04.pizzav3;

public class CheesePizzaV3 extends PizzaV3 {
	PizzaIngredientFactory factory;

	public CheesePizzaV3(PizzaIngredientFactory factory) {
		this.factory = factory;
	}

	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = factory.createDough();
		sauce = factory.createSauce();
		cheese = factory.createCheese();
	}
}
