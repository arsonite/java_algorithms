package algo;

public class first {

    public static void main (String[] args) {
//        int intArray[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int intArray[] = {1, 2, 3, 4, 5, 6,7, 8, 9, 10};
//        int intArray[] = {10, 5, 3, 1, 9, 2, 6, 7, 4, 8};
        
        sort(intArray);
    }
    
    public static void sort (int [] A) {
        int n = A.length;
        boolean b = true;
        
        for (int i = 0; i < n-1 && b; i++) {
            System.out.println("Erste Schleife: " + i);
            b = false;
            for (int j = 1; j < n-i; j++) {
                System.out.println("Zweite Schleife: " + j);
                if (A[j] < A[j-1]) {
                    System.out.print("-- if --");
                    b = true;
                    int tmp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = tmp;
                }
            }
        }
        System.out.print("\n" + "\n" + "sortiertes Array: ");
        for (int i2 = 0; i2 < n; i2++) {
        	System.out.print(A[i2] + " ");
        }
    }
}