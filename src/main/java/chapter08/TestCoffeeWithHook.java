package chapter08;

public class TestCoffeeWithHook {
	public static void main(String[] args) {
		CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

		System.out.println("Make coffee \n");
		coffeeWithHook.prepareRecipe();
	}
}
