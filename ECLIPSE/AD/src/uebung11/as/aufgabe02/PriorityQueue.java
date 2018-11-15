/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May  6 21:58:27 CEST 2018
 */

package uebung11.as.aufgabe02;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue<K extends Comparable<? super K>, V> implements PriorityQueueInterface<K, V> {

	private LinkedList<Entry<K, V>> list;

	public PriorityQueue() {
		list = new LinkedList<Entry<K, V>>();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if(list.isEmpty()) {
			throw new EmptyPriorityQueueException("Leere Liste");
		}
		return list.getFirst();
	}

	public void insert(K key, V value) {
		ListIterator<Entry<K, V>> it = list.listIterator();
	    while(it.hasNext()) {
	      if (key.compareTo(it.next().getKey()) <= 0) {
	        it.previous();
	        break;
	      }
	    }
	    it.add(new Entry<K, V>(key, value));
	}

	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		return list.removeFirst();
	}

	public void print() {
		System.out.println("Print priority queue entries: ");
	    int i = 0;
	    for (Entry<K, V> entry: list) {
	      System.out.println("Element " + (++i) + " with key '" + entry.getKey()
	          + "' has the value '" + entry.getValue() + "'");
	    }
	}

	public static void main(String[] args) {
		PriorityQueue<Integer, String> pq = new PriorityQueue<Integer, String>();
		pq.insert(8, "eight");
		pq.insert(2, "two");
		pq.insert(5, "five");
		pq.insert(1, "one");
		pq.insert(2, "two");
		pq.insert(1, "one");
		pq.insert(4, "four");
		pq.insert(4, "four");
		pq.insert(7, "seven");
		pq.insert(2, "two");
		pq.insert(6, "six");
		pq.insert(3, "three");
		pq.insert(1, "one");

		pq.print();
	}
}

/*
 * Session-Log (SOLL):
 * 
 * Print priority queue entries: Element 1 with key '1' has the value 'one'
 * Element 2 with key '1' has the value 'one' Element 3 with key '1' has the
 * value 'one' Element 4 with key '2' has the value 'two' Element 5 with key '2'
 * has the value 'two' Element 6 with key '2' has the value 'two' Element 7 with
 * key '3' has the value 'three' Element 8 with key '4' has the value 'four'
 * Element 9 with key '4' has the value 'four' Element 10 with key '5' has the
 * value 'five' Element 11 with key '6' has the value 'six' Element 12 with key
 * '7' has the value 'seven' Element 13 with key '8' has the value 'eight'
 * 
 */
