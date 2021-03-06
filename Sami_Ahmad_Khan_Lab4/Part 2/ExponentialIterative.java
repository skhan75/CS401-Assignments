import java.util.Scanner;

public class ExponentialIterative {
	/**
	* Calculates the value of a given integer raised to the power of a second integer.
	* The worstTime(n) is O(n), where n is the second integer. *
	* @param i – the base integer (to be raised to a power).
	* @param n – the exponent (the power i is to be raised to). *
	* @return the value of i to the nth power. *
	* @throws IllegalArgumentException – if n is a negative integer or if i raised to
	* to the n is greater than Long.MAX_VALUE. *
	*/
	
	public static void main(String[] args){
		
		Scanner in = new Scanner (System.in);
		System.out.println("Enter the Base Integer:");
		int num = in.nextInt();
		System.out.println("Enter the Exponent");
		int pow = in.nextInt();
		
		double start=System.nanoTime();
		System.out.println("The value of "+num+" to the power of "+pow+" is "+power(num, pow));
		double end = System.nanoTime();
		double timeElapsed = end-start;
		System.out.println("Time elapsed for Iterative version is: "+timeElapsed/1000000+" msec");
	}
	
	//Wrapper Method
	public static long power (long i, int n){
		
		if (n==0)
			return 1;
		else if(n==1)
			return 1;
		else if(n<0 || n > Long.MAX_VALUE )
			throw new IllegalArgumentException("Invalid Exponent entered !");
		else
			return iterPowerCalculator(i,n);
		
				
	}
	//Exponential Value Calculator Method
	private static long iterPowerCalculator(long i, int n) {
		
		int power = 1;		
		for(int k=1; k<=n; k++){
			power*= i;
		}
		return power;
	}
	
	

}
