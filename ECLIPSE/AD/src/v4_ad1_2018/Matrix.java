/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun Mar 11 18:58:00 CET 2018
 */

package v4_ad1_2018;

public interface Matrix {

  int get_sizex();

  int get_sizey();

  double get(int x, int y);

  void set(int x, int y, double val);

  void transpose();

  Matrix mult(Matrix right);

  Matrix copy();

  void print();
}
 
 
