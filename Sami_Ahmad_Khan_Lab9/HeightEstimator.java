package Lab9;
/**
 * Name: SAMI AHMAD KHAN
 * CWID: A20352677
 * Lab#: 09
 */

import java.util.*;

public class HeightEstimator {  
  public static void main (String[] args){
    new HeightEstimator().run();
  } // method main 

   public void run() {  
	 System.out.println("----------------------------------------\nHEIGHT ESTIMATOR\n----------------------------------------");
     final String SIZE_MESSAGE = "The tree size is: ";
     final String RATIO_MESSAGE = "The ratio of the average height to the log, base 2, of the tree size is ";
     final int SIZES = 5;
     final int TRIALS_PER_SIZE = 20;
  
     BinarySearchTree<Double> myTree = new BinarySearchTree<Double>();
     Random rand = new Random();
     Scanner sc = new Scanner (System.in);
     int n,totalHeight;
     System.out.println("");
     double averageHeight;
    
     while (true){
       try {
          System.out.print ("\nEnter no of elements to be inserted for the first trial: ");
          n = sc.nextInt();
          
          for (int i = 1; i <= SIZES; i++) {  
              totalHeight = 0;
              for (int j = 0; j < TRIALS_PER_SIZE; j++) {
            	  for(int k = 1; k <= n; k++){
            		  	myTree.add(rand.nextDouble());
            	  }

            	  totalHeight = totalHeight + myTree.height();
            	  myTree.clear();
              } 
              System.out.println();
              System.out.println (SIZE_MESSAGE + n);
              averageHeight = (double)totalHeight / TRIALS_PER_SIZE;              
              System.out.println("Average Height is " + averageHeight);
              System.out.println (RATIO_MESSAGE + (double)(averageHeight/(Math.log10(n)/Math.log10(2))));                           
              n *= 2;
          } // for each size
          break;
       }//try
       catch (InputMismatchException e) {
          System.out.println (e);
          sc.nextLine();
       }       
     } 
   }  
} 
