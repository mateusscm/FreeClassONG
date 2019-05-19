package util;

import java.util.HashMap;

public class IndexFactory {

	private static final int DEFAULT_MIN = 0;
	private HashMap<Integer, Integer> index;
	private int min;
	private int max;

	public static IndexFactory newInstance(int min, int max) {
		return new IndexFactory(min, max);
	}

	public static IndexFactory newInstance(int max) {
		return new IndexFactory(DEFAULT_MIN, max);
	}

	private IndexFactory(int min, int max) {
		this.min = min;
		this.max = max;
		index = new HashMap<Integer,Integer>();
		for (int i = min ; i <= max ; i++) {
			index.put(i, i);
		}
	}
	
	public int nextIndex() throws IndexOutOfBoundsException {
		if(this.min > max)
			throw new IndexOutOfBoundsException();
		int value = index.get(min);
		index.remove(min);
		this.min = value + 1;
		return value;
	}

}
