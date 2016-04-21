package Lab12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;


public class SortEstimation{

	public static void main(String[] args) throws FileNotFoundException {
		String[] input = new String[3380];
		
		Scanner scanner = new Scanner(new File("students.dat"));
		
		int i = 0;
        while (scanner.hasNextLine()){
        	input[i] = scanner.nextLine();
        	i++;
        }
        
        long startTime, endTime;
        
        System.out.println("\n**      CONQUER AND DIVIDE SORTS ANALYSIS      **");
      	System.out.println("---------------------------------------------------\n");
      	
        startTime = System.nanoTime();
        MergeSort.sort(input);
        endTime = System.nanoTime();
        System.out.printf("Merge sort of data file takes %.3f seconds%n",
        		((endTime - startTime)/1000000000.000));
        
        startTime = System.nanoTime();
        HeapSort.sort(input);
        endTime = System.nanoTime();
        System.out.printf("Heap sort of data file takes %.3f seconds%n",
        		((endTime - startTime)/1000000000.000));
        
        startTime = System.nanoTime();
        QuickSort.sort(input);
        endTime = System.nanoTime();
        System.out.printf("Quick sort of data file takes %.3f seconds%n",
        		((endTime - startTime)/1000000000.000));
               
       
        
	}
	
	
	
	
	
	
	
	
}
