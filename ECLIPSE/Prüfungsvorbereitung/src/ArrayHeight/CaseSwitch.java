package ArrayHeight;

public class CaseSwitch {
	public static void main(String[] args) {
		int n = 20;
		switch(n) {
		case 20: n = n+ 3;
		case 25: n = n+ 4;
		case 30: n = n+ 5;
		}
		
		System.out.println(n);
	}
}



EntityManagerFactory factory *
	Persistence createEntityManagerFactory()