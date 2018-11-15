/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 13 20:47:13 CEST 2018
 */

package uebung12.as.aufgabe02;

import uebung12.as.aufgabe02.Entry;
import uebung12.as.aufgabe02.FullPriorityQueueException;
import gvs.tree.GVSBinaryTreeNode;
import gvs.tree.GVSTreeWithRoot;
import gvs.typ.node.GVSNodeTyp;

public class PriorityQueueGVS<K extends Comparable<? super K>, V> extends PriorityQueue<K, V> {

  protected GVSTreeWithRoot gvsTree = new GVSTreeWithRoot("PriorityQueue");

  protected class PQEntryGVS extends PriorityQueue.PQEntry<K, V> implements GVSBinaryTreeNode {

    protected PQEntryGVS(K key, V value) {
      super(key, value);
    }

    public GVSBinaryTreeNode getGVSLeftChild() {
      int leftIndex = getIndex() * 2;
      return (GVSBinaryTreeNode) (leftIndex <= last() ? heapArray[leftIndex] : null);
    }

    public GVSBinaryTreeNode getGVSRightChild() {
      int rightIndex = getIndex() * 2 + 1;
      return (GVSBinaryTreeNode) (rightIndex <= last() ? heapArray[rightIndex] : null);
    }

    public String getNodeLabel() {
      PQEntry<K, V> e = (PQEntry<K, V>)heapArray[getIndex()];
      return e.getKey().toString() + " / " + e.getValue().toString();
    }

    public GVSNodeTyp getNodeTyp() {
      return null;
    }
    
    private int getIndex() {
      for (int i = 0; i < heapArray.length; i++) {
        if (heapArray[i] == this) {
          return i;
        }
      }
      return -1;
    }
    
    private int last() {
      int last = -1;
      for (int i = 0; i < heapArray.length; i++) {
        if (heapArray[i] != null) {
          last = i;
        }
      }
      return last;
    }

  } // class PriorityQueueGVS.PQEntryGVS
  
  PriorityQueueGVS(int maxSize) {
    super(maxSize);
  }
  
  @Override
  protected PQEntry<K, V> newEntry(K key, V value) {
    return new PQEntryGVS(key, value);
  }

  @Override
  public Entry<K, V> insert(K key, V value) throws FullPriorityQueueException {
    Entry<K, V> newEntry = super.insert(key, value);
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
    return newEntry;
  }
  
  @Override
  public Entry<K, V> removeMin() {
    Entry<K, V> removedEntry = super.removeMin();
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
    return removedEntry;
  }
  
//  @Override
//  protected void swap(int parent, int child) {
//    super.swap(parent, child);
//    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
//    gvsTree.display();
//  }
  
  @Override
  public void displayOnGVS() {
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
  }

}
 
