public class Fedora extends Hut{
	public Fedora(Color color, int size) {
		setColor(color);
		setSize(size);
	}
	
	@Override
	public double cost() {
		if(getColor()!=Color.BROWN) {
			return 350.00;
		}else {
			return 300.00;
		}
	}

	@Override
	protected String description() {
		return "Das ist eine Fedora. Farbe: " + getColor() + ". Size: " + getSize() + "." ;
	}
	
}
