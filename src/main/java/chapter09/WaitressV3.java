package chapter09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WaitressV3 {
	private List<Menu> list;

	public WaitressV3(List<Menu> list) {
		this.list = list;
	}

	public void printMenu() {
		for (Menu menu : list) {
			printBuildInMenu(menu.createBuildInIterator());
		}
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
