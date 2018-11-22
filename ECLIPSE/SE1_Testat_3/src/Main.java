
public class Main implements IColor{

	public static void main(String[] args) {
		Hut hut = new Fedora(Color.BLUE, 55);
		hut = new DekorateFeder(hut);
		hut = new DekorateGeschenkverpackung(hut);
		System.out.println(hut.getPrice());
		System.out.println(hut.getDescription());

	}
}
