/*************************************************************************
 * NAME: Sami Ahmad Khan
 * CWID: A20352677
 * Lab # 07
 * DATE: 02/30/2016
 * TOPIC: STACK using LINKED LIST Implementation
 * @author SamAK
 *************************************************************************/
package Lab7;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CS401StackLinkedListImpl<E> implements CS401StackInterface<E> 
{
   private LinkEntry<E> head;
   private int num_elements;

   public CS401StackLinkedListImpl()
   {
      head = null;
      num_elements = 0;
   }

   /**
    * Adds the item to this stack.
    * @param e --> the element to add
    */
   public void push(E e) {
	   
	   LinkEntry<E>  current = head;
       head = new LinkEntry<E>();
       head.element = e;
       head.next = current;
       num_elements++;
   }

   /**
    * Removes and returns the item most recently added to this stack.
    * @return the item most recently added
    * @throws java.util.NoSuchElementException if this stack is empty
    */
   public E pop() {
	   
	   if(head != null)
       {
    	   E e = head.element;
    	   head = head.next;
    	   num_elements--;
    	   return e;
       }
	   return null;
	   
     /* if(isEmpty()) 
    	  return null;
    	  //throw new NoSuchElementException("Stack underflow");
      else{
    	  E e = head.element;
          head = head.next;
          num_elements--;
          return e;*/
      
   }

   /**------------------------------------------------------------------
    * Returns the number of elements in the stack.
    * @return the number of elements in the stack
    *-------------------------------------------------------------------*/
   public int size() {
      return num_elements;
   }

   /**-----------------------------------------------------------------
    * Returns true if the stack is empty and false otherwise. 
    *-------------------------------------------------------------------*/
   public boolean isEmpty() {
       return head == null;
   }
   
   /**-------------------------------------------------------------------
    * Returns a reference to the element at the top of the stack.
    * The element is not removed from the stack.  
    *-------------------------------------------------------------------*/ 
   public E top() {
       return head.element;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
} /* CS401StackLinkedListImpl<E> */
