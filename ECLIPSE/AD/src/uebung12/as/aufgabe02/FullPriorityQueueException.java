/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 13 20:47:13 CEST 2018
 */

package uebung12.as.aufgabe02;


/**
 * Thrown at insert()-operation when PriorityQueue is already full.
 */
public class FullPriorityQueueException extends Exception {
  
  private static final long serialVersionUID = 1L;

  public FullPriorityQueueException() {
    super();
  }
}
