/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun Mar 25 21:09:47 CEST 2018
 */

package v6_ad1_2018;

public class SumOddNumbers {

	/**
	 * Calculates the sum of all odd numbers from 1 to 'n' with iteration.
	 * 
	 * Precondition: 'n' is an odd number. (Precondition: see also
	 * http://en.wikipedia.org/wiki/Precondition)
	 * 
	 * @param n
	 *            The upper limit of the summation.
	 * @return The sum of all odd numbers from 1 to 'n'.
	 */
	public int perLoop(int n) {
		int sum = 0;
		for(int i = 1; i<=n; i++) {
			if(i%2!=0) {
				sum+=i;
			}
		}
		return sum;
	}

	/**
	 * Calculates the sum of all odd numbers from 1 to 'n' with recursion.
	 * 
	 * Precondition: 'n' is an odd number. (Precondition: see also
	 * http://en.wikipedia.org/wiki/Precondition)
	 * 
	 * @param n
	 *            The upper limit of the summation.
	 * @return The sum of all odd numbers from 1 to 'n'.
	 */
	public int perRecursion(int n) {
		if(n==1) {
			return 1;
		}else {
			return n+perRecursion(n-2);
		}
	}

	public static void main(String[] args) {
		int n;
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		} else {
			n = 100;
		}

		// ensure (next) odd number (is a precondition of perLoop() and perRecursion())
		n = n + (n % 2 - 1);

		SumOddNumbers sum = new SumOddNumbers();
		System.out.println("Iteration: " + sum.perLoop(n));
		System.out.println("Recursion: " + sum.perRecursion(n));
	}

}

/*
 * Session-Log:
 * 
 * Iteration: 2500 Recursion: 2500
 * 
 */
