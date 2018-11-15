/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun Apr 29 19:01:37 CEST 2018
 */

package uebung10.as.aufgabe01;

/**
 * @author msuess
 */
public interface TreeInterface<T> {

  T root();

  void setRoot(T root);

  T parent(T child) throws NoSuchNodeException;

  T leftChild(T parent) throws NoSuchNodeException;

  T rightChild(T parent) throws NoSuchNodeException;

  boolean isInternal(T node) throws NoSuchNodeException;

  boolean isExternal(T node) throws NoSuchNodeException;

  boolean isRoot(T node);

  void setRightChild(T parent, T child) throws NoSuchNodeException;

  void setLeftChild(T parent, T child) throws NoSuchNodeException;

  void removeRightChild(T parent) throws NoSuchNodeException;

  void removeLeftChild(T parent) throws NoSuchNodeException;

  int size();

}
 
 
 
 
