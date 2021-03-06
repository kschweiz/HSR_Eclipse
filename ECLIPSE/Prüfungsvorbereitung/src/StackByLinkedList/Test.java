package StackByLinkedList;

public class Test {

	//DatenStack
	static LinkedStack datenStack = new LinkedStack();
			
	//HilfsStack
	static LinkedStack hilfsStack = new LinkedStack();
	
	public static void main(String[] args) {
		doPush(3);
		print();
		doPush(4);
		print();
		doPush(2);
		print();
		doPush(1);
		print();
		
		doPop();
		print();
		doPop();
		print();
		
		doPush(0);
		print();
		
	}
	
	
	public static void doPush(int nr) {
		datenStack.push(nr);

		if(hilfsStack.isEmpty()) {
			hilfsStack.push(nr);
		}
		else if(hilfsStack.peek()>=nr) {
			hilfsStack.push(nr);
		}else {
			hilfsStack.push(hilfsStack.peek());
		}
	}
	
	public static void doPop() {
		datenStack.pop();
		hilfsStack.pop();
	}
	
	
	public static void print() {
		System.out.println("DATENSTACK:");
		for (int i : datenStack.list) {
			System.out.println(i + ", ");
		}
		System.out.println("HILFSSTACK:");
		for (int i : hilfsStack.list) {
			System.out.println(i + ", ");
		}
		System.out.println("------------------");
	}

}
