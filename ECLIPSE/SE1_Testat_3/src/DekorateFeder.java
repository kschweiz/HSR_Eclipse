
public class DekorateFeder extends Dekorationen {
	public DekorateFeder(Hut hut) {
		super.hut = hut;
	}
	
	@Override
	public double cost() {
		return hut.cost() + 35.00;
	}	
}
