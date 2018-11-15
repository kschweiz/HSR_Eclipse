package StackByLinkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedStack implements Stack{


	List<Integer> list = new ArrayList<>();
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(int element) {
		list.add(element);

	}

	@Override
	public void pop() {

		list.remove(list.size()-1);		
	}

	@Override
	public int peek() {
		if(list.size()!=0) {
			return list.get(list.size()-1);
		}else {
			return 0;
		}
		
	}

	
	
	
}
