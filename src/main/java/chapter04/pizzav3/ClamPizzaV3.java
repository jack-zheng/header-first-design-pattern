package chapter04.pizzav3;

public class ClamPizzaV3 extends PizzaV3 {
	PizzaIngredientFactory ingredientFactory;

	public ClamPizzaV3(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {
		System.out.println("Preparing" + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		clam = ingredientFactory.createClam();
	}
}
