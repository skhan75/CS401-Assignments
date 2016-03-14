/*************************************************************************
 * NAME: Sami Ahmad Khan
 * CWID: A20352677
 * Lab # 07
 * DATE: 02/30/2016
 * TOPIC: STACK using ARRAY Implementation
 * @author SamAK
 *************************************************************************/

package Lab8;

import java.util.EmptyStackException;

public class CS401StackArrayImpl<E> implements CS401StackInterface<E> 
{
   private int num_elements;
   private int max_elements;
   private E[] elements;

   public CS401StackArrayImpl()
   {
      max_elements = 10; 
      num_elements = 0;
      elements = (E[]) new Object[max_elements];
   }

   /**
    * Push an element on the stack.  If the stack is full, then allocate
    * more memory to hold a new stack, copy existing elements to the new
    * stack and add the new element to the newly enlarged stack.
    * Do not use System.arraycopy().  You are essentially implementing
    * what System.arraycopy() will do when you expand an existing array. **/
   public void push(E e){
	   
	   if(num_elements == max_elements)  
		   growArray(); // Function to grow the size of the array --> See below
		   	      
	   elements[num_elements] = e;
	   num_elements++;
   }

   public E pop() {
	   
      if(isEmpty())
    	  throw new EmptyStackException();
      else{
    	  num_elements--;
    	  E e = elements[num_elements];
    	  elements[num_elements] = null;
    	  return e;
      }
   }

   public int size(){
      return num_elements;
   }
   
   /**
    * Grows the size of the Array when stack limit is reached
    */
   private void growArray() {
	   
	   E[] newStack = (E[]) new Object[elements.length + 10];
	   System.out.println("Capacity Reached !! Growing Stack by 10 elements...\n");
	   
	   for(int i=0; i<elements.length; i++){
		   newStack[i] = elements[i];
	   }
	   elements = newStack;	
   }
   
 /**-----------------------------------------------------------------
   * Returns true if the stack is empty and false otherwise. 
   *-------------------------------------------------------------------*/
   public boolean isEmpty() {
	return (num_elements == 0);
   }
   
   
  /**-------------------------------------------------------------------
   * Returns a reference to the element at the top of the stack.
   * The element is not removed from the stack.  Throws an
   * EmptyStackException if the stack is empty. 
   *-------------------------------------------------------------------*/ 
   public E top() {
       if (isEmpty())
         throw new EmptyStackException();

       return elements[num_elements-1];
   }

} /* CS401StackArrayImpl<E> */
