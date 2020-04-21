package chapter03.starbuzz;

public class Test {
	public static void main(String[] args) {
		Beverage espresso = new Espresso();
		System.out.println(espresso.getDescription() + ", cost: $" + espresso.cost());

		Beverage mix = new Whip(new Mocha(new Espresso()));
		System.out.println(mix.getDescription() + ", cost:$ " + mix.cost());

		Beverage mix02 = new Whip(new Mocha(new HouseBlend()));
		System.out.println(mix02.getDescription() + ", cost:$ " + mix02.cost());
	}
}
