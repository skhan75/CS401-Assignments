
public class EqualityCheck {

	public static void main(String[] args){
		// Creation of FullTimeEmployee objects to test properties
		FullTimeEmployee employee1 = new FullTimeEmployee("Dave", 1200.61);
		FullTimeEmployee employee2 = new FullTimeEmployee("Mark", 850.20);
		FullTimeEmployee employee3 = new FullTimeEmployee("Smith", 1600.88);
		FullTimeEmployee employee4 = new FullTimeEmployee("Smith", 1600.88);
		FullTimeEmployee employee5 = new FullTimeEmployee("Smith", 1600.88);
		
		//Printing FullTimeEmployee objects details
		System.out.println("FullTimeEmployee objects details: ");
		System.out.println("-----------------------------------\n");
		System.out.println("First Object --> Employee1 :"+employee1);
		System.out.println("Second Object --> Employee2 :"+employee2);
		System.out.println("Third Object --> Employee3 :"+employee3);
		System.out.println("Fourth Object --> Employee4 :"+employee4);
		System.out.println("Fifth Object --> Employee5 :"+employee5);
		System.out.println("\n");
		
		// Testing for reflexivity property
		System.out.println("1. Reflexivity Check");
		System.out.println("---------------------------------");
		System.out.println("employee1.equals(employee1) : "+employee1.equals(employee1)+"\n");
				
		// Testing for symmetry property
		System.out.println("2. Symmetry Check");
		System.out.println("--------------------------------");
		System.out.println("employee1.equals(employee2) : "+employee1.equals(employee2));
		System.out.println("employee2.equals(employee1) : "+employee2.equals(employee1)+"\n");
				
		// Testing for transitivity	property
		System.out.println("3. Transitivity Check");
		System.out.println("--------------------------------");
		System.out.println("employee3.equals(employee4) : "+employee3.equals(employee4));
		System.out.println("employee4.equals(employee5) : "+employee4.equals(employee5));
		System.out.println("employee3.equals(employee5) : "+employee3.equals(employee5)+"\n");
		
		// Testing for actuality property
		System.out.println("4. Actuality Check");
		System.out.println("---------------------------------------");
		System.out.println("employee1.equals(null) :"+employee1.equals(null));
				
		//Testing for consistency property
		System.out.println("5. Consistency Check");
		System.out.println("--------------------------------");
		System.out.println("Testing the function 10 times and observing the consistency");
		for(int i = 1; i < 10; i++)
			System.out.println("employee1.equals(employee2) : "+employee1.equals(employee2));
		
		
	}// End of main
}//End of Class
