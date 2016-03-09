package Lab7;

import java.util.EmptyStackException;

/* 
 * Fixed front implementation of a Queue using arrays */

public class CS401QueueArrayFixedImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFixedImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }
 
   public void add(E element) {
	   if(this.is_full()){
		   System.out.println("\nQueue limit reached !! Doubling the size of Queue\n");
		   growSize(); // If Queue is full , growSize() function will be called
	   }
	
	   data[back] = element;
	   back++;
   }

   public E remove()  {
	   if(this.is_empty())
		   throw new RuntimeException("Queue underflow");
	   else{
		   E eFront = data[front];
		   for(int i=0; i<back; i++){
			   data[i] = data[i+1];   
		   }
		   data[back] = null;
		   back--;
		   
		   return eFront;
	   }
   }

   public E peek()  {
	   if (is_empty()) throw new RuntimeException("Queue underflow");
       return data[front];
   }
   
   public boolean is_empty()  {
      return front == back;
   }

   public boolean is_full()  {
	   return back == capacity;

   }
   
   public int size(){
	      return back;
	   }
   
   private void growSize() {
	   capacity = capacity * 2;
	   E[] temp = (E[]) new Object[capacity];
	   for(int i=0; i<data.length; i++){
		   temp[i] = data[i];
	   }
	   data = temp;
   }
}
