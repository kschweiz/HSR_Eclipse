import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[] {4,7,6,8,3,5,1};
		
		System.out.println(Arrays.toString(array));
		
		System.out.println(Arrays.toString(mergeSort(array)));
	}
	
	private static int[] mergeSort(int[] list) {
		if (list.length > 1) {
			int mitte = (int)(list.length / 2);

			int[] links = new int[mitte];
			for (int i = 0; i <= mitte - 1; i++) {
				links[i] = list[i];
			}

			int[] rechts = new int[list.length - mitte];
			for (int i = mitte; i <= list.length - 1; i++) {
				rechts[i - mitte] = list[i];
			}

			links = mergeSort(links);
			rechts = mergeSort(rechts);

			return merge(links, rechts);
		}
		else
		{
			return list;
		}

	}
	
	
	private static int[] merge(int[] links, int[] rechts) {
		int[] neueArray = new int[links.length + rechts.length];
		int indexLinks = 0;
		int indexRechts = 0;
		int indexErgebnis = 0;

		while (indexLinks < links.length && indexRechts < rechts.length) {
			if (links[indexLinks] < rechts[indexRechts]) {
				neueArray[indexErgebnis] = links[indexLinks];
				indexLinks++;
			} else {
				neueArray[indexErgebnis] = rechts[indexRechts];
				indexRechts++;
			}
			indexErgebnis++;
		}

		while (indexLinks < links.length) {
			neueArray[indexErgebnis] = links[indexLinks];
			indexLinks++;
			indexErgebnis++;
		}

		while (indexRechts < rechts.length) {
			neueArray[indexErgebnis] = rechts[indexRechts];
			indexRechts++;
			indexErgebnis++;
		}

		return neueArray;
	}
	
}
