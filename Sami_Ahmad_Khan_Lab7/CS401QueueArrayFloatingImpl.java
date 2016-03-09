package Lab7;

/* 
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;
   private int num_elements;

   public CS401QueueArrayFloatingImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
      num_elements = 0;
   }

   public void add(E element) {
	   if(this.is_full()){
		   System.out.println("\nQueue limit reached !! Doubling the size of Queue\n");
		   growSize(); // If Queue is full , growSize() function will be called
	   }
	   data[back] = element;
	   back = (back+1) % capacity;
	   num_elements++;
   }

   public E remove()  {
      
	   if(this.is_empty())
		   throw new RuntimeException("Queue underflow");
	   
	   E eFront = data[front];
	   eFront = data[front];
	   front = (front+1) % capacity;
	   num_elements--;
	   return eFront;
   }
   
   public E peek()  {
	   if (is_empty()) throw new RuntimeException("Queue underflow");
       return data[front];
   }

   public boolean is_empty()  {
	   return num_elements == 0;
   }

   public boolean is_full()  {
	   return num_elements == capacity;
   }
   
   public int size(){
	   return num_elements;
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