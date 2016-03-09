package Lab7;

public class CS401QueueArrayMain {
	public static void main(String[] args){
		
		String array[] ={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		
		CS401QueueArrayFixedImpl<String> task = new CS401QueueArrayFixedImpl<String>(10);
		CS401QueueArrayFloatingImpl<String> task1 = new CS401QueueArrayFloatingImpl<String>(10);
		CS401QueueLinkedListImpl<String> task2 = new CS401QueueLinkedListImpl<String>();
		
		System.out.println("Test Vectors for QUEUE using ARRAY Fixed Implementation");
		System.out.println("-------------------------------------------------\n");
		
		//1. Pushing given 10 elements from a to j on the Queue
		for(int i=0; i<10; i++)
			task.add(array[i]);
		
		//2. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task.size());
		
		System.out.println("Adding a new element 'k' in the QUEUE ");
		//3. Pushing new element "k" in the Queue
		task.add("k");
		
		//4. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task.size());
		
		//5. Deleting top 2 elements from the Queue
		System.out.println("Deleting 2 elements...");
		task.remove();
		task.remove();
		
		//6. Printing the Topmost elements on the Queue
		System.out.println("Topmost Element on the QUEUE now is --> << "+ task.peek()+" >>");
		
		//7. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task.size());
		
		System.out.println("\nTest Vectors for QUEUE using ARRAY Floating Implementation");
		System.out.println("-------------------------------------------------\n");
		
		//8. Pushing given 10 elements from a to j on the Queue
		for(int i=0; i<10; i++)
			task1.add(array[i]);
		
		//9. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task1.size());
		
		System.out.println("Adding a new element 'k' in the QUEUE ");
		//10. Pushing new element "k" in the Queue
		task1.add("k");
		
		//11. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task1.size());
		
		//12. Deleting top 2 elements from the Queue
		System.out.println("Deleting 2 elements...");
		task1.remove();
		task1.remove();
		
		//13. Printing the Topmost elements on the Queue
		System.out.println("Topmost Element on the QUEUE now is --> << "+ task1.peek()+" >>");
		
		//14. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task1.size());
		
		System.out.println("\nTest Vectors for QUEUE using LINKED LIST Implementation");
		System.out.println("-------------------------------------------------\n");
		
		//15. Pushing given 10 elements from a to j on the Queue
		for(int i=0; i<10; i++)
			task2.add(array[i]);
		
		//16. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task2.size());
		
		System.out.println("Adding a new element 'k' in the QUEUE ");
		//17. Pushing new element "k" in the Queue
		task2.add("k");
		
		//18. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task2.size());
		
		//19. Deleting top 2 elements from the Queue
		System.out.println("Deleting 2 elements...");
		task2.remove();
		task2.remove();
		
		//20. Printing the Topmost elements on the Queue
		System.out.println("Topmost Element on the QUEUE now is --> << "+ task2.peek()+" >>");
		
		//21. Printing Number of elements
		System.out.println("Number of elements in the QUEUE: "+ task2.size());
	}
}
