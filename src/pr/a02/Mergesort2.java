package pr.a02;

public class Mergesort2 {

	public int[] dataArray; //Vom Nutzer übergebendes Array
	private int[] helpArray; //Hilfs Array
	
	public Mergesort2() {
	}
	
	/*
	 * Funktion zum sortieren eines Arrays (Verfahren Mergesort)
	 * 
	 * Parameter:	- int[] array: das zu sortierende Array
	 * Return: 		- void
	 * Effekt:		- Das übergebene Array wird 'dataArray' zugewiesen.
	 *				- Ein leeres Array mit der Größe von 'array' - 1 
	 *				  wird erzeugt und 'helpArray' zugewiesen.
	 *				- Die Methode zum Zerlegen des Arrays (mergesort) wird aufgerufen.
	 */
	public void sort(int[] array) {
		dataArray = array;
		helpArray = new int[(array.length+1) / 2];
		mergesort(0, array.length-1);
	}
	
	/*
	 * Rekursive Funktion zum Zerlegen des Arrays 'array'
	 * in 2 Teile 'l' bis 'm' (Teilfeld A1) & 'm+1' bis 'r' (Teilfeld A2)
	 * 
	 * Parameter:	- int l: iOfA1 der linke Hälfe (anfang) - anfang Teilfeld A1
	 * 				- int r: iOfA1 der rechten Hälfte (ende) - ende Teilfeld A2
	 * Return:		- void
	 * Vorbedingung:- Wird von sort aufgerufen
	 * Effekt:		- Ermittelt die Mitte von 'l' und 'r' - ende vom Teilfeld A1
	 * 				- Zerlegt eine Hälfte(l bis m) rekursiv bis eine Teilgröße von 1 erreicht wird (l < r)
	 * 				- Wiederholt diesen Vorgang mit der anderen Hälfte (m+1 bis r)
	 * 				- Übergibt der Methode merge die ermittelten Werte ('l', 'm', 'r')
	 */
	private void mergesort(int l, int r) {		
		if (l < r) {
			int m = l + (r - l) / 2;
			mergesort(l, m);
			mergesort(m+1, r);
			merge(l, m, r);
		}
	}

	/*
	 * Funktion zum vergleichen und sortieren der Teilfelder A1 & A2 ins 'dataArray'
	 * mit Hilfe von 'helpArray'
	 * 
	 * Verweis:		- http://www.iti.fh-flensburg.de/lang/algorithmen/sortieren/merge/merge.htm
	 * 
	 * Parameter:	- int l: Anfang des Teilfeldes A1
	 * 				- int m: Ende des Teilfeldes A1
	 * 				- int r: Ende des Teilfeldes A2
	 * Vorbedingung:- Teilfeld A1 & A2 sind sortiert.
	 * 				- Wird von mergesort aufgerufen.
	 * Return:		- void
	 * Effekt:		- Kopiert Teilfeld A1 nach 'helpArray'
	 * 				- Vergleicht Teilfeld A1 (helpArray) mit Teilfeld A2 (dataArray)
	 * 				- Schreibt jeweils kleinern Wert ins dataArray -> aufsteigend sortiert
	 */
	private void merge(int l, int m, int r) {

	   int iOfA1=0;
	   int iOfA2=l;
	   int index=l; // dient als index für dataArray
	    
	   // Teilfeld A1(l bis m) in helpArray kopieren
	   while (iOfA2<=m) {
	        helpArray[iOfA1]=dataArray[iOfA2];
	        iOfA1++;
	        iOfA2++;
	   }
	   // iOfA2 <- m+1
	   iOfA1=0;
	   
	   // Vergleiche Teilfeld A1 mit A2 solange:
	   // 	index<iOfA2 -> false -> A1 keine Werte mehr hat -> dataArray[l bis r] <- sortiert
	   // 	da A2 bereits sortiert im dataArry vorliegt.
	   // oder:
	   // 	iOfA2<=r -> false -> A2 hat keine Werte mehr hat
	   while (index<iOfA2 && iOfA2<=r) {
	       
		   // Schreibe kleinern Wert in dataArray[index]
		   if (helpArray[iOfA1]<=dataArray[iOfA2]) {
			   dataArray[index]=helpArray[iOfA1];
			   iOfA1++;
	            
		   } else {
			   dataArray[index]=dataArray[iOfA2];
			   iOfA2++;
		   }
		   
		   index++;
	   }

	   
	   // Schreibe verbleibende Werte von A1 ins dataArray
	   while (index<iOfA2) {
		   dataArray[index]=helpArray[iOfA1];
		   index++;
		   iOfA1++;
	   }
	   // index <- r 
	}
}
