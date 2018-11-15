/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Tue May 22 07:59:37 CEST 2018
 */

package uebung13.as.aufgabe01;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {

  private final K key;
  private V value;

  public MapEntry(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public V setValue(V value) {
    V oldValue = this.value;
    this.value = value;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (!(o instanceof Map.Entry))
      return false;
    MapEntry<K, V> e = (MapEntry<K, V>) o;
    Object k1 = getKey();
    Object k2 = e.getKey();
    if (k1 == k2 || (k1 != null && k1.equals(k2))) {
      Object v1 = getValue();
      Object v2 = e.getValue();
      if (v1 == v2 || (v1 != null && v1.equals(v2)))
        return true;
    }
    return false;
  }

  public int hashCode() {
    return (key == null ? 0 : key.hashCode())
         ^ (value == null ? 0 : value.hashCode());
  }
  

}
 
