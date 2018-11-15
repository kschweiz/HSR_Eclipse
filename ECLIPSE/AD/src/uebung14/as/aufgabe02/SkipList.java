/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 27 15:52:25 CEST 2018
 */

package uebung14.as.aufgabe02;

import java.util.Random;

public class SkipList<K extends Comparable<? super K>, V> {
	
		
  protected int size; // elements in list (without tail and header)

  protected final int MAX_LEVEL; // maximum allowed height of list

  protected int highestLevel; // maximum current height of list

  protected final ListElement<K, V> header;

  protected final ListElement<K, V> tail;

  // don't ever directly compare to this one with equals(), only with ==
  protected final K minKey;

  // don't ever directly compare to this one with equals(), only with ==
  protected final K maxKey;

  private Random random;

  @SuppressWarnings("unchecked")
  public SkipList() {
    this(4);
    // TODO Implement here...

  }

  @SuppressWarnings("unchecked")
  public SkipList(int maxHeight) {
    minKey = (K) new Integer(0);
    maxKey = (K) new Integer(0);
    MAX_LEVEL = maxHeight;
    header = new ListElement<K, V>(MAX_LEVEL, minKey, null);
    tail = new ListElement<K, V>(0, maxKey, null);
    for (int i = 0; i <= MAX_LEVEL; i++) {
      header.forward[i] = tail;
    }
    size = 0;
    random = new Random(4); // always the same sequence
  }

  private boolean isSmaller(K key1, K key2) {
    if (key1 == minKey) {
      return true;
    }
    if (key2 == maxKey) {
      return true;
    }
    if (key1 == maxKey) {
      return false;
    }
    if (key2 == minKey) {
      return false;
    }
    return key1.compareTo(key2) < 0;
  }

  private int getRandomLevel() {
    int level = 0;
    while (random.nextBoolean() && level < MAX_LEVEL) {
      level++;
    }
    return level;
  }

  public V get(K key) {
    ListElement<K, V> aktElement = find(key, null);
    if ((aktElement != tail) && aktElement.key.equals(key))
      return aktElement.value;
    return null;
  }

  public V put(K key, V value) {
    // TODO Implement here...
    return null;
  }

  public V remove(K key) {
    // TODO Implement here...
    return null;
  }
  
  private ListElement<K, V> find(K key, ListElement<K, V>[] update) {
    ListElement<K, V> aktElement = header;
    for (int i = highestLevel; i >= 0; i--) {
      while (isSmaller(aktElement.forward[i].key, key)) {
        aktElement = aktElement.forward[i];
      }
      if (update != null) {
        update[i] = aktElement;
      }
    }
    return aktElement.forward[0];
  }

  public int size() {
    return size;
  }

  public void print() {
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("Size: " + size);
    ListElement<K, V> aktElement = header;
    Object[][] objMatrix = new Object[MAX_LEVEL + 1][size];
    aktElement = header.forward[0];
    int indx = 0;
    while (aktElement.key != maxKey) {
      for (int i = 0; i <= aktElement.level(); i++) {
        objMatrix[i][indx] = aktElement.key;
      }
      aktElement = aktElement.forward[0];
      indx++;
    }
    System.out.println("Highest-Level: " + highestLevel);
    System.out.println();
    for (int n = highestLevel; n >= 0; n--) {
      for (int i = 0; i < size; i++) {
        if (objMatrix[n][i] != null) {
          System.out.print(objMatrix[n][i].toString());
        }
        System.out.print("\t");
      }
      System.out.println();
    }
    System.out.println("--------------------------------------------------------------------------");
  }

  public ListElement<K, V> getHeader() {
    return header;
  }

  public static class ListElement<K extends Comparable<? super K>, V> {

    private K key;
    private V value;

    private ListElement<K, V>[] forward;

    public ListElement() {
    }

    public ListElement(int level, K key, V value) {
      this.key = key;
      this.value = value;
      forward = createArray(level + 1);
    }

    @SuppressWarnings("unchecked")
    static <K extends Comparable<? super K>, V> ListElement<K, V>[] createArray(
        int length) {
      return new ListElement[length];
    }

    public int level() {
      return forward.length - 1;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public ListElement<K, V>[] getForward() {
      return forward;
    }

  } // end of ListElement

  public static void main(String[] args) {
    SkipList<Integer, String> s = new SkipList<Integer, String>();
    s.print();

    s.put(12, "12");
    s.put(1, "1");
    s.put(8, "8");
    s.print();
  }
}
 
/* Session-Log (SOLL):

$ java -classpath Uebungen uebung14.as.aufgabe02.SkipList
--------------------------------------------------------------------------
Size: 7
Highest-Level: 3

3                                               34      
3                       9       11              34      
3               7       9       11              34      
3       4       7       9       11      13      34      
--------------------------------------------------------------------------
--------------------------------------------------------------------------
Size: 10
Highest-Level: 4

                                                        12                      
        3                                               12              34      
        3                               9       11      12              34      
        3               7       8       9       11      12              34      
1       3       4       7       8       9       11      12      13      34      
--------------------------------------------------------------------------
 
*/

 
 
