package Array;

import java.util.Arrays;

public class ArrayAufsteigend {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4};
		System.out.println(Arrays.toString(sort(array)));
		int[] array2 = new int[5];
		System.out.println(array2.length);
	}
	
	public static int[] sort(int[] array) {
		for(int i = 1; i<array.length; i++) {
			int temp = array[i];
			int k = i;
			while(k!=0&&array[k-1]>temp) {
				array[k] = array[k-1];
				k--;
			}
			array[k] = temp;
		}
		return array;
	}

}
