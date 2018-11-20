
public class DekorateGeschenkverpackung extends Dekorationen {
	
	public DekorateGeschenkverpackung(Hut hut) {
		super(hut);
		if(hut instanceof DekorateGeschenkverpackung) {
			throw new IllegalArgumentException("Nur eine Geschenkverpackung erlaubt!");
		}
	}
	
	@Override
	protected double cost() {
		return getHut().cost() + 9.90;
	}

	@Override
	protected String description() {
		return getHut().description() + " Mit Geschenkverpackung.";
	}

}
