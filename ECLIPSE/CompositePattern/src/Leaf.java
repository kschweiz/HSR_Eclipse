
public class Leaf extends Component{
	String name;
	
	public Leaf(String name) {
		this.name = name;
	}
	
	@Override 
	public String operation() {
		return name;
	}
	
	@Override 
	public void print() {
		System.out.println(name);
	}
}
