/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun Apr  1 17:53:22 CEST 2018
 */

package v8_ad1_2018;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

/**
 * Node-class of a simple linked list.
 * 
 * @author tbeeler
 */
class Node<E> {

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

/**
 * task 1 from exercise 7 1a) see numNodes() 1b) see concatenate() 1c) see
 * reverse*()
 * 
 * @author tbeeler
 */
public class LinkedList {

	/**
	 * Solution task 1a. Recursive calculation of the numbers of nodes in the list
	 * "head". Runtime O(n).
	 * 
	 * @param head
	 *            Head of the list.
	 * @return Number of nodes in the list.
	 */
	public static <E> int numNodes(Node<E> head) {

		int x = 1;
		if (head != null) {
			return x + numNodes(head.getNext());
		} else {
			return 0;
		}
	}

	/**
	 * Solution task 1b. Concatenate two lists l1 and l2 to a new list. l1 and l2
	 * were not changed. If a change is allowed, the runtime could be improved to
	 * O(|l1|). Runtime O(|l2|+|l1|) = O(n), whereas n is the number of elements in
	 * the new list.
	 * 
	 * @param l1
	 *            List 1.
	 * @param l2
	 *            List 2.
	 * @return Concatenated list l1 and l2.
	 */

	public static <E> Node<E> concatenate(Node<E> l1, Node<E> l2) {

		final Node<E> l = new Node<E>(l1.getElement());
		Node<E> temp = l;
		l1 = l1.getNext();
		while (l1 != null) {
			temp.appendNode(new Node<E>(l1.getElement()));
			temp = temp.getNext();
			l1 = l1.getNext();

		}

		while (l2 != null) {
			temp.appendNode(new Node<E>(l2.getElement()));
			temp = temp.getNext();
			l2 = l2.getNext();
		}
		return l;
	}

	/**
	 * Solution task 1c. Invert the order of list 'head' by iteration. No new list
	 * is built. The old head afterwards is the last node in the list. Runtime O(n).
	 * 
	 * @param head
	 *            Head of the list.
	 * @return New head.
	 */
	public static <E> Node<E> reverseByIteration(Node<E> head) {
		Node<E> n1 = head;
		if(n1 == null) {
			return null;
		}
		Node<E> n2 = n1.getNext();
		if(n2 == null) {
			return n1;
		}
		
		n1.appendNode(null);
		while(n2.getNext() != null) {
			Node<E> n3 = n2.getNext();
			n2.appendNode(n1);
			n1 = n2;
			n2 = n3;
		}
		n2.appendNode(n1);
		return n2;
	}

	/**
	 * Solution task 1c. Invert the order of list 'head' by recursion. No new list
	 * is built. The old head afterwards is the last node in the list. Uses
	 * reverseByRecursionInternal(). Runtime O(n).
	 * 
	 * @param head
	 *            Head of the list.
	 * @return New head.
	 */
	public static <E> Node<E> reverseByRecursion(Node<E> head) {

		// TODO Implement here...

		return null;
	}

	/**
	 * Internal recursive method which handles one node.
	 * 
	 * @param node
	 *            The actual node.
	 * @return New head.
	 */
	private static <E> Node<E> reverseByRecursionInternal(Node<E> node) {

		// TODO Implement here...

		return null;
	}

	/**
	 * Solution task 1c with only one Method. Invert the order of list 'head' by
	 * recursion. No new list is built. The old head afterwards is the last node in
	 * the list. Runtime O(n).
	 * 
	 * @param head
	 *            Head of the list.
	 * @return New head.
	 */
	public static <E> Node<E> reverseByRecursion2(Node<E> head) {

		// TODO Implement here...

		return null;
	}

	/**
	 * Print the elements of the list.
	 * 
	 * @param head
	 *            Head of the list.
	 */
	public static <E> void printList(Node<E> head) {
		while (head != null) {
			System.out.print(head.getElement().toString());
			System.out.print(" ");
			head = head.getNext();
		}
		System.out.println();
	}

	private static void verifyList(Node<Integer> head, Integer[] intArr) {
		if (numNodes(head) != intArr.length) {
			System.err.println("Node count does not match: " + numNodes(head) + " != " + intArr.length);
			System.exit(1);
		}
		for (int i = 0; i < intArr.length; i++, head = head.getNext()) {
			if (head.getElement() != intArr[i]) {
				System.err.println(
						"Node content does not match for index[" + i + "]: " + head.getElement() + " != " + intArr[i]);
				System.exit(1);
			}
		}
	}

	private static void verifyList(Node<Integer> head, Integer[] intArr1, Integer[] intArr2) {
		verifyList(head, intArr1, intArr2, false);
	}

	private static void verifyList(Node<Integer> head3, Integer[] intArr1, Integer[] intArr2, Node<Integer> head1,
			Node<Integer> head2) {
		verifyList(head3, intArr1, intArr2, false);
		Set<Node<Integer>> set = new HashSet<>();
		while (head3 != null) {
			set.add(head3);
			head3 = head3.getNext();
		}
		while (head1 != null) {
			if (set.contains(head1)) {
				System.err.println("head3 contains Node of head1: " + head1.getElement());
				System.exit(1);
			}
			head1 = head1.getNext();
		}
		while (head2 != null) {
			if (set.contains(head2)) {
				System.err.println("head3 contains Node of head2: " + head2.getElement());
				System.exit(1);
			}
			head2 = head2.getNext();
		}
	}

	private static void verifyList(Node<Integer> head, Integer[] intArr1, Integer[] intArr2, boolean reverse) {
		Integer[] intArr = Stream.concat(Arrays.stream(intArr1), Arrays.stream(intArr2)).toArray(Integer[]::new);
		if (reverse) {
			List<Integer> intList = Arrays.stream(intArr).collect(Collectors.toList());
			Collections.reverse(intList);
			intArr = intList.stream().toArray(Integer[]::new);
		}
		verifyList(head, intArr);
	}

	public static void main(String[] args) {
		final Integer[] LIST_1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		final Integer[] LIST_2 = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
		// create a List l1 with 10 elements
		Node<Integer> head1 = new Node<>(0);
		Node<Integer> l1 = head1;
		for (int i = 1; i < LIST_1.length; i++) {
			l1.appendNode(new Node<>(LIST_1[i]));
			l1 = l1.getNext();
		}
		System.out.println("List 1:");
		printList(head1);
		verifyList(head1, LIST_1);
		System.out.println();
		// create a List l2 with 15 elements
		Node<Integer> head2 = new Node<>(10);
		Node<Integer> l2 = head2;
		for (int i = 1; i < LIST_2.length; i++) {
			l2.appendNode(new Node<>(LIST_2[i]));
			l2 = l2.getNext();
		}
		System.out.println("List 2:");
		printList(head2);
		verifyList(head2, LIST_2);
		System.out.println();
		Node<Integer> head3 = concatenate(head1, head2);
		System.out.println("List 3 = List 1 o List 2:");
		printList(head3);
		verifyList(head3, LIST_1, LIST_2, head1, head2);
		System.out.println();
		Node<Integer> head4 = reverseByIteration(head3);
		System.out.println("List 4 = inverted List 3 by iteration:");
		printList(head4);
		verifyList(head4, LIST_1, LIST_2, true);
		System.out.println();
		Node<Integer> head5 = reverseByRecursion(head4);
		System.out.println("List 5 = inverted List 4 by recursion:");
		printList(head5);
		verifyList(head5, LIST_1, LIST_2);
		System.out.println();
		Node<Integer> head6 = reverseByRecursion2(head5);
		System.out.println("List 6 = inverted List 5 by recursion (version 2):");
		printList(head6);
		verifyList(head6, LIST_1, LIST_2, true);
		System.out.println();
	}
}

/*
 * Session-Log:
 * 
 * List 1: 0 1 2 3 4 5 6 7 8 9
 * 
 * List 2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 * 
 * List 3 = List 1 o List 2: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
 * 20 21 22 23 24
 * 
 * List 4 = inverted List 3 by iteration: 24 23 22 21 20 19 18 17 16 15 14 13 12
 * 11 10 9 8 7 6 5 4 3 2 1 0
 * 
 * List 5 = inverted List 4 by recursion: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 * 16 17 18 19 20 21 22 23 24
 * 
 * List 6 = inverted List 5 by recursion (version 2): 24 23 22 21 20 19 18 17 16
 * 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0
 * 
 */
