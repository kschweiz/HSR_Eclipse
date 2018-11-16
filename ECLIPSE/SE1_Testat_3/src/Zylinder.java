public class Zylinder extends Hut {
	public Zylinder(int size) {
		setColor(Color.BLACK);
		setSize(size);
	}
	
	@Override
	public double cost() {
		return 400.00;
	}

	@Override
	public void setColor(Color color) {
		super.setColor(color);
	}
}
