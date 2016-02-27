
public class Minimum {
	public static void main(String[] args){
		int A[] = {10, -20, 1, 2, 0, 5, 100};
		
		int s = minimum(A, A.length);
		if(s == -1)
			System.out.println("Invalid Array");
		else
			System.out.println("Minimum No is: "+s);
		
	}

	private static int minimum(int[] a, int length) {
		if(length == 0)
			return -1;
		if (length == 1)  // Base case
		    return  a[0];
		  else {
		    int y = minimum(a, length - 1);	
		    if (y < a[length - 1]) 
		      return y;
		    else
		       return a[length -1];		
		}
	}
}