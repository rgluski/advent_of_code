package aoc.types;

import java.util.ArrayList;
import java.util.List;

public class CircularList<T> {
	private List<T> list = new ArrayList<>();
	
	public boolean add(T element) {
		return list.add(element);
	}
	
	public T get(T element, int offset) {
		int index = list.indexOf(element);
		
		if(index == -1) {
			throw new IllegalArgumentException();
		}
		
		index = (index + offset) % list.size();
		if(index < 0) {
			index = list.size() + index;
		}
		
		return list.get(index);
	}
	
	@SafeVarargs
	public static <T> CircularList<T> of(T ...elements) {
		CircularList<T> list = new CircularList<>();
		
		for(T element : elements) {
			list.add(element);
		}
		
		return list;
	}
}
