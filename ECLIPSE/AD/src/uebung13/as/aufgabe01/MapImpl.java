/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Tue May 22 07:59:37 CEST 2018
 */

package uebung13.as.aufgabe01;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MapImpl<K, V> implements Map<K, V> {

  private LinkedList<MapEntry<K, V>> list;

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return size()==0;
  }

  public boolean containsKey(Object key) {
    for(MapEntry<K, V> entry: list) {
    	K thiskey = entry.getKey();
    	if(thiskey == key || thiskey != null && thiskey.equals(key)) {
    		return true;
    	}
    }
    return false;
  }

  public boolean containsValue(Object value) {
    // TODO Implement here...
    return false;
  }

  public V get(Object key) {
    // TODO Implement here...
    return null;
  }

  public V put(K key, V value) {
    // TODO Implement here...
    return null;
  }

  public V remove(Object key) {
    // TODO Implement here...
    return null;
  }

  public void putAll(Map<? extends K, ? extends V> map) {
    // TODO Implement here...
  }

  public void clear() {
    // TODO Implement here...
  }

  public Set<K> keySet() {
    // TODO Implement here...
    return null;
  }

  public Collection<V> values() {
    // TODO Implement here...
    return null;
  }

  public Set<Entry<K, V>> entrySet() {
    // TODO Implement here...
    return null;
  }

  public void print() {
    Iterator it = 
  }

  public static void main(String[] args) {
    
    MapImpl<Integer, String> map1 = new MapImpl<Integer, String>();
    map1.put(1, "one");
    map1.put(5, "five 1");
    map1.put(10, "ten");
    map1.put(5, "five 2");
    map1.put(54, "fifty-four");
    map1.print();

    MapImpl<Integer, String> map2 = new MapImpl<Integer, String>();
    map2.put(2, "two");
    map2.put(6, "six 1");
    map2.put(5, "five 3");
    map2.put(11, "eleven");
    map2.put(55, "fifty-five");
    map2.put(6, "six 2");
    map2.print();

    map1.putAll(map2);
    map1.print();
    
  }
}

/* Session-Log (SOLL; Hinweis: Reihenfolge der Entries ist irrelevant):

Printing map (4 Entries): 
    1: one
    5: five 2
   10: ten
   54: fifty-four
Printing map (5 Entries): 
    2: two
    6: six 2
    5: five 3
   11: eleven
   55: fifty-five
Printing map (8 Entries): 
    1: one
    5: five 3
   10: ten
   54: fifty-four
    2: two
    6: six 2
   11: eleven
   55: fifty-five

*/

