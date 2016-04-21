package Lab10;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Efficiency
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		CS401BST<String> bst = new CS401BST<String>();
		CS401LinkedListImpl<String> list = new CS401LinkedListImpl<String>();
						
		//inputting the data from file
		Scanner scanner = new Scanner(new File("students.dat"));
        
        String str;
        String[] split1 = new String[2];
        String[] split2 = new String[4];
        String firstName;
        String lastName;
        String middleName;
        long ID;
        
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            
            split1 = str.split(","); lastName = split1[0].trim(); //extracting last name from 0th index seperated by ","
      
            split2 = split1[1].split(" ");
            firstName = split2[1].trim(); //extracting first name from 1st index
            middleName = split2[2].trim();
            ID = Long.parseLong(split2[3].trim());
            
            bst.add(lastName, firstName, middleName, ID);
            list.add(lastName, firstName, middleName, ID);
        }   

        scanner.close();
		
		list.toString();
		//Searching
		System.out.println("****    LINKED LIST VS BINARY SEARCH TREE   **** \n");
		search(bst, list, 483293267);
		search(bst, list, 1902997270);
		search(bst, list, 856408684);
		search(bst, list, 143507366);
		search(bst, list, 307954472);
		search(bst, list, 876561221);
		
		
		
	}
	
	public static void search(CS401BST<String> bst, CS401LinkedListImpl<String> list, long ID){
		
		
		long startTime1, startTime2, endTime1, endTime2;
		System.out.println("Searching for student ID: "+ ID);
		
		startTime1 = System.nanoTime();
		System.out.println(list.contains(ID));
		endTime1 = System.nanoTime();
		
		startTime2 = System.nanoTime();
		System.out.println(bst.contains(ID));
		endTime2 = System.nanoTime();
		
		System.out.println("Search time in linked list: " + ((endTime1-startTime1)/1000000000.00)+ "seconds");
		System.out.println("Search time in binary search tree: " + ((endTime2-startTime2)/1000000000.00)+"seconds\n");
	}	
}

