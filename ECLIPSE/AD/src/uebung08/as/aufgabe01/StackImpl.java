/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Mon Apr  9 16:30:09 CEST 2018
 */

package uebung08.as.aufgabe01;

public class StackImpl<T> implements Stack<T> {

	/**
	 * Nodes of a simple linked list.
	 */
	private class Node<E> {

		private E element;
		private Node<E> next;

		/**
		 * Constructs a new unlinked node.
		 * 
		 * @param elem
		 *            Element for the node.
		 */
		public Node(E elem) {
			element = elem;
			next = null;
		}

		/**
		 * Adds the node next to this node.
		 * 
		 * @param next
		 *            The next node.
		 */
		public void appendNode(Node<E> next) {
			this.next = next;
		}

		public Node<E> getNext() {
			return next;
		}

		public E getElement() {
			return element;
		}
	}

	private Node<T> top;

	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T top() throws EmptyStackException {
		if (size == 0) {
			throw new EmptyStackException("Fehler");
		}
		return top.getElement();
	}

	@Override
	public void push(T element) {
		Node<T> newNode = new Node<T>(element);
		newNode.appendNode(top);
		top = newNode;
		size++;
	}

	@Override
	public T pop() throws EmptyStackException {
		if(size == 0) {
			throw new EmptyStackException("Fehler POP");
		}
		Node<T> topNode = top;
		top = topNode.getNext();
		size--;
		return topNode.getElement();
	}

	@Override
	public void print() {
		System.out.println("Stack: " + toString(top));
	}
	
	public String toString(Node<T> node) {
		if(node == null) {
			return "";
		}
		String result = toString(node.getNext());
		if(!result.equals("")) {
			result += ", ";
		}
		result += node.getElement();
		return result;
	}

	public static void main(String[] args) {
		StackImpl<Integer> stack = new StackImpl<Integer>();
		stack.print();
		final int TEST_SIZE = 4;
		for (int i = 0; i < TEST_SIZE; i++) {
			stack.push(i);
			stack.print();
			if (stack.size() != i + 1) {
				System.out.println("ERROR: Stack.size() != " + (i + 1));
				return;
			}
			if (stack.top() != i) {
				System.out.println("ERROR: Stack.top() != " + i);
				return;
			}
		}
		for (int i = TEST_SIZE - 1; i > 0; i--) {
			if (stack.pop() != i) {
				System.out.println("ERROR: Stack.pop() != " + i);
				return;
			}
			stack.print();
			if (stack.size() != i) {
				System.out.println("ERROR: Stack.size() != " + i);
				return;
			}
			if (stack.top() != i - 1) {
				System.out.println("ERROR: Stack.top() != " + (i - 1));
				return;
			}
		}
		if (stack.pop() != 0) {
			System.out.println("ERROR: Stack.pop() != 0");
			return;
		}
		stack.print();
		if (!stack.isEmpty()) {
			System.out.println("ERROR: Stack.empty() != true");
			return;
		}
		if (stack.size() != 0) {
			System.out.println("ERROR: Stack.size() != 0");
			return;
		}
		try {
			stack.top();
			System.out.println("ERROR: no EmptyStackException for stack.top()!");
			return;
		} catch (EmptyStackException e) {
		}
		try {
			stack.pop();
			System.out.println("ERROR: no EmptyStackException for stack.pop()!");
			return;
		} catch (EmptyStackException e) {
		}
	}

}

/*
 * Session-Log:
 * 
 * Stack: () Stack: (0) Stack: (0, 1) Stack: (0, 1, 2) Stack: (0, 1, 2, 3)
 * Stack: (0, 1, 2) Stack: (0, 1) Stack: (0) Stack: ()
 * 
 */
