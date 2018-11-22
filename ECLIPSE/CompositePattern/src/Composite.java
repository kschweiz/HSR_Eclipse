
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Composite extends Component{
	private List<Component> components = new ArrayList<>();
	private String name;
	
	public Composite(String name) {
		this.name = name;
	}
	
	public void add(Component c) {
		components.add(c);
	}
	
	public void remove(Component c) {
		components.remove(c);
	}
	
	public Component getChild(int i) {
		return (Component) components.get(i);
	}
	
	public String operation() {
		return name;
	}
	
	public void print() {
		Iterator<Component> it = components.iterator();
		while(it.hasNext()) {
			Component c = it.next();
			c.print();
		}
	}
	
	
}
