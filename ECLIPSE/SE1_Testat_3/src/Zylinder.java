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
	protected String description() {
		return "Das ist ein Zylinder. Farbe: " + getColor() + ". Size: " + getSize() + "." ;
	}

}
