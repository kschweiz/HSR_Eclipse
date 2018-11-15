package test;

public class Foo {
	int attr;
	public Foo(int i) {
		attr = i;
	}
	int getAttr() {
		return attr;
	}
}

class FooTest{
	public static void main(String[] args) {
		Foo foo = new Foo(1);
		meth(foo);
		System.out.println(foo.getAttr());
	}
	
	static void meth(Foo fooPar) {
		fooPar = new Foo(2);
	}
}
