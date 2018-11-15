
public class DekorateGeschenkverpackung extends Dekorationen {
	
	public DekorateGeschenkverpackung(Hut hut) {
		super.hut = hut;
	}
	
	@Override
	protected double cost() {
		return hut.cost() + 9.90;
	}

}
