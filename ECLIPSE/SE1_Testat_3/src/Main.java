
public class Main implements IColor{

	public static void main(String[] args) {
		Hut hut = new Zylinder(45);
		hut = new DekorateGeschenkverpackung(hut);
		System.out.println(hut.getPrice());
		System.out.println(hut.getDescription());

	}
}
