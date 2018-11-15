
public class TestPotenz {

	public static void main(String[] args) {
		fib(3);
	}

	public static int fib(int n) {
		if(n<=1) return n;
		else {
			int x = fib(n-1)+fib(n-2);
			System.out.println(x);
			return x;
		}
		
	}
}





