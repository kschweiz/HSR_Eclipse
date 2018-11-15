/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Mon Feb 27 10:19:19 CET 2017
 */

package v2_ad1_2018;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Automat {
	
	//static int[] money = new int[] {200,100,50,20,10,5,2,1};
	
	static Map<Integer,Integer> money = new TreeMap<>(Collections.reverseOrder());

	public static void main(String[] args) {
		loadHashMap();
		
		
		System.out.print("Amount-in-CHF = ");
		Scanner scanner = new Scanner(System.in);
		greedy(scanner.nextInt());
		scanner.close();
		
		for (Integer x : money.keySet()) {
			System.out.println(money.get(x));
		}
	}

	public static void greedy(int betrag) {
		for (Integer x : money.keySet()) {
			if(betrag==0) {
				break;
			}else if(betrag>=x) {
				int rest = betrag%x;
				money.put(x, (betrag-rest)/x);
				betrag= rest;
			}
		}
	}
	
	public static void loadHashMap() {
		money.put(200, 0);
		money.put(100, 0);
		money.put(50, 0);
		money.put(20, 0);
		money.put(10, 0);
		money.put(5, 0);
		money.put(2, 0);
		money.put(1, 0);
		
	}

}

/*
 * Session-Log:
 * 
 * Amount-in-CHF = 28 20 CHF bill 5 CHF coin 2 CHF coin 1 CHF coin
 * 
 */
