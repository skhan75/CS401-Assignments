/* ***********************************************************************************************************************************
 * Name: SAMI AHMAD KHAN
 * CWID: A20352677
 * Class: CS 401 
 * Assignment: Lab #3
 * Program: Program: To calculate Fibonacci equivalent of a number 
 * Date: 02/03/2016
 * ***********************************************************************************************************************************/
 
import java.util.Scanner;
import java.util.*;

public class FibonacciUser {
	
	public static void main(String[] args){
		
		new FibonacciUser().run();
	}
	
	
	/**
	*  The Fibonacci number of the integer entered has been printed.
	*/
	private void run() {
		
		final int Sentinel = -1;
		
		final String INPUT_PROMPT = "\nPlease enter a positive integer whose Fibonacci you want (or " + Sentinel + " to quit): ";
		final String RESULT_MESSAGE = "\nIts Fibonacci equivalent is: "; //Prints the result
		
		Scanner in = new Scanner (System.in);
		int n; // No whose fibonacci has to be found
		
		final double NANO_FACTOR = 1000000.0;
		long startTime; //Start Timer
		long endTime; // End Timer
		double elapsedTime; //Total Elapsed Time for the operation
		long fibonacciVal;
		
		while (true) {
			try{
			      System.out.print (INPUT_PROMPT); 
			      n = in.nextInt();
			      if (n == Sentinel) {
			    	  System.out.println("System Exit !");
			    	  break;
			      }
			    //Calculating Fibonacci using an Iterative function
		          startTime = System.nanoTime();
		          fibonacciVal = fibIterative(n);
		          endTime = System.nanoTime();
		          elapsedTime = (endTime - startTime)/NANO_FACTOR;
		          System.out.println (RESULT_MESSAGE + fibonacciVal + " using fibIterative() method");
		          System.out.println("Time taken to execute fibIterative() method = " + elapsedTime + " msec");
		          
		        //Calculating Fibonacci using a normal recursive function
		          startTime = System.nanoTime();
		          fibonacciVal = fibOriginalRecursive(n);
		          endTime = System.nanoTime();
		          elapsedTime = (endTime - startTime)/NANO_FACTOR;
		          System.out.println (RESULT_MESSAGE + fibonacciVal + " using fibOriginalRecursive() method");
		          System.out.println("Time taken to execute fibOriginalRecursive() method = " + elapsedTime + " msec");
		          
		         //Calculating Fibonacci using a Formula function
		          startTime = System.nanoTime();
		          fibonacciVal = fibFormula(n);
		          endTime = System.nanoTime();
		          elapsedTime = (endTime - startTime)/NANO_FACTOR;
		          System.out.println (RESULT_MESSAGE + fibonacciVal + " using fibFormula() method");
		          System.out.println("Time taken to execute fibFormula() method = " + elapsedTime + " msec");
		          
		         //Calculating Fibonacci using an modified recursive function
		          startTime = System.nanoTime();
		          fibonacciVal = fibMyRecursive(n, 1, 1);
		          endTime = System.nanoTime();
		          elapsedTime = (endTime - startTime)/NANO_FACTOR;
		          System.out.println (RESULT_MESSAGE + fibonacciVal + " using fibMyRecursive() method");
		          System.out.println("Time taken to execute fibMyRecursive() method = " + elapsedTime + " msec");
			} // End of try
			
			catch (Exception e) {
				System.out.println (e);
			    in.nextLine();
			}// End of catch Exception
			
		}// End of while loop
		
	} // End of method run
	
		
			/**
   			*  Returns a Fibonacci number from a given point in the sequence.
   			*
   			*  @param n - the integer whose Fibonacci number is sought from a given
   			*             point in the sequence.
   			*  @param previous - the previous Fibonacci number in the sequence.
   			*  @param current - the next Fibonacci number in the sequence after 
  			*                   previous.
   			*  @throws IllegalArgumentException - if n <= 0 or > 92 (note 
   			*         that fib (93) is larger than Long.MAX_VALUE).
   			*/
		private long fibMyRecursive(int n, long previous, long current) {
			
			final int MAX_N = 92;

			final String ERROR_MESSAGE = "\nThe number entered must be " +
					"greater than 0 and at most " + MAX_N + ".";

			if (n <= 0 || n > MAX_N)
				throw new IllegalArgumentException (ERROR_MESSAGE);
		      
			if (n <= 2 )
				return current;
			long temp = current;
			current = current + previous;
			previous = temp;
			return fibMyRecursive (n - 1 , previous, current); 
		}

		/**
   		*  The Fibonacci number of the int n has been returned.
   		* 
   		* @param n an int whose Fibinacci number will be returned.
   		*          n > 0.
   		* 
   		* @return a long containing the Fibonacci number of n.
  		*
   		* @throws IllegalArgumentException - if n <= 0 or > 92 (note 
   		*         that fib (93) is larger than Long.MAX_VALUE).
  		*
   		*/
		private long fibFormula(int n) {
			
			final int MAX_N = 92;
			final String ERROR_MESSAGE = "\nThe number entered must be " + "greater than 0 and at most " + MAX_N + ".";
			
			if (n <= 0 || n > MAX_N)
				throw new IllegalArgumentException (ERROR_MESSAGE);
			  	
			return (long)((1 / Math.sqrt (5)) * (Math.pow((1 + Math.sqrt (5)) / 2, n) - Math.pow((1 - Math.sqrt (5)) / 2, n)));
			
		} // End of method fibFormula	
		
		
		/**
  		 *  The Fibonacci number of the int n has been returned.
  		 * 
  		 * @param n an int whose Fibinacci number will be returned.
   		 *          n > 0.
   		 * 
   		 * @return a long containing the Fibonacci number of n.
 	     *
   		 * @throws IllegalArgumentException - if n <= 0 or > 92 (note 
   		 *         that fib (93) is larger than Long.MAX_VALUE).
   		 *
   		 */
		private long fibOriginalRecursive(int n) {
			
			final int MAX_N = 92;
	        final String ERROR_MESSAGE = "\nThe number entered must be " + "greater than 0 and at most " + MAX_N + ".";

	        if (n <= 0 || n > MAX_N)
	              throw new IllegalArgumentException (ERROR_MESSAGE);
	    	if (n <= 2 )
	      	    return 1;
	      	return fibOriginalRecursive (n - 1) + fibOriginalRecursive (n - 2); 

		}// End of fibRecursive method()
		

		/**
		   *  The Fibonacci number of the int n has been returned.
		   * 
		   * @param n an int whose Fibinacci number will be returned.
		   *          n > 0.
		   * 
		   * @return a long containing the Fibonacci number of n.
		   *
		   * @throws IllegalArgumentException - if n <= 0 or > 92 (note 
		   *         that fib (93) is larger than Long.MAX_VALUE).
		   *
		   */
		public static long fibIterative (int n){
			
		    final int MAX_N = 92;
		    final String ERROR_MESSAGE = "\nThe number entered must be " + "greater than 0 and at most " + MAX_N + ".";
		 
		    if (n <= 0 || n > MAX_N)
		        throw new IllegalArgumentException (ERROR_MESSAGE);

		    long previous,current, temp;
		     
		    if (n <= 2) 
		    	return 1;
		    previous = 1;
		    current = 1;
		    for (int i = 3; i <= n; i++) {
		          temp = current;
		          current = current + previous;
		          previous = temp;    
		      } // End of for loop
		      
		      return current;
		      
		 } // End of method fibIterative()		
		
}
