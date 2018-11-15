package v3_ad1_2018;

import java.util.ArrayList;

public class ObjAdapter extends AbstractBikeStore{
	
	ArrayList<Bike> list = new ArrayList<>();
	
	@Override
	public Bike removeBike(int i) {
		Bike temp = list.get(i);
		list.remove(i);
		return temp;
	}

	@Override
	public void clear() {
		list.clear();
		System.out.println("ObjAdapter");
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void addBike(Bike b) {
		list.add(b);
		
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
