public class Fedora extends Hut implements IColor{
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
	public void setColor(Color color) {
		super.setColor(color);
	}
}
