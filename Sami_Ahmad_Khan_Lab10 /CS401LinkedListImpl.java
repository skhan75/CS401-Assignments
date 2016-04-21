package Lab10;
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

   public CS401LinkedListImpl() {
      head = tail = null;
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
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
    * Adds element e at the end of the linked list. */
   public boolean add(String lName, String fName, String mName, long ID)  {

	      LinkEntry<E> ne = new LinkEntry<E>();
	      
	      ne.lastName = lName;
	      ne.firstName = fName;   
	      ne.middleName = mName;
	      ne.ID = ID;
	      
	      if (head == null && tail == null) {
	          head = tail = ne;
	          num_elements++;
	          return true;
	      }

	      else {
	         tail.next = ne;
	         tail = ne;
	         ne.next = null;
	      }
	      
	      num_elements++;
	      return true;
	   }
   
   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i) { // Here i is the element to be deleted
   
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
   public String contains(long iD)
   {
	   LinkEntry current = new LinkEntry();
	   current = head;
	   while(current != null)
	   {
		   if(current.ID == iD)
			   return "Success (record found) with LinkedList: "+current.lastName+" "+current.firstName+" "+current.middleName+" "+current.ID;
		   current = current.next;
	   }
	   return "No record with this key found in Linked List";
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
   protected class LinkEntry<E> {
	   public long ID;
	   public String middleName;
	   public String lastName;
	   public String firstName;
	   protected E element;
	   protected LinkEntry<E> next;
   }
   /* ------------------------------------------------------------------- */



} /* CS401LinkedListImpl<E> */

