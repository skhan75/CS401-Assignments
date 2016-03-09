package Lab7;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

public class CarWashTest {

	public static void main(String[] args)
	{
		CarWash cw = new CarWash();
		
		
		int meanArrivalTime;
		int meanServiceTime;
		int maxArrivalTime;
		int arrivalCount = 0;
		
		Scanner input = new Scanner(System.in);		
		System.out.println("Please enter the mean arrival time: ");
		meanArrivalTime = input.nextInt();
		System.out.println("Please enter the mean service time: ");
		meanServiceTime = input.nextInt();		
		System.out.println("Please enter the maximum arrival time: ");
		maxArrivalTime = input.nextInt();
		
		Random random = new Random(100);
		
		while(arrivalCount < maxArrivalTime) {
			arrivalCount = arrivalCount + getTime(meanArrivalTime, random);
			cw.WASH_TIME = getTime(meanServiceTime, random);
			cw.process(arrivalCount);	
		}
		
		cw.finishUp();
		
		final String RESULTS_HEADING = "\nHere are the results of the simulation:\n";
		LinkedList<String> results = cw.getResults(); System.out.println (RESULTS_HEADING);
		System.out.println("----------------------------------------------");
		System.out.println("Time\tEvent\t\t\tWaiting Time");
		System.out.println("----------------------------------------------");
		for (String s : results)
			System.out.print (s);
		
		input.close();
	}
	
	 public static int getTime (int meanTime, Random random) 
	   {  
	      double randomDouble = random.nextDouble();
	    
	      return (int)Math.round (-meanTime*Math.log (1 - randomDouble)); 
	   } // getTime
	 
	
}
