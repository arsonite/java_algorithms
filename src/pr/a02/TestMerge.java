package pr.a02;

import java.io.*;

public class TestMerge {
	
	public static void main (String[] args) {
    	PrintWriter out = new PrintWriter (System.out, true);
    	MergeSort ms = new MergeSort();
    	
    	String[] fileArray = {
    			"./files/FileIntArrayMitBeispielen/Rand100000_1",
    			"./files/FileIntArrayMitBeispielen/Rand100000_2",
    			"./files/FileIntArrayMitBeispielen/Rand100000_1",
    			"./files/FileIntArrayMitBeispielen/Rand100000_2", 
    			"./files/FileIntArrayMitBeispielen/Rand100000_1",
    			"./files/FileIntArrayMitBeispielen/Rand100000_2", 
    			"./files/FileIntArrayMitBeispielen/Rand100000_1",
    			"./files/FileIntArrayMitBeispielen/Rand100000_2", 
    			"./files/FileIntArrayMitBeispielen/Sort100000_1",
    			"./files/FileIntArrayMitBeispielen/Sort100000_1",
    			"./files/FileIntArrayMitBeispielen/Sort100000_1",
    			"./files/FileIntArrayMitBeispielen/Sort100000_1",
    			"./files/FileIntArrayMitBeispielen/Sort100000_1",
    	};
    	
    	for (int i = 0; i < fileArray.length; i++) {
        	int[] array = FileIntArray.FileToIntArray(fileArray[i]);
        	
    		long startTime = System.nanoTime();
            ms.sort(array);
            long stopTime = System.nanoTime();
            double timeInSeconds = (double) ((stopTime - startTime)/1000000000.0);
            
    		out.printf((i+1) +  ".) " + fileArray[i] + "\n" + (stopTime - startTime) + "		Nano-Sekunden \n" + timeInSeconds +  "	Sekunden" + "\n \n");
    	}
	}
}