package algo;

public class SelectionSort {
	
	public static void main(String[] args) {
		int array[] = {3, 6, 1, 8, 0, 5, 9};
		
		selectionSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
	
	public static int[] selectionSort (int[] array) {
		int n = array.length;
		int first = 0;
		
		do {
			int min = first;
			for (int i = first; i < n; i++) {
				if (array[i] < array[min]) {
					min = i;
				}
			}
			int temp = array[first];
			array [first] = array[min];
			array [min] = temp;
			first++;
		} while (first < n);
		return array;
	}
}
