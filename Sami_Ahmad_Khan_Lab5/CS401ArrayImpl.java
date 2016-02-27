/*************************************************************************
 * NAME: Sami Ahmad Khan
 * CWID: A20352677
 * LAB #: 05
 * DATE: 17.02.2016
 * TOPIC: Array Implementation
 * @author SamAK
 *
 * @param <E>
 *************************************************************************/
package Lab5;

public class CS401ArrayImpl<E> implements CS401CollectionInterface<E> {
   private E[] elements;
   private int num_elements;

   private int capacity = 5;

   @SuppressWarnings("unchecked")
   public CS401ArrayImpl() {
      elements = (E[]) new Object[capacity];
      num_elements = 0;
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_full() {
      if (num_elements == capacity)
          return true;
      return false;
   }

   public boolean is_empty() {
      if (num_elements == 0) 
          return true;
      return false;
   }

   public int size() { 
	   return num_elements; 
   }

   public boolean add(E e)  {
      add(Where.BACK, e);  // Add at the end
      return true;
   }

   /*
    * Remove element at index i.  If the element exists in the collection, 
    * return that element back to the user.  If the index is out of bounds,
    * return null.
    */
   public E remove(int i) {
	   E e;	   
	   if (i<0 || i>num_elements-1) // Checking for index out of bounds
		   return null; // If true, return null
	   else{
		   e = elements[i];
		   for (int j = i+1; j < num_elements; j++)
			   elements[j-1] = elements[j];
		   num_elements--;
	   }
	   return e;   // Else new list with removed element is returned   
   }

   /*
    * Return true if e is in the collection class, false otherwise.
    */
   public boolean contains(E e) {
	      for (int j = 0; j < num_elements; j++) {
	    	  if (elements[j].equals(e))
	    		  return true;    	  
	      }
		   return false;  
   }

   /**
    * ---- Methods defined by this class 
    * ----------------------------------------------------------
    * Methods that are added by this class and not in the 
    * CS401CollectionInterface
    */

   /**
    * Add element in middle.
    * Preconditions: where == MIDDLE
    *                index <= num_elements - 1
    */
   
   public boolean add(Where where, int index, E e) { 
  
      /* 
       * If there is no space to add the new element, grow the array. */
      if (is_full())  {
          grow();
      }
     
      if (where== where.MIDDLE && index <=  num_elements - 1 ){
    	  int temp = num_elements;
          for (int i = index; i < num_elements; i++ ) {
        	  elements[temp]=elements[temp-1];
        	  temp--;
          }
          elements[index]=e;
          num_elements++;
          return true; 
      }
      else 
    	  return false;     
   }

   /**
    * Add element in front or at the end, as dictated by where.
    * Preconditions: where != MIDDLE
    */
   public boolean add(Where where, E e) { 
   
      /* 
       * If there is no space to add the new element, grow the array. */
      if (is_full())  {
          grow();
      }

      if (where == Where.BACK)  {
          System.out.println("Inserting element at index " + num_elements);
          elements[num_elements] = e;
          num_elements++;
      } 
      else if (where == Where.FRONT)  {
          System.out.println("Inserting element at index 0");
          System.out.println("Compacting storage");
          int j = num_elements;
          for(int i = 1 ; i <=num_elements; i++){
        	  elements[j] = elements[j-1];
        	  j--;
          }
          
          elements[0] = e;
          num_elements++;
      }

      return true; 
   }

   /*
    * Gets the element at index i (0 <= i <= num_elements-1)
    */
   public E get(int i)  {

      if (i < 0 && i > num_elements)
          return null;

      return(elements[i]);
   }

   /**
    * ----------- Private methods
    */
   /*
    * Grows elements array to hold more elements.  Copies old (existing)
    * elements in the new array.
    * 
    * Postcondition: (a) elements must contain the contents of the old array
    *                (b) elements must now have twice as much capacity as
    *                    before
    */
   
   @SuppressWarnings("unchecked")
   private boolean grow()  {
	   
	  capacity = 2 * capacity;
	  E[] tempArray = (E[]) new Object[capacity];
	  
	  for (int i = 0; i < tempArray.length; i++) {
		    if (i<elements.length){
		        tempArray[i] = elements[i];
		    }
	  }
	  elements=tempArray;
	  tempArray=null;
	   
      System.out.println("Capacity reached.  Increasing storage...");
      System.out.println("New capacity is " + capacity + " elements");

      return true;
   }
   
   /**
   * subList(int from, int to): Returns the view of a portion of the list between the specified index from,
   * inclusive, and index to, exclusive. That is returns a sublist [from, to). *
   * Ensure that from and to are valid indices. *
   * The method returns a new CS401ArrayImpl<E> object. */
   
   public CS401ArrayImpl<E> subList(int from, int to){
	   
	   int len = num_elements-1;
	   CS401ArrayImpl<E> newArray= new CS401ArrayImpl<E>();
	    
	   if ((from<0 || from==to || to<0) && ( to > (len-1)|| from >(len-1))) 
		   return null;	   
	   else {
		   for(int i = from ; i < to ; i++)	{
			   newArray.add(elements[i]);   		
	   }
		   
	   return newArray;
	   }
   }   
   
}
