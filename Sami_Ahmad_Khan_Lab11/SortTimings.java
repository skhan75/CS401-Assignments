import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortTimings {

	public static void main(String[] args) throws FileNotFoundException{
		
		
		Scanner scanner = new Scanner(new File("students.dat"));
		Scanner scanner1 = new Scanner(new File("students.dat"));
		Scanner scanner2 = new Scanner(new File("students.dat"));
		String[] input = new String[3380];
		String[] input1 = new String[3380];
		String[] input2 = new String[3380];
        int i=0;
        
        while (scanner.hasNextLine()) {
            input[i] = scanner.nextLine();
            input1[i] = scanner1.nextLine();
            input2[i] = scanner2.nextLine();
            i++;
        }   
        
        long startTime = System.nanoTime();
		bubbleSort(input);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Bubble sort of data file takes "+ timeElapsed/1000000000.000+" seconds");
		
		
		long startTime1 = System.nanoTime();
		insertionSort(input1);
		long endTime1 = System.nanoTime();
		long timeElapsed1 = endTime1 - startTime1;
		System.out.println("Insertion sort of data file takes "+ timeElapsed1/1000000000.000+" seconds");
		
		long startTime2 = System.nanoTime();
		selectionSort(input2);
		long endTime2 = System.nanoTime();
		long timeElapsed2 = endTime2 - startTime2;
		System.out.println("Selection sort of data file takes "+ timeElapsed2/1000000000.000+" seconds");
	}


	/**
	 * Sorts a specified array into the order specified by a specified Comparator * object.
	 * The worstTime(n) is O(n * n). *
	 * @param x - the array to be sorted.
	 * @param comp - the Comparator object used for ordering. *
	 * @throws NullPointerException - if x and/or comp is null. *
	 */
	private static void selectionSort(Object[] in2) {
		for (int i = 0; i < (in2.length - 1); i++) {
			int pos = i;
			for (int k = i + 1; k < in2.length; k++)
				if ((((Comparable)in2 [k]).compareTo (in2[pos]) < 0))
					pos = k;
			swap (in2, i, pos);
			
		} 
	} 
		
	/**
	* Sorts a specified array of int values into ascending order.
	* The worstTime(n) is O(n * n). *
	* @param x - the array to be sorted. *
	* @throws NullPointerException - if x is null. *
	*/
	private static void insertionSort(Object[] in1 ) {
		for (int i = 1; i < in1.length; i++)		
			for (int k = i; k > 0 && (((Comparable)in1 [k-1]).compareTo (in1[k]) > 0); k--)	
				swap (in1, k, k -1);
	} 
		
	
	/**
	* Sorts a specified array of int values into ascending order.
	* The worstTime(n) is O(n * n). *
	* @param stm - the array to be sorted. *
	* @throws NullPointerException - if x is null. */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	private static void bubbleSort(Object[] in) {
		
		int finalSwapPos = in.length - 1, swapPos;
		while (finalSwapPos > 0) {
			swapPos = 0;
			for (int i = 0; i < finalSwapPos; i++){
				
				if (((Comparable)in[i]).compareTo (in [i+1]) > 0) {
					swap (in, i, i + 1);
					swapPos = i;
				}
			}
			finalSwapPos = swapPos;
		}
		 
	}
	// Swap Method
	private static void swap(Object[] x, int i, int j) {
		Object t = x[i];
		x[i] = x[j];
		x[j] = t;
		
	}
}
	
