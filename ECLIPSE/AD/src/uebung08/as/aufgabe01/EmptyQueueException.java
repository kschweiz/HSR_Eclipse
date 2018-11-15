/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Mon Apr  9 16:30:09 CEST 2018
 */

package uebung08.as.aufgabe01;

/**
 * Runtime exception thrown when one tries to perform operation on an empty
 * queue.
 */

public class EmptyQueueException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EmptyQueueException(String err) {
    super(err);
  }
}
 
 
 
