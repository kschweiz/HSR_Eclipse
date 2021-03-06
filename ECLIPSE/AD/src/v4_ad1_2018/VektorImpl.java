/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun Mar 11 18:58:00 CET 2018
 */

package v4_ad1_2018;

public class VektorImpl implements Vektor {

	public MatrixImpl matrix;

	public VektorImpl(int i) {
		matrix = new MatrixImpl(i, 1);
	}

	public int get_size() {
		return matrix.get_sizex() * matrix.get_sizey();
	}

	public double get(int i) {
		if(matrix.get_sizex()==1) {
			return matrix.get(0,i);
		}else {
			return matrix.get(i, 0);
		}
	}

	public void set(int i, double val) {
		if(matrix.get_sizex()==1) {
			matrix.set(0, i, val);
		}else {
			matrix.set(i, 0, val);
		}
		
	}

	public double mult(Vektor right) {
		Matrix m = matrix.mult(right.as_matrix());
		return m.get(0, 0);
	}

	public Vektor mult(Matrix left) {
		Matrix m = left.mult(matrix);
		//test ausgabe
		m.print();
		
		Vektor v = new VektorImpl(m.get_sizey());
		v.transpose();
		for(int i = 0 ; i<m.get_sizey(); i++) {
			v.set(i, m.get(0, i));
		}
		return v;
	}

	public void transpose() {
		matrix.transpose();
	}

	public Matrix as_matrix() {
		return matrix.copy();
	}

	public Vektor copy() {
		VektorImpl vec = new VektorImpl(0);
	    vec.matrix = (MatrixImpl)matrix.copy();
	    return vec;
	}

	public void print() {
		matrix.print();
	}
}
