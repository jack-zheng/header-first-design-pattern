package chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaitressV3Test {
	public static void main(String[] args) {
		List<Menu> menus = Arrays.asList(new PancakeHouseMenu(), new DinerMenu(), new CafeMenu());
		WaitressV3 v3 = new WaitressV3(menus);
		v3.printMenu();
	}
}
