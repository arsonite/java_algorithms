package pr.a02;

public class MergeSort {

	public int[] dataArray; //Finales sortiertes Array
	public int[] helpArray; //Temporäres Array fürs Sortieren
	
	//Leerer Standard-Konstruktor
	public MergeSort() {
	}
	
	//Kopier-Konstruktor
	public void sort (int[] array) {
		this.dataArray = array;
		this.helpArray = new int[array.length - 1];
		mergeSort(0, array.length - 1);
	}
	
	//Rekursive Methode
	public void mergeSort (int l, int r) {		
		if (l < r) {
			int m = (l + r) / 2; //Ermittlung des mittleren Index des Arrays (l + r = array.length)
			mergeSort(l, m);
			mergeSort(m + 1, r);
			merge(l, m, r);
		}
	}

	//Merge-Methode nach Divide-and-Conquer-Prinzip
	private void merge (int l, int m, int r) {
	    int index = 0;
	    int otherL = l;
	    
	    //Vordere Hälfte (l < m) von dataArray in helpArray kopieren
	    while (l <= m) {
	        helpArray[index] = dataArray[l];
	        index++;
	        l++;
	    }
	   
	    index = 0; //Zurücksetzung des index
	    
	    //Jeweils das nächstgrößte Element zurückkopieren
	    while (otherL < l && l <= r) {
	    	if (helpArray[index] <= dataArray[l]) {
	            dataArray[otherL] = helpArray[index];
	            index++;
	        } else {
	            dataArray[otherL] = dataArray[l];
	            l++;
	        }
	    	otherL++; //Erhöhe Index
	    }

	    // Rest, falls vorhanden zurückkopieren
	    while (otherL < l) {
	        dataArray[otherL] = helpArray[index];
	        otherL++;
	        index++;
	    }
	}
}