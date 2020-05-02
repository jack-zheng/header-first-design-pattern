package chapter09;

import java.util.Iterator;

public class DinerMenuBuildInIterator implements Iterator {
	private MenuItem[] menuItems;
	private int position = 0;

	public DinerMenuBuildInIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		if (position >= menuItems.length || menuItems[position] == null)
			return false;
		return true;
	}

	@Override
	public Object next() {
		MenuItem item = menuItems[position];
		position++;
		return item;
	}

	@Override
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException
							("You can’t remove an item until you’ve done at least one next()");
		}
		if (menuItems[position - 1] != null) {
			for (int i = position - 1; i < (menuItems.length - 1); i++) {
				menuItems[i] = menuItems[i + 1];
			}
			menuItems[menuItems.length - 1] = null;
		}
	}
}
