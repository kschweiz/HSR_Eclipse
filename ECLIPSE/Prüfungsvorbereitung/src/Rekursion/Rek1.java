package Rekursion;

public class Rek1 {

	public static void main(String[] args) {
		rekursiveAufgabe(3023);
		System.out.println();
		System.out.println("--------------------------------");
		rek2(3023);
	}
	
	public static void rekursiveAufgabe(int n) {
		if(n<10) {
			System.out.print(n);
			return;
		}
		else {
			System.out.print(n%10);
			rekursiveAufgabe(n/10);
		}
	}
	
	public static void rek2(int n) {
		if(n<10) {
			System.out.print(n);
			return;
		}else {
			rek2(n/10);
			System.out.print(n%10);
		}
	}

}
