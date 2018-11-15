/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May  6 21:56:34 CEST 2018
 */

package uebung11.as.aufgabe01;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	private int[] a;
	private int n;

	public int[] sort(int[] a0) {
		a = a0;
		n = a.length;
		return insertionsort();
	}

	private int[] insertionsort() {
		int i, j, t, z;
		for (i = 1; i < n; i++) {
			j = a[i];
			for (int x = i; x > 0; --x) {
				int zwischenX = x;
				t = a[--zwischenX];
				if (j < t) {
					z = j;
					a[x] = t;
					a[zwischenX] = z;
					
				}else {
					break;
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		InsertionSort is;
		int[] a = { 1, 3, 2, 9, 8, 7 };

		System.out.println("Unsorted array:");
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + a[i]);
		}

		is = new InsertionSort();
		a = is.sort(a);
		System.out.println("\nSorted array:");
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + a[i]);
		}
		System.out.println();

		stressTest(is);
	}

	private static void stressTest(InsertionSort is) {
		System.out.print("\nStress-Test: ... ");
		final int NUMBER_OF_TESTS = 100000;
		final int LENGTH_RANGE = 5;
		final int DATA_RANGE = 10;
		Random random = new Random(1);
		for (int testNr = 0; testNr < NUMBER_OF_TESTS; testNr++) {
			int length = (int) (random.nextDouble() * LENGTH_RANGE + 1);
			int[] array = new int[length];
			for (int i = 0; i < length; i++) {
				int number = (int) (random.nextDouble() * DATA_RANGE + 1);
				array[i] = number;
			}
			int[] backup = Arrays.copyOf(array, array.length);
			array = is.sort(array);
			Arrays.sort(backup);
			if (!Arrays.equals(array, backup)) {
				System.out.println("\nERROR: Array wrong sorted!");
				for (int i = 0; i < array.length; i++) {
					System.out.print("\t" + array[i]);
				}
				System.exit(1);
			}
		}
		System.out.println("o.k.");
	}

}

/*
 * Session-Log (SOLL):
 * 
 * $ java -Xint -Xms2m -Xmx2m uebung11.as.aufgabe01.InsertionSort
 * 
 * Unsorted array: 1 3 2 9 8 7 Sorted array: 1 2 3 7 8 9
 * 
 * Stress-Test: ... o.k.
 * 
 */
