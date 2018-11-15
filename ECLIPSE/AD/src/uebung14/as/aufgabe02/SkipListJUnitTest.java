/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 27 15:52:25 CEST 2018
 */

package uebung14.as.aufgabe02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SkipListJUnitTest {

  SkipList<Integer, String> skipList;

  @Before
  public void setUp() {
    skipList = new SkipList<Integer, String>(4);
  }

  @Test
  public void test1Init() {
    assertEquals(0, skipList.size());
  }

  @Test
  public void test2Put() {
    assertNull(skipList.put(1, "value_1"));
    assertEquals(1, skipList.size());
    assertEquals("value_1", skipList.put(1, "value_2"));
    assertEquals(1, skipList.size());
  }

  @Test
  public void test3Get() {
    assertNull(skipList.get(-1));
    test2Put();
    assertNull(skipList.get(-1));
    assertEquals("value_2", skipList.get(1));
    assertNull(skipList.get(2));
  }

  @Test
  public void test4Remove() {
    assertNull(skipList.remove(-1));
    test2Put();
    assertNull(skipList.remove(-1));
    assertEquals("value_2", skipList.remove(1));
    assertNull(skipList.remove(1));
  }
  
  @Test
  public void test5StressTest() {

    final int NUMBER_OF_TESTS = 10000;
    final int RANGE = 100;
    Random rand = new Random(1);
    Map<Integer, String> map = new HashMap<Integer, String>();

    for (int i = 0; i < NUMBER_OF_TESTS; i++) {
      int n = rand.nextInt() % RANGE;
      String str = "String_" + n;

      String retMap = map.put(n, str);
      String retSkipList = skipList.put(n, str);
      assertEquals(retMap, retSkipList);

      int sizeMap = map.size();
      int sizeSkipList = skipList.size();
      assertEquals(sizeMap, sizeSkipList);

      for (int j = -RANGE; j <= RANGE; j++) {
        String mapGet = map.get(j);
        String skipListGet = skipList.get(j);
        assertEquals(mapGet, skipListGet);
      }

    }

    for (int i = -RANGE; i <= RANGE; i++) {
      String mapRemove = map.remove(i);
      String skipListRemove = skipList.remove(i);
      assertEquals(mapRemove, skipListRemove);
    }
    
  }

}
 
 
 
