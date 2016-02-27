import java.util.Scanner;

public class PascalTriangle {
	
	public static void main(String[] args){
		
		long n;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter rows in Pascal's triangle.. ");
		n = in.nextInt();
		
		double start=System.nanoTime();
		iterativePascal(n);
		double end = System.nanoTime();
		double timeElapsed = end-start;

		System.out.println("\nRuntime for the Iterative version is: "+timeElapsed / 1000000+"msec\n");
		
		System.out.printf("Enter the Row, Element");
		String input = in.next();
		String[] temp = input.split(","); // Splitting the string containing row and element and converting them into Integers
		int row = Integer.parseInt(temp[0]);
		int element = Integer.parseInt(temp[1]);
		
		long recursive = recursivePascal(row, element);
		System.out.println("\nThe element at that position is: "+recursive);
	}
    //Method for calculating Pascal Value Iteratively
	private static void iterativePascal(long n) {
			
		    int row, num;
		    
		    for (int i=0; i<= n-1; i++) {
		        num = 1;
		        row = i + 1; //This is the Row
		        for (int col=0; col<=i; col++) {
		            if (col > 0) {
		                num = num * (row - col) / col;    
		            }
		            System.out.print(num + " ");
		        }
		        System.out.println();
		    }		
	}
	
	//Method for calculating Pascal Value Recursively
	private static long recursivePascal(int row, int element){
		
		 if (element == 0)
		        return 0;
		    else if(row == 1 && element == 1)
		        return 1;
		    else if (element > row)
		        return 0;
		    else
		        return (recursivePascal(row-1, element-1) + recursivePascal(row-1, element));
		}
		
	
}
