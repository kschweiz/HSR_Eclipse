/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 14 15:58:13 CEST 2018
 */

package uebung12.as.aufgabe02;


/**
 * A heap-based (array-implementation) Priority-Queue with fixed length.
 */
public class PriorityQueue<K extends Comparable<? super K>, V> {
  
  
  protected PQEntry<K, V>[] heapArray;

  /** Points to the last element in the heap. */
  protected int last = 0;
  
  public static class PQEntry<K extends Comparable<? super K>, V> implements
      Entry<K, V>, Comparable<PQEntry<K, V>> {

    protected K key;
    protected V value;

    protected PQEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public K getKey() {
      return key;
    }

    @Override
    public V getValue() {
      return value;
    }

    @Override
    public int compareTo(PQEntry<K, V> other) {
      return this.key.compareTo(other.key);
    }
    
    @Override
    public String toString() {
      return "("+key+","+value+")";
    }

  }


  @SuppressWarnings("unchecked")
  public PriorityQueue(int maxSize) {
    heapArray = new PQEntry[maxSize + 1];
  }

  public Entry<K, V> insert(K key, V value) throws FullPriorityQueueException {
    
    if(size() == heapArray.length-1) {
    	throw new FullPriorityQueueException();
    }
    
    last++;
    PQEntry<K, V> e = newEntry(key, value);
    heapArray[last] = e;
    
    upheap(last);
    return e;
  }
  
  public void upheap(int actualIndex) {
	  if(actualIndex == 1) {
		  return;
	  }
	  int parent = actualIndex/2;
	  if(heapArray[parent].compareTo(heapArray[actualIndex])>0) {
		  swap(parent, actualIndex);
	  }
	  upheap(parent);
  }
  
  public void swap(int parent, int child) {
	  PQEntry<K, V> temp = heapArray[parent];
	  heapArray[parent] = heapArray[child];
	  heapArray[child] = temp;
  }
  
  public Entry<K, V> min() {
    
    // TODO Implement here...
    
    return null;
  }

  public Entry<K, V> removeMin() {
    
    if(last == 0) {
    	return null;
    }
    PQEntry<K, V> result = heapArray[1];
    heapArray[1] = heapArray[last];
    heapArray[last]	= null;
    last--;
    downheap(1);
    return result;
  }
  
  public void downheap(int actualIndex) {
	  int leftChildIndex = actualIndex * 2;
	  int rightChildIndex = leftChildIndex +1;
	  
	  //boolean leftSmaler = 
  }
  
//  public boolean checkItem(int parent, int child) {
//	  
//  }

  /**
   * Factory-Method for new entries.
   * @param key The key of the new entry.
   * @param value The value of the new entry.
   * @return The new created Entry.
   */
  protected PQEntry<K, V> newEntry(K key, V value) {
    return new PQEntry<K, V>(key, value);
  }

  public boolean isEmpty() {   
    return size() == 0;  
  }
  
  public int size() {
    
    return last;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < heapArray.length; i++) {
      PQEntry<K, V> e = heapArray[i];
      if (e != null) {
        sb.append('[');
        sb.append(e);
        sb.append(',');
        sb.append(i);
        sb.append(']');
      } else {
        sb.append("null");
      }
      if (i < heapArray.length-1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  public void print() {
    System.out.println(toString());
  }
  
  /**
   * If GVS is in use: The actual state will be shown on GVS.
   */
  public void displayOnGVS() {
  }

} 

 
