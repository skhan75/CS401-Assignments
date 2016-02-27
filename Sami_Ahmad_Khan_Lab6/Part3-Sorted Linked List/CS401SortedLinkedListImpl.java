
public class CS401SortedLinkedListImpl<E> extends CS401LinkedListImpl<E>
{
   public CS401SortedLinkedListImpl(){
      super();
   }

   public int size() { 
	   return num_elements;
   }
   
   /** 
    * Adds element e in sorted order in the collection class (linked 
    * list).
    * Returns true if e was added successfully, false otherwise.
    */
   public boolean add(E e)
   {
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = e;
	   
	   if(head == null && tail == null)
		   head = tail = ne;
	   
	   else{
		   LinkEntry<E> prev = null;
		   LinkEntry<E> i;
		   
		   for(i=head; i!=null; i = i.next){
			   int compare = ((Comparable) e).compareTo(i.element);
			   if(compare < 0) // If element added is less than one on list
				   break;
			   prev = i;
		   }
		   
		   if(prev == null){
			   ne.next = head;
			   head = ne;
		   }
		   
		   else if(i == null) {// Adding as a new tail to the list
			   tail.next = ne;
			   tail = ne;
		   }  
		   else{
			   ne.next = prev.next;
			   prev.next = ne;
		   }
	   } 
	   num_elements++;
	   return true;
   }

   /**
    * Print the sorted linked list in reverse order using recursion.
    */
   public void reverse_print()  {
	   reverseRec(head);
   }

   private void reverseRec(CS401LinkedListImpl<E>.LinkEntry<E> head) {
	   if(head == null)
		   return;
	   reverseRec(head.next);
	   System.out.print(head.element);
	
   }

} /* CS401SortedLinkedListImpl<E> */