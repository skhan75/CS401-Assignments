/*************************************************************************
 * NAME: Sami Ahmad Khan
 * CWID: A20352677
 * Lab # 07
 * DATE: 02/30/2016
 * TOPIC: STACK using ARRAY Implementation
 * @author SamAK
 *************************************************************************/
package Lab7;

public class CS401StackArrayMain {
	
	//MAIN method for STACK using ARRAY Implementation
	public static void main(String[] args){
		
		String array[] ={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		CS401StackArrayImpl<String> task = new CS401StackArrayImpl<String>();
		System.out.println("Test Vectors for STACK using ARRAY Implementation");
		System.out.println("-------------------------------------------------\n");
		
		//1. Pushing given 10 elements from a to j on the stack
		for(int i=0; i<10; i++)
			task.push(array[i]);
		
		//2. Printing Number of elements
		System.out.println("Number of elements in the Stack: "+ task.size()+"\n");
		
		//3. Pushing new element "k" in the stack
		task.push("k");
		
		//4. Printing Number of elements
		System.out.println("Number of elements in the Stack: "+ task.size());
		
		//5. Deleting top 2 elements from the stack
		System.out.println("Deleting 2 elements...");
		task.pop();
		task.pop();
		
		//6. Printing the Topmost elements on the stack
		System.out.println("Topmost Element on the Stack now is --> << "+ task.top()+" >>");
		
		//7. Printing Number of elements
		System.out.println("Number of elements in the Stack: "+ task.size()+"\n");
	}
}
