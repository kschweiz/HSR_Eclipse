import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BucketSort {
	public static void sort(Map<String, Integer> a, int maxVal) {
		ArrayList<String>[] output = new ArrayList[maxVal + 1];
		
		for(int i = 0; i<output.length; i++) {
			output[i] = new ArrayList<>();
		}

		for (Map.Entry<String, Integer> entry : a.entrySet()) {
//			System.out.println("Key: "+ entry.getKey() + " " + "Value: " + entry.getValue() );
			output[entry.getValue()].add(entry.getKey());
		}
		
		for(int i = 0; i<output.length; i++) {
			for(String s : output[i]){
				 System.out.println("Key: " + a.get(s) + " " + s);
			}
		}
	}

	public static void main(String[] args) {
	      int maxVal=7;
	      Map<String, Integer> data = new HashMap<>();
	      data.put("d", 7);
	      data.put("c", 1);
	      data.put("a", 3);
	      data.put("g", 7);
	      data.put("b", 3);
	      data.put("e", 7);
	      
	      
	      sort(data, maxVal);
	   }

}
