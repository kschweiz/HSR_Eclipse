package Array;

public class Initial {

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.value);

	}

}

class Test{
	int value = 1;
	
	public Test() {
		System.out.println(value);
		this.value = 2;
	}
}
