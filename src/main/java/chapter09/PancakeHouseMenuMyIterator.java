package chapter09;

import java.util.ArrayList;

public class PancakeHouseMenuMyIterator implements MyIterator {
	private ArrayList<MenuItem> list;
	private int position = 0;

	public PancakeHouseMenuMyIterator(ArrayList<MenuItem> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		if (position >= list.size() || list.get(position) == null)
			return false;
		return true;
	}

	@Override
	public Object next() {
		MenuItem item = list.get(position);
		position++;
		return item;
	}
}
