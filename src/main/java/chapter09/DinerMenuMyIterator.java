package chapter09;

public class DinerMenuMyIterator implements MyIterator {
	private MenuItem[] menuItems;
	private int position = 0;

	public DinerMenuMyIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		if (position >= menuItems.length || menuItems[position] == null) {
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		MenuItem item = menuItems[position];
		position++;
		return item;
	}
}
