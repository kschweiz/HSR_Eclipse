/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun Apr 29 19:01:37 CEST 2018
 */

package uebung10.as.aufgabe01;

import java.util.ArrayList;

public class VectorTree<T> implements TreeInterface<T> {

	private ArrayList<T> binaryTree;
	private int size;

	public VectorTree() {
		binaryTree = new ArrayList<T>();
		binaryTree.add(0, null);
		binaryTree.add(1, null);
	}

	private int position(T node) throws NoSuchNodeException {
		int pos = binaryTree.indexOf(node);
		if (pos == -1) {
			throw new NoSuchNodeException();
		}
		return pos;
	}

	public T root() {
		return binaryTree.get(1);
	}

	public void setRoot(T root) {
		binaryTree.set(1, root);
		size = 1;
	}

	public T parent(T child) throws NoSuchNodeException {
		if (isRoot(child)) {
			return null;
		} else {
			return binaryTree.get(position(child) / 2);
		}
	}

	public T leftChild(T parent) throws NoSuchNodeException {
		int pos = 2 * position(parent);
		if(pos<binaryTree.size()-1) {
			return binaryTree.get(2 * position(parent));
		}else {
			return null;
		}

	}

	public T rightChild(T parent) throws NoSuchNodeException {
		int pos = 2 * position(parent);
		if(pos<binaryTree.size()-1) {
			return binaryTree.get(2 * position(parent)+1);
		}else {
			return null;
		}

	}

	public boolean isInternal(T node) throws NoSuchNodeException {
		return !isExternal(node);
	}

	public boolean isExternal(T node) throws NoSuchNodeException {
		return (leftChild(node) == null && rightChild(node) == null);
	}

	public boolean isRoot(T node) {
		return binaryTree.get(1) == node;
	}

	public void setRightChild(T parent, T child) throws NoSuchNodeException {
		int posParent = binaryTree.indexOf(parent);
		assureSize(2*posParent);
		binaryTree.set(2 * posParent, child);
		size++;
	}

	public void setLeftChild(T parent, T child) throws NoSuchNodeException {
		int posParent = binaryTree.indexOf(parent);
		assureSize(2*posParent+1);
		binaryTree.set(2 * posParent + 1, child);
		size++;
	}

	public void removeRightChild(T parent) throws NoSuchNodeException {
		if(parent == null) {
			return;
		}
		if(!isExternal(parent)) {
			removeRightChild(leftChild(parent));
			removeRightChild(rightChild(parent));
		}
		int pos = binaryTree.indexOf(parent);
		binaryTree.remove(pos);
		size--;
	}

	public void removeLeftChild(T parent) throws NoSuchNodeException {
		if(parent == null) {
			return;
		}
		if(!isExternal(parent)) {
			removeLeftChild(leftChild(parent));
			removeLeftChild(rightChild(parent));	
		}
		int pos = binaryTree.indexOf(parent);
		binaryTree.remove(pos);
		size--;
	}

	public int size() {
		return size;
	}

	public void printVector() {
		System.out.println(binaryTree);
	}
	
	  private void assureSize(int pos) {
		    int btSize = binaryTree.size();
		    if (pos >= btSize) {
		      for (int i = btSize; i <= pos; i++) {
		        binaryTree.add(null);
		      }
		    }
		  }

	public static void main(String[] args) throws NoSuchNodeException {

		// Hinweis:
		// Beispiel ist aus Folien-Skript "Speicherverfahren für Bäume: Array basiert"

		VectorTree<Character> vt = new VectorTree<Character>();
		if (vt.size() != 0) {
			throw new Error("Bad size: " + vt.size() + " != 0");
		}
		if (vt.root() != null) {
			throw new Error("vt.root() != null");
		}

		System.out.println("\nSetting root with 'A':");
		Character a = 'A';
		vt.setRoot(a);
		vt.printVector();
		if (vt.size() != 1) {
			throw new Error("Bad size: " + vt.size() + " != 1");
		}
		if (!vt.isRoot(a)) {
			throw new Error("!vt.root(a)");
		}
		if (!vt.root().equals(a)) {
			throw new Error("!vt.root().equals(a) : " + vt.root());
		}
		if (!vt.isExternal(a)) {
			throw new Error("!vt.isExternal(a)");
		}
		if (vt.parent(a) != null) {
			throw new Error("vt.parent(a) != null");
		}

		System.out.println("\nSetting right child of 'A' with 'D':");
		Character d = 'D';
		vt.setRightChild(vt.root(), d);
		vt.printVector();
		if (vt.size() != 2) {
			throw new Error("Bad size: " + vt.size() + " != 2");
		}
		if (!vt.rightChild(vt.root()).equals(d)) {
			throw new Error("!vt.rightChild(vt.root()).equals(d) : " + vt.rightChild(vt.root()));
		}
		if (!vt.isExternal(d)) {
			throw new Error("!vt.isExternal(d)");
		}
		if (!vt.isInternal(vt.root())) {
			throw new Error("!vt.isInternal(vt.root()");
		}
		if (!vt.parent(d).equals(a)) {
			throw new Error("!vt.parent(d).equals(a)");
		}

		System.out.println("\nSetting left child of 'A' with 'B':");
		Character b = 'B';
		vt.setLeftChild(vt.root(), b);
		vt.printVector();
		if (vt.size() != 3) {
			throw new Error("Bad size: " + vt.size() + " != 3");
		}

		System.out.println("\nSetting right child of 'B' with 'F':");
		Character f = 'F';
		vt.setRightChild(b, f);
		vt.printVector();

		System.out.println("\nSetting right child of 'F' with 'H':");
		Character h = 'H';
		vt.setRightChild(f, h);
		vt.printVector();

		System.out.println("\nSetting left child of 'F' with 'G':");
		Character g = 'G';
		vt.setLeftChild(f, g);
		vt.printVector();
		if (vt.size() != 6) {
			throw new Error("Bad size: " + vt.size() + " != 6");
		}
		if (!vt.isInternal(f)) {
			throw new Error("!vt.isInternal(f)");
		}
		if (!vt.isExternal(h)) {
			throw new Error("!vt.isExternal(h)");
		}
		if (!vt.rightChild(vt.rightChild(vt.leftChild(vt.root()))).equals(h)) {
			throw new Error("!vt.rightChild(vt.rightChild(vt.leftChild(vt.root()))).equals(h)");
		}

		vt.removeLeftChild(b);
		if (vt.size() != 6) {
			throw new Error("Bad size: " + vt.size() + " != 6");
		}

		System.out.println("\nRemoving right child of 'B':");
		vt.removeRightChild(b);
		vt.printVector();
		if (vt.size() != 3) {
			throw new Error("Bad size: " + vt.size() + " != 3");
		}
		if (!vt.isExternal(b)) {
			throw new Error("!vt.isExternal(b)");
		}

		System.out.println("\nSetting right child of 'D' with 'J':");
		vt.setRightChild(d, 'J');
		vt.printVector();

		System.out.println("\nSetting right child of root 'A' with 'X':");
		vt.setRightChild(a, 'X');
		vt.printVector();
		if (vt.size() != 3) {
			throw new Error("Bad size: " + vt.size() + " != 3");
		}

		System.out.println("\nSetting root with 'Y':");
		vt.setRoot('Y');
		vt.printVector();
		if (vt.size() != 1) {
			throw new Error("Bad size: " + vt.size() + " != 1");
		}

		System.out.print("\nTesting if root is external: ");
		if (!vt.isExternal(vt.root())) {
			throw new Error("!vt.isExternal(vt.root())");
		}
		System.out.println("o.k.");

		System.out.print("\nAsking for node which does not exist: ");
		Character rightChild = vt.rightChild('Y');
		if (rightChild != null) {
			throw new Error("rightChild != null");
		}
		System.out.println("o.k.");

		System.out.print("\nUsing node which does not exist: ");
		NoSuchNodeException noSuchNodeException = null;
		try {
			vt.setRightChild('A', 'B');
		} catch (NoSuchNodeException e) {
			noSuchNodeException = e;
		}
		if (noSuchNodeException == null) {
			throw new Error("NoSuchNodeException missing!");
		}
		System.out.println("o.k.");

	}

}

/*
 * Session-Log:
 * 
 * Setting root with 'A': [null, A]
 * 
 * Setting right child of 'A' with 'D': [null, A, null, D]
 * 
 * Setting left child of 'A' with 'B': [null, A, B, D]
 * 
 * Setting right child of 'B' with 'F': [null, A, B, D, null, F]
 * 
 * Setting right child of 'F' with 'H': [null, A, B, D, null, F, null, null,
 * null, null, null, H]
 * 
 * Setting left child of 'F' with 'G': [null, A, B, D, null, F, null, null,
 * null, null, G, H]
 * 
 * Removing right child of 'B': [null, A, B, D, null, null, null, null, null,
 * null, null, null]
 * 
 * Setting right child of 'D' with 'J': [null, A, B, D, null, null, null, J,
 * null, null, null, null]
 * 
 * Setting right child of root 'A' with 'X': [null, A, B, X, null, null, null,
 * null, null, null, null, null]
 * 
 * Setting root with 'Y': [null, Y, null, null, null, null, null, null, null,
 * null, null, null]
 * 
 * Testing if root is external: o.k.
 * 
 * Asking for node which does not exist: o.k.
 * 
 * Using node which does not exist: o.k.
 * 
 */
