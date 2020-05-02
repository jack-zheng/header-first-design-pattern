package chapter09;

import java.util.Iterator;

public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMenu() {
		MyIterator pancakeIterator = pancakeHouseMenu.createIterator();
		MyIterator dinerIterator = dinerMenu.createIterator();
		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
	}

	private void printMenu(MyIterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

	public void printMenuBuildInIterator() {
		Iterator pancakeIterator = pancakeHouseMenu.createBuildInIterator();
		Iterator dinerIterator = dinerMenu.createBuildInIterator();
		System.out.println("MENU\n----\nBREAKFAST");
		printBuildInMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printBuildInMenu(dinerIterator);
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
