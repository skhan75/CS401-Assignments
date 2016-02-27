
import java.util.Iterator;

import Lab6.CS401LinkedListImpl.LinkEntry;

public class CS401DblLinkedListImpl<E> extends CS401LinkedListImpl<E> 
{
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements = 0;

   public CS401DblLinkedListImpl() {
      head = tail = null;
   }

   public boolean is_empty(){
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
    * Add e to the end of the doubly linked list.
    * Returns true - if e was successfully added, false otherwise.
    */
   public boolean add(E e) {
	   
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = e;

	   if (head == null) {
		   head = ne;
		   tail = head;
		   head.previous = null;
		   tail.next = null;   
	   }
	   
	   else {
		   tail.next = ne;
		   ne.previous = tail;
		   tail = ne; 
	   }
	   num_elements++;
	   return true;
   }

   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i)
   {
     
	   if(size() == 0 || i > size())
		   return null;
	   
	   
	   else if(i == 1) {
		   E e = head.element;
	       head = head.next;
	       head.previous = null;
	       num_elements--;
	       return e;
	   }
	   
	   else if(i == size()) {
		   E e = tail.element;
	       tail = tail.previous;
	       tail.next = null;
	       num_elements--;
	       return e;
	   }
	   
	   else {
		   LinkEntry<E> current = head;
		   LinkEntry<E> previous = null;
		   
		   for(int m = 1; m <= i ; m++) {
			   previous = current;
			   current = current.next;
		   }
		   
		   E e = current.element;
		   previous.next = current.next;
		   current.previous = previous;
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
	   boolean flag = false;
	   LinkEntry<E> current = head;
	   
	   for(int i = 1; i <= size() ; i++)
	   {
		   E currentElement = current.element;
		   if(currentElement == e)
			   flag = true;
		   current = current.next;		   
	   }
	   return flag;
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

      if (head == null && tail == null) {  
          
    	  head = tail = ne;
          num_elements++;
          return true;          
      }

      if (where == Where.BACK) { // Adding an element at the front of the Linked List
         tail.next = ne;
         ne.previous = tail;
         tail = ne;
      }
      else if (where == Where.FRONT)  { // Adding an element at the begininig of the Linked List
    	  
    	  ne.next = head;
    	  head.previous = ne;
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
   
   public boolean add(Where where, int index, E e)  { // Adding element in the Middle of the Linked List at index position
	   
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
    * Print the doubly linked list starting at the beginning.
    */
   public void print_from_beginning()
   {
      /** Add code here **/
	   System.out.println("Printing from Beginning..");
	   LinkEntry<E> current = head;
       while(current != null){
           System.out.println(current.element);
           current = current.next;
       }   
   }

   /**
    * Print the doubly linked list starting the end.
    */
   public void print_from_end()
   {
	   System.out.println("Printing from End..");
	   LinkEntry<E> current = tail;
       while(current != null) {
           System.out.println(current.element);
           current = current.previous;
       }   
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
      protected LinkEntry<E> previous;

      protected LinkEntry() { element = null; next = previous = null; }
   }
} /* CS401LinkedListImpl<E> */