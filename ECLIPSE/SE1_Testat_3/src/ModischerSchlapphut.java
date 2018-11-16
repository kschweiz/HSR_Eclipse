public class ModischerSchlapphut extends Hut{
	public ModischerSchlapphut(Color color, int size) {
		setColor(color);
		setSize(size);
	}
	
	@Override
	public double cost() {
		return 200.00;
	}
}
