package chapter08.ducksort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Duck d1 = new Duck("d1", 100);
		Duck d2 = new Duck("d2", 80);
		Duck d3 = new Duck("d3", 90);

		Duck[] ducks = new Duck[]{d1, d2, d3};
		Arrays.sort(ducks);

		for (Duck duck : ducks) {
			System.out.println(duck);
		}
	}
}
