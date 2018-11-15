/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Tue May 22 07:59:37 CEST 2018
 */

package uebung13.as.aufgabe01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MapImplJUnitTest {

  private MapImpl<Integer, String> map;

  @Before
  public void initTest() {
    map = new MapImpl<Integer, String>();
  }

  @Test
  public void test1FillingAndRemoving() {
    final int LEN = 3;
    assertTrue(map.isEmpty());
    assertEquals(0, map.size());
    for (int i = 0; i < LEN; i++) {
      map.put(i, "String_" + i);
      assertEquals(i + 1, map.size());
    }
    for (int i = 0; i < LEN; i++) {
      map.remove(i);
      assertEquals(LEN - i - 1, map.size());
    }
    assertTrue(map.isEmpty());
    assertEquals(0, map.size());
  }
  
  @Test
  public void test2Put() {
    map.put(1, "String_1");
    assertEquals("String_1", map.put(1, "String_1.1"));
    assertEquals("String_1.1", map.get(1));
  }

  @Test
  public void test3Searching() {
    assertFalse(map.containsKey(0));
    assertFalse(map.containsValue("String_0"));
    assertNull(map.get(0));
    assertNull(map.remove(0));
    final int LEN = 10000;
    fillMapWithEntries(map, LEN);
    assertEquals(LEN, map.size());
    assertEquals("String_1", map.get(1));
    assertTrue(map.containsKey(LEN));
    assertTrue(map.containsValue("String_" + LEN));
    assertFalse(map.containsKey(LEN + 1));
    assertFalse(map.containsValue("String_" + (LEN + 1)));
  }

  @Test
  public void test4PutAll() {
    MapImpl<Integer, String> map1 = new MapImpl<Integer, String>();
    fillMapWithEntries(map1, 1, 10);
    MapImpl<Integer, String> map2 = new MapImpl<Integer, String>();
    fillMapWithEntries(map2, 5, 10);
    map1.putAll(map2);
    assertEquals(14, map1.size());
  }

  @Test
  public void test5Sets() {
    final int LEN = 3;
    fillMapWithEntries(map, LEN);
    Set<Entry<Integer, String>> entrySet = map.entrySet();
    assertEquals(LEN, entrySet.size());
    Set<Integer> keySet = map.keySet();
    for (int i = 1; i <= LEN; i++) {
      assertTrue(keySet.contains(i));
    }
    map.clear();
    assertEquals(0, map.size());
  }
  
  @Test
  public void test6Values() {
    final int LEN = 3;
    fillMapWithEntries(map, LEN);
    Collection<String> values = map.values();
    for (int i = 1; i <= LEN; i++) {
      String str = "String_" + i;
      assertTrue(values.contains(str));
    }
  }

  @Test
  public void test7Nulls() {
    assertEquals(null, map.put(null, "NULL 1"));
    assertEquals("NULL 1", map.put(null, "NULL 2"));
    assertEquals("NULL 2", map.get(null));
    assertEquals(true, map.containsKey(null));
    assertEquals("NULL 2", map.remove(null));
    assertEquals(null, map.put(0, null));
    assertEquals(true, map.containsValue(null));
  }

  /**
   * Filling the map with sequence of entries: [1, "String_1"], [2, "String_2"],
   * ...
   * 
   * @param map
   *          The map to fill.
   * @param nr
   *          Number of entries to fill.
   */
  private void fillMapWithEntries(Map<Integer, String> map, int nr) {
    fillMapWithEntries(map, 1, nr);
  }

  /**
   * Filling the map with sequence of entries: [`start`, "String_`start`"],
   * [`start+1`, "String_`start+1`"], ...
   * 
   * @param map
   *          The map to fill.
   * @param start
   *          Number for first entry.
   * @param nr
   *          Number of entries to fill.
   */
  private void fillMapWithEntries(Map<Integer, String> map, int start, int nr) {
    for (int i = start; i < start + nr; i++) {
      map.put(i, "String_" + i);
    }
  }

}

