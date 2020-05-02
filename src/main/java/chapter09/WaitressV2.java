package chapter09;

import java.util.Iterator;

public class WaitressV2 {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	Menu cafeMenu;

	public WaitressV2(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenuBuildInIterator() {
		Iterator pancakeIterator = pancakeHouseMenu.createBuildInIterator();
		Iterator dinerIterator = dinerMenu.createBuildInIterator();
		Iterator cafeIterator = cafeMenu.createBuildInIterator();
		System.out.println("MENU\n----\nBREAKFAST");
		printBuildInMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printBuildInMenu(dinerIterator);
		System.out.println("\nCAFE");
		printBuildInMenu(cafeIterator);
	}

	private void printBuildInMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
}
