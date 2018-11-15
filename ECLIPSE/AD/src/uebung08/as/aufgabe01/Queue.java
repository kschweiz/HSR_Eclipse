/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Mon Apr  9 16:30:09 CEST 2018
 */

package uebung08.as.aufgabe01;

public interface Queue<T> {

  /**
   * Returns the number of elements in the queue.
   * 
   * @return Number of elements in the queue.
   */
  public int size();

  /**
   * Returns whether the queue is empty.
   * 
   * @return True if the queue is empty, false otherwise.
   */
  public boolean isEmpty();

  /**
   * Inspects the element at the front of the queue.
   * 
   * @return Element at the front of the queue.
   * @exception EmptyQueueException
   *              If the queue is empty.
   */
  public T front() throws EmptyQueueException;

  /**
   * Inserts an element at the rear of the queue.
   * 
   * @param element
   *          New element to be inserted.
   */
  public void enqueue(T element);

  /**
   * Removes the element at the front of the queue.
   * 
   * @return Element removed.
   * @exception EmptyQueueException
   *              If the queue is empty.
   */
  public T dequeue() throws EmptyQueueException;
  
  /**
   * Prints the contents of the queue to the console. 
   */
  public void print();
  
}
 
 
 
