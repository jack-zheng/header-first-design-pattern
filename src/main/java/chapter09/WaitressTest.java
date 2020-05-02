package chapter09;

public class WaitressTest {
	public static void main(String[] args) {
//		Waitress waitress = new Waitress(new PancakeHouseMenu(), new DinerMenu());
//		waitress.printMenu();
//
//		System.out.println("<--------------- build in Iterator --------------->");
//		waitress.printMenuBuildInIterator();

		WaitressV2 v2 = new WaitressV2(new PancakeHouseMenu(), new DinerMenu(), new CafeMenu());
		v2.printMenuBuildInIterator();
	}
}
