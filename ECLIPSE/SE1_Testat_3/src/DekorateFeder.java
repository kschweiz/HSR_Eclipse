
public class DekorateFeder extends Dekorationen {
	public DekorateFeder(Hut hut) {
		super(hut);
		if(hut instanceof Zylinder) {
			throw new IllegalArgumentException("Zylinder hat keine Feder!");
		}
	}
	
	@Override
	public double cost() {
		return getHut().cost() + 35.00;
	}

	@Override
	protected String description() {
		return getHut().description() + " Mit Feder.";
	}	
}
