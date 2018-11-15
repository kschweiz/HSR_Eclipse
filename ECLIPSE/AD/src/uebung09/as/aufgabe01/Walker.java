/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Mon Apr 16 13:32:44 CEST 2018
 */

package uebung09.as.aufgabe01;


public class Walker {
  
  private static final int DELAY = 100;  // Delay in sleep()
  
  enum Direction { 
    
    NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0);
    
    private int offsetX;
    private int offsetY;
    
    Direction(int offsetX, int offsetY) {
      this.offsetX = offsetX;
      this.offsetY = offsetY;
    }
    
    int getOffsetX() {
      return offsetX;
    }
    
    int getOffsetY() {
      return offsetY;
    }
    
  } 

  /**
   * The Labyrinth where the Walker is.
   */
  Labyrinth lab;
  
  boolean sleeping = true;

  public Walker() {
    lab = new Labyrinth();
  }

  /**
   * Recursive method, which is called for every position to check.
   * 
   * Precondition: Position(x/y) is OPEN.
   * 
   * @param x
   *          X-Position to check.
   * @param y
   *          Y-Position to check.
   * @return True if the destination is found, else false.
   */
  public boolean walk(int x, int y) {
    
    // TODO Implement here...
    
    return true;
  }

  private void printLabyrinth() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      builder.append('\n');
    }
    System.out.println(builder.toString());
    lab.print();
    System.out.flush();
  }
  
  private void sleep(int ms) {
    if (sleeping) {
      try {
        Thread.sleep(ms);
      } catch (InterruptedException ex) {
      }
    }
  }

  public static void main(String[] args) {
    Walker walker = new Walker();
    // start walking at the start position
    if (walker.walk(walker.lab.getStartCol(), walker.lab.getStartRow())) {
      System.out.println("Finally found a way out!");
    } else {
      System.out.println("Desperate search ended unsuccessful...");
    }
  }
}


/* Session-Log (SOLL):

 # # # # # # # # # # # # #
 # o # . . # . . . . . . #
 # o # . # # . # . # . # #
 # o o . # . . # . # . . #
 # # o # # # # # . # # # #
 #   o o o o o o o o . . #
 #   # # # # # # # o # # #
 #       # o o o o o . . #
 # # # # # o # # # # # . #
 #         o # . # . # . #
 #   # # # o # . # . # # #
 #   #   # o o o # . # . #
 #       # # # o o o o o #
 # # # # # # # # # # # X #
Evaluating new possible solution (11/13)
Finally found a way out!

*/ 
 
 
