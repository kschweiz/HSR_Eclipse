package Array;

import java.util.Arrays;

public class Reverse {
	static String s = "Test string to exercise....";
	  static char[] characs = { 'a', 'o', 'i', 'e', 'u' };

	public static void main(String[] args) throws Exception {
		int[] list = new int[] {1,2,3,4,5,6};
		System.out.println(Arrays.toString(reverseArray(list)));
		
		s = s.toLowerCase();

	    for (int i = 0; i < characs.length; i++) {
	      System.out.println("Output: " + characs[i] + " = "
	          + doIt(characs[i], s.length()));
	    }
	}

	public static int[] reverseArray(int[] list) throws Exception {
		if (list == null) {
			throw new Exception("Array is null");
		}
		if (list.length == 1 || list.length == 0) {
			return list;
		}
		int[] array = new int[list.length];
		
		for(int i = 0; i< array.length; i++) {
			int j = list.length-i;
			array[list.length-i-1] = list[i];
			list[i] = j;
		}
		return array;
	}
	
	 public static int doIt(char v, int len) {
		    if (len > 1) {
		      if (s.charAt(len - 1) == v)
		        return doIt(v, len - 1) + 1;
		      else
		        return doIt(v, len - 1);
		    } else {
		      if (s.charAt(len - 1) == v)
		        return 1;
		      else
		        return 0;
		    }
		  }
}
