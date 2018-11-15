/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May  6 21:58:27 CEST 2018
 */

package uebung11.as.aufgabe02;

/**
 * Runtime exception thrown when one tries to perform operation on an empty
 * priority queue.
 */

public class EmptyPriorityQueueException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EmptyPriorityQueueException(String err) {
    super(err);
  }
}
 
 
 
 
