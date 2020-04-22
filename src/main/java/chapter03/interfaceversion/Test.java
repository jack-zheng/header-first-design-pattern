package chapter03.interfaceversion;

public class Test {
	public static void main(String[] args) {
		Beverage b = new DarkRost();
		System.out.println(b.getDesc() + "; $" + b.cost());

		Beverage mix = new Whip(new Mocha(new DarkRost()));
		System.out.println(mix.getDesc() + "; $" + mix.cost());
	}
}
