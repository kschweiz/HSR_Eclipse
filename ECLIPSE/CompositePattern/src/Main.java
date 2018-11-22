
public class Main {

	public static void main(String[] args) {
		Component group = new Composite("all");
		
		Component part1 = new Composite("part1");
		Component part2 = new Composite("part2");
		
		group.add(part1);
		group.add(part2);
		
		Component sub1 = new Leaf("sub1");
		Component sub2 = new Leaf("sub2");
		
		part1.add(sub1);
		part2.add(sub2);
		
		group.print();
	}

}
