/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun Mar 19 19:28:58 CET 2017
 */

package v5_ad1_2018;

import java.util.Scanner;

public class BinarySearch {

	public static int search(String[] array, String token, int start, int end) {
		if(start>=end) {
			return 0;
		}
		int middle = (start + end) / 2;
		int res = token.compareTo(array[middle]);
		
		if (res == 0) {
			return middle + 1;
		}
		if (res < 0) {
			return search(array, token, start, middle);
		} else {
			return search(array, token, middle + 1, end);
		}
	}

	public static void main(String[] args) {
		String[] array = new String[] { "Alge", "Ding", "Lang", "Politik", "Spiel", "Text", "Welt", "Zimmer" };

		System.out.println("Lang: " + search(array, "Lang", 0, array.length));
		System.out.println("Welt: " + search(array, "Welt", 0, array.length));
		System.out.println("Politik: " + search(array, "Politik", 0, array.length));

		System.out.print("Suchstring : ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		scanner.close();
		System.out.println(search(array, string, 0, array.length));
		try {
			for (int i = 0; i < array.length; ++i) {
				if (search(array, array[i], 0, array.length) != i + 1) {

					throw new AssertionError(
							"not working: " + search(array, array[i], 0, array.length) + "<>" + (i + 1));
				}
			}
		} catch (Exception ex) {
			throw new AssertionError();
		}
	}
}

/*
 * Session-Log:
 * 
 * Lang: 3 Welt: 7 Politik: 4 Suchstring : Ding 2
 * 
 */
