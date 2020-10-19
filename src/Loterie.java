import java.util.Random;
import java.util.Scanner;
public class Loterie {
	
	private int numereCastigatoare[] = new int [6];
	private int [] extragere() {
		Random r = new Random();
		
		for ( int i = 0; i < 6; i++) {
			int aux = r.nextInt(50);
			for ( int j = 0; j < numereCastigatoare.length; j++) {
				if ( aux == numereCastigatoare[j] ) {
					aux = r.nextInt(50);
					j = 0;
				}
			}
			numereCastigatoare[i] = aux;
		}
		
		return numereCastigatoare;
	}
	
	public static void main (String args[]) {
		
		Loterie infinity = new Loterie();
		int numereCastigatoare[] = infinity.extragere();
		
		System.out.println("Enter 6 numbers: ");
		
		int[] numereAlese = new int [6];
		Scanner scan = new Scanner(System.in);
		boolean warn = false;
		for ( int i = 0; i < numereAlese.length; i++) {
			numereAlese[i] = scan.nextInt();
			if ( numereAlese[i] > 49 || numereAlese[i] < 1)
				warn = true;
			for ( int j = 0; j < i; j++)
				if ( numereAlese[i] == numereAlese[j] )
					warn = true;
		}
		scan.close();
		
		if ( warn == true )
			System.out.println("Numerele introduse sunt invalide!");
		
		int count = 0;
		
		Bilet biletulMeu = new Bilet(numereAlese);
		
		int numereExtrase[] = biletulMeu.getNumere();
		for ( int i = 0; i < 6; i++) {	
			for ( int j = 0; j < 6; j++) {
				if ( numereExtrase[j] == numereCastigatoare[i] )
					count++;
			}
		}
		if ( count == 6 )
			System.out.println("Ai castigat!");
		else {
			System.out.print("Nu ai castigat!");
			System.out.println("");
			System.out.print("Ai ghicit " + count);
			if ( count == 1 )
				System.out.print(" numar");
			else
				System.out.print(" numere");
			System.out.println("");
		}
			
		
		System.out.println("Biletul castigator a fost: ");
		for ( int i = 0; i < 6; i++ ) {
			System.out.print(numereCastigatoare[i] + " ");
		}
		
	}
}
