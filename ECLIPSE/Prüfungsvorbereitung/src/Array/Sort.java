package Array;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Sort {	
	
	static Map<Integer, Integer> test = new HashMap<>();
	
	
	
	public static int[] list = new int[7];
	static int entries = 6;
	public static void main(String[] args) {
		
		test.put(1, 10);
		test.put(2, 20);
		
		Map<Integer, Integer> test = new HashMap<>();
		Iterator it = test.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<Integer, Integer> entry = (Entry<Integer, Integer>) it.next();
			System.out.println(entry.getKey() +  " " + entry.getValue());
		}
		
		
		list[0] = 100;
		list[1] = 80;
		list[2] = 68;
		list[3] = 50;
		list[4] = 45;
		list[5] = 20;
//		System.out.println(Arrays.toString(list));
//		add(60);
//		System.out.println(Arrays.toString(list));
//		remove(2);
		System.out.println(Arrays.toString(list));
		//insert(3, 56);
		insertAtIndex(3, 56);
		System.out.println(Arrays.toString(list));
	}
	
	//add Score 60 to List
	public static void add(int i) {
		int newScore = i;
		int j = list.length-1;
		
		while(j>0 && list[j-1]<newScore) {
			list[j] = list[j-1];
			j--;
		}
		list[j] = i;
	}
	
	//remove Object at Index position
	public static int remove(int index) {
		int temp = list[index];
		for (int j = index; j < list.length-1; j++) {
			list[j] = list[j+1];
			
		}
		list[list.length-1] = 0;
		return temp;
	}
	
	public static void insertAtIndex(int index, int element) {
		for(int i = list.length-1; i > index ; i--) {
			list[i] = list[i-1];
		}
		list[index] = element;
	}
	
	public static void insert(int i, int e) {
		for (int k = list.length-1; k>=i;k--) {
			list[k+1] = list[k];
		}
		list[i] = e;
	}

}

class TreeLinkedList<E> extends LinkedList<E>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private E element; //Ref Element
	private TreeLinkedList<E> parent; //Ref Parent
	private List<E> childList = new ArrayList<E>(); //Ref List of Children
}


