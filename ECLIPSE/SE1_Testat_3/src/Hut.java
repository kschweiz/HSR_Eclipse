
public abstract class Hut implements IColor{	
	private Color color;
	private int size;
	
	public double getPrice() {
		return cost();
	}
	
	public String getDescription() {
		return description();
	}
	
	protected abstract double cost();
	protected abstract String description();

	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		if(size<45 || size >65) {
			throw new IllegalArgumentException("Hut Grösse muss zwischen 45cm und 65cm sein!");
		}
		this.size = size;
	}
	

}
