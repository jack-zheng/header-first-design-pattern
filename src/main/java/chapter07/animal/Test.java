package chapter07.animal;

public class Test {
	public static void main(String[] args) {
		MallardDuck mallardDuck = new MallardDuck();
		mallardDuck.quack();
		mallardDuck.fly();

		WildTurkey wildTurkey = new WildTurkey();
		wildTurkey.fly();
		wildTurkey.gobble();

		Duck duck = new TurkeyAdapter(wildTurkey);
		duck.fly();
		duck.quack();
	}
}
