package Lab10;
/*************************************************************************
 * NAME: Sami Ahmad Khan
 * CWID: A20352677
 * Lab # 06
 * DATE: 02/24/2016
 * TOPIC: "Linked List, Doubly Linked List and Sorted Linked List
 * @author SamAK
 *************************************************************************/
public interface CS401CollectionInterface<E>
{
   /**
    * Determines if this data structure is at its capacity.
    * 
    * @return true - if this data structure is at its capacity; false otherwise.
    */
   public boolean is_full();

   /**
    * Determines if this data structure is empty.
    * 
    * @return true - if this data structure is empty; false otherwise.
    */
   public boolean is_empty();

   /**
    * Determines the number of elements in this data structure.
    * 
    * @return the number of elements currently resident in this
    *         data structure.
    */
   public int size();

   /**
    * Add a new element.
    *
    * @param e the element to be added.  
    *
    * It is expected that classes that extend this interface will
    * provide an order on how the element is added to the collection. 
 * @param iD 
 * @param middleName 
 * @param firstName 
    */
   public boolean add(String lastName, String firstName, String middleName, long iD);

   /**
    * Remove the specified element.
    *
    * @param i - Index of the element to be removed.
    *
    * @return the element removed, if the element exists on the collection,
    *         null otherwise.
    */
   public E remove(int i);

   /**
    * Determine if the element is contained in this list.
    *
    * @param e the element to be searched for.
    *
    * @return true - if e was in the list, false otherwise.
    */
   public String contains(long iD);
}