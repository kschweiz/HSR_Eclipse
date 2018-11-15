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
		if(color != Color.BLACK) {
			throw new IllegalArgumentException("Zylinder muss BLACK sein!");
		}else {
			super.setColor(color);
		}
	}
}
