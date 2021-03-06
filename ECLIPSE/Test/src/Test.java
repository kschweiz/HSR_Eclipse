import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		int[] X = new int[] {6,3,4,5,2};
		int[] TEST = spans2(X, X.length);
		for (int i : TEST) {
			System.out.println(i);
		}

	}
	
	public static int[] spans2(int[] X, int n) {
		int[] S = new int[n];
		Stack<Integer> A = new Stack<>();
		
		for(int i = 0; i<n-1;i++) {
			while(!A.isEmpty()&&X[A.peek()]<=X[i]) {
				A.pop();
			}
			if(A.isEmpty()) {
				S[i] = i+1;
			}else {
				S[i] = i-A.peek();
			}
			A.push(i);
		}
		return S;
	}

}
