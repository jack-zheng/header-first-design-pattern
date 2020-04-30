package chapter08;

public class TeaV2 extends CaffeineBeverage {
	@Override
	void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Lemon");
	}
}
