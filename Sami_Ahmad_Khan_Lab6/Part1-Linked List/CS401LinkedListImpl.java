package Lab6;
/*************************************************************************
 * NAME: Sami Ahmad Khan
 * CWID: A20352677
 * Lab # 06
 * DATE: 02/24/2016
 * TOPIC: "Linked List, Doubly Linked List and Sorted Linked List
 * @author SamAK
 *************************************************************************/
import org.omg.CORBA.Current;

public class CS401LinkedListImpl<E> implements CS401CollectionInterface<E>
{
   protected LinkEntry<E> head;
   protected LinkEntry<E> tail;
   protected int num_elements = 0;

   public CS401LinkedListImpl()
   {
      head = tail = null;
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { 
	   return false; 
   }

   public int size() { 
	   return num_elements; 
   }

   /* 
    * Adds element e at the end of the linked list. */
   public boolean add(E e)
   {
      add(Where.BACK, e);
      return true;
   }

   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i) // Here i is the element to be deleted
   {
	   if (i<0 || i>num_elements-1) // Checking for index out of bounds
		   return null; 
	   
	   else if (i == 1) { // When index is 1 --> 1st element
		   E e = head.element;
		   head = head.next;
		   num_elements--;
		   return e;   
	   }
	   
	   else if (i == size()) {	// For last element
		   LinkEntry<E> previous = null;
		   LinkEntry<E> current = head;
		   while (current.next != null) {
			   previous = current;
			   current = current.next;
		   }
		   E e = current.element;
		   previous.next = null;
		   tail = previous;
		   num_elements--;
		   return e;
			   
	   }
	   
	   else { // Removing from anywhere in the middle
		   LinkEntry<E> previous = null;
		   LinkEntry<E> current = head;
		   
		   
		  for(int m=1; m<i; m++){  
			  previous = current;
			  current = current.next;
		  }
		  
		   E e = current.element;
		   previous.next=current.next;
		   current=current.next;
		   num_elements--;
		   return e;
	   }
   }

   /**
    * Determines if e is in the collection. 
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
      
	   boolean bool = false;
	   E e1 = head.element;
	   LinkEntry<E> current = head; 
	  
	   while (current != null){
		   e1 = current.element;
		   
		   if(e1.equals(e)){
			   bool = true;
			   break;
		   }
		   else 
			   bool = false;
		   current = current.next;  
	   }
	   
	   return bool;
   }

   /**
    * Add e to either front of the linked list or the end of the linked
    * list, depending on the value of the parameter where.
    * If where == MIDDLE, return false.
    * Returns true if element added to back or front, or false if asked
    * to add in the middle. */
   public boolean add(Where where, E e)  {

      if (where == Where.MIDDLE) 
          return false;

      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
          head = tail = ne;
          num_elements++;
          return true;
      }

      if (where == Where.BACK) {
         tail.next = ne;
         tail = ne;
      }
      else if (where == Where.FRONT)  { // Adding an element at the begininig of the Linnked List
    	  ne.next = head;
    	  head = ne;
      }
      
      num_elements++;
      return true;
   }

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  First element of the linked list
    * is 0, second is 1, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)  {
	   
	   boolean bool = false;
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = e;
	   int count = 1;
	   
	   LinkEntry<E> current = head;
	   
	   if(where != Where.MIDDLE)
		   return false;
	   
	   else{
		   while(count < index){ // Traversing through the linked list till index	  
				 current = current.next;
				 count++;		  
		   } 
		   ne.next = current.next;
		   current.next = ne;
		   bool = true;	   
	   }
	   num_elements++;		
	   return bool;
   }

   /**
    * Print the collection class (linked list) by iterating over all of
    * the elements in the collection class and serializing them. 
    * Returns a Java String object that represents the serialization of
    * the collection class. */
   public String toString()  {

      StringBuilder result = new StringBuilder();

      LinkEntry<E> current = head;
      
      while(current != null){
    	  result = result.append(current.element);
    	  current = current.next;
      }
      return result.toString();
   }
   

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
   }
   /* ------------------------------------------------------------------- */

} /* CS401LinkedListImpl<E> */

