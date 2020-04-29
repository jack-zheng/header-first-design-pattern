package chapter04;

public class ChicagoStyleGreekPizza extends Pizza {
	public ChicagoStyleGreekPizza() {
		name = "Chicago Style Greek Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum potato Sauce";
		toppings.add("Shredded Mozzarella Cheese");
	}

	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
