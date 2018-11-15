package v3_ad1_2018;

import java.util.ArrayList;

public class ClassAdapter extends ArrayList<Bike> implements BikeStoreInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void addBike(Bike b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bike removeBike(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size(int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void clear() {
		System.out.println("ClassAdapter");
	}
	
}
