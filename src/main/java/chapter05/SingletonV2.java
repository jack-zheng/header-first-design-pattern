package chapter05;

public class SingletonV2 {
	private static SingletonV2 uniqueInstance = new SingletonV2();

	private SingletonV2() {
	}

	public static SingletonV2 getInstance() {
		return uniqueInstance;
	}
}
