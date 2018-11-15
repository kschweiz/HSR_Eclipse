/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun Mar 11 18:58:00 CET 2018
 */

package v4_ad1_2018;

public interface Vektor {

  /**
   * Returns the number of elements in this vector.
   * @return The Number of elements.
   */
  int get_size();

  double get(int i);

  void set(int i, double val);

  /**
   * Calculates the scalar product of this vector multiplied with the 'right'-vector.
   * @param right The vector to multiply with.
   * @return  The scalar product of this vektor multiplied with 'right'.
   */
  double mult(Vektor right);

  /**
   * Multiplies the matrix 'left' with this vector as column vector.
   * @param left The matrix to multiply with.
   * @return The resulting column vector.
   */
  Vektor mult(Matrix left);

  /**
   * Transposes this vector: (V^T)ij = Vji
   * This means implicite, that a column vector becomes a row vector and vice versa.
   */
  void transpose();

  /**
   * Creates from this vector a new matrix with the same content. 
   * @return The new created matrix from this vector.
   */
  Matrix as_matrix();

  /**
   * Creates a identical copy of this vector.
   * @return The new created copy of this vector.
   */
  Vektor copy();

  void print();
}
 
