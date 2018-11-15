package v3_ad1_2018;

public abstract class AbstractBikeStore {
	public abstract void addBike(Bike b);
	public abstract Bike removeBike(int i);
	public abstract void clear();
	public abstract int size();
	public abstract int getPrice();
}
