package BinaryTree;

public class BinaryTree<T> {
	Node<T> root;
	
	public void printTree(Node<T> node) {
		if(node != null) {
			System.out.println(node.getValue());
			
			printTree(node.getLeft());
			printTree(node.getRight());
		}
	}
}

class Node<T>{
	private T value;
	private Node left;
	private Node right;
	
	public Node(T value) {
		this.value = value;
		right = null;
		left = null;
	}
	
	public void setLeft(Node<T> leftNode) {
		this.left = leftNode;
	}
	
	public void setRight(Node<T> rightNode) {
		this.right = rightNode;
	}
	
	public Node<T> getLeft(){
		return left;
	}
	public Node<T> getRight(){
		return right;
	}
	public T getValue() {
		return value;
	}
}


class Test{
	public static void main(String[] args) {
		Node<Integer> myNode1 = new Node(10);
		Node<Integer> myNode2 = new Node(12);
		Node<Integer> myNode3 = new Node(14);
		
		BinaryTree<Integer> myTree = new BinaryTree<Integer>();
		
		myTree.root = myNode1;
		myNode1.setLeft(myNode2);
		myNode1.setRight(myNode3);
		
		myTree.printTree(myNode1);
	}
}