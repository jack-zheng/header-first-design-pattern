package chapter05;

public class SingletonV3 {
	private volatile static SingletonV3 uniqueInstance;

	private SingletonV3() {
	}

	public static SingletonV3 getInstance() {
		if (uniqueInstance == null) {
			synchronized (SingletonV3.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SingletonV3();
				}
			}
		}
		return uniqueInstance;
	}
}
