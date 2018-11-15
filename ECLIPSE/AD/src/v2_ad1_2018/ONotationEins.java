package v2_ad1_2018;

public class ONotationEins {
	static int sum = 2;
	public static void main(String[] args) {
		final long timeStart = System.currentTimeMillis();
		for (int i = 0; i< 10000000;i++) {
			for(int j = i; j<=10000000;j++) {
				sum+=3;
			}
		}
		final long timeEnd = System.currentTimeMillis(); 
        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Millisek."); 

	}
	

}
