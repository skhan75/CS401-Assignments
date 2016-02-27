
import java.util.*;

public class PermuteUser
{
    public static void main (String [ ] args)
    {
        new PermuteUser().run();
    } // End of main method 
    
  /**
   *  Permutes the input strings entered.
   */
  public void run()
  {
    final String SENTINEL = "***";

    final String INPUT_PROMPT =
        "\nPlease enter a string (or " + SENTINEL + " to quit): ";

    String line;
 
    Scanner sc = new Scanner (System.in);
     
    while (true)
    {
      try
      {
        System.out.print (INPUT_PROMPT);
        line = sc.nextLine(); 
        if (line.equals (SENTINEL))
            break;
        System.out.println (permute (line));
      }//End of try
      catch (Exception e) 
      {
        System.out.println (e);
        
      }//End of catch Exception
    }//End of while
  } // Enf of method run

  
  /**
   * Finds all permutations of a given string.
   *
   * @param s - the string to be permuted  
   *
   * @return a String representation of all the permutations of s.
   *    
   */
  public static String permute (String s)
   { 
	  StringBuffer sb = new StringBuffer(s);
      return recPermute (sb, 0);
   } //End of method permute
                             
  
  /**
   * Finds all permutations of a string from a given position to the end.
   *
   * @param s - string of which permutations needs to be found
   * @param k - the starting position in c of the string to be permuted.
   *
   * @return a String representation of all the permutations.
   *    
   */
  protected static String recPermute (StringBuffer s, int k)
  {
	  StringBuffer sb1 = new StringBuffer(s);
	  StringBuffer allPermutations = new StringBuffer();
	  if(k == sb1.length() - 1)
		  return sb1.toString() + "\n";
	  
	  else{	  
		  char temp;
		  for (int i = k; i < sb1.length(); i++){
	            temp = sb1.charAt(i);
	            sb1.setCharAt(i, sb1.charAt(k));
	            sb1.setCharAt(k,temp);
	            allPermutations.append(recPermute (sb1, k + 1));	                       
	        } // End of for
		  return allPermutations.toString();
	  }// End of else 
  }// End of method recPermute
  
} // class PermuteUser

