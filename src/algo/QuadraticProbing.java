package algo;

public class QuadraticProbing {

	public static void main(String[] args) {
		int j;
		int m;

		//10, 13, 25, 17, 11

		j = 11;
		m = 7;

		for(int i = 0; i < 10; i++) {
			int ergebnis = (int) ((j + Math.pow(-1, i+1) * Math.pow((i+1)/2, 2)) % m);
			System.out.println(ergebnis);
		}
	}
}