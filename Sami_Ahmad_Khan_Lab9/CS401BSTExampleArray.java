package Lab9;

import java.io.IOException;

public class CS401BSTExampleArray{

	public static void main(String[] args) throws IOException {
		CS401BSTArray<String> bst = new CS401BSTArray<String>();
		bst.add("dog");
		bst.add("turtle");
		bst.add("cat");
		bst.add("ferret");
		bst.add("shark");
		bst.add("whale");
		bst.add("porpoise");
		bst.print(); // print bst
		System.out.printf("%n");
		
		CS401BSTArray<Integer> bst2 = new CS401BSTArray<Integer>();
		bst2.add(3);
		bst2.add(18);
		bst2.add(4);
		bst2.add(99);
		bst2.add(50);
		bst2.add(23);
		bst2.add(5);
		bst2.add(101);
		bst2.add(77);
		bst2.add(87);
		bst2.print(); 
		
		System.out.println("\nRemoving Ferret..");
		bst.remove("ferret");
		System.out.println("\nAfter deletion of ferret:");
		System.out.println("-----------------------------");
		bst.print();
		
		System.out.println("\nRemoving element 50..");
		bst2.remove(50);
		System.out.println("\nAfter deletion of 50:");
		System.out.println("-----------------------------");
		bst2.print();
		
		System.out.println("\nChecking for 'cat' in the tree..");
		System.out.println("Is Element present? --> "+ bst.contains("cat"));
		
		System.out.println("\nChecking for 'tiger' in the tree..");
		System.out.println("Is Element present? --> "+ bst.contains("tiger"));
		
		System.out.println("\nInOrder Traversal");
		System.out.println("-------------------");
		System.out.println(bst.inorder());
		
	}
}
