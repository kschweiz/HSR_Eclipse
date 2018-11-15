/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May  6 21:58:27 CEST 2018
 */

package uebung11.as.aufgabe02;

/**
 * @author msuess
 */
public interface PriorityQueueInterface<K extends Comparable<? super K>, V> {

  int size();

  boolean isEmpty();

  Entry<K, V> min() throws EmptyPriorityQueueException;

  void insert(K key, V value);

  Entry<K, V> removeMin() throws EmptyPriorityQueueException;

  void print();
}
 
 
 
 
