public class ModischerSchlapphut extends Hut{
	public ModischerSchlapphut(Color color, int size) {
		setColor(color);
		setSize(size);
	}
	
	@Override
	public double cost() {
		return 200.00;
	}

	@Override
	protected String description() {
		return "Das ist ein Modische Schlapphut. Farbe: " + getColor() + ". Size: " + getSize() + "." ;
	}
}
