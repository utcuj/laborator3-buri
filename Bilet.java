public class Bilet{
		private int numere[] = new int [6];
		
		public int [] getNumere() {
			return numere;
		}
		
		public Bilet(int numere[]) {
			if ( numere.length == 6 )
				this.numere = numere;
			else
				System.out.println("Sirul are mai mult de 6 elemente");
		}
}