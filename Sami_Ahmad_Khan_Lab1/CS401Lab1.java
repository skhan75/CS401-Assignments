

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CS401Lab1 {
	
	//Main Function -->
	public static void main(String[] args) throws IOException{
		
		double efficiency; //Variable to store the efficiency/mileage 
		String choice; //Variable to store choice from the user whether he wants continue calculating or not
		Scanner in = new Scanner(System.in); //Scanner object to accept input from standard input
		int vehicleNo = 1;
		
		do{
			System.out.println("*************************************");
			System.out.println("       FUEL ECONOMY CALCULATOR       ");
			System.out.println("*************************************");
			efficiency = calculate();
			System.out.println("\nAverage MPG:"+efficiency+"\n");  // Printing the fuel efficiency
			System.out.println("-------------------------------------------------------------------------");
			
			//Writing the outputs to a File "Output.txt" in the Application's root folder
			File file =new File("Output.txt"); //Creating a File
			if(!file.exists()){  //Checks if the file already exists or not
				try { //Exception Handling
					file.createNewFile(); //If not exit, then it will create a new file
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			FileWriter fileWritter = new FileWriter(file.getName(),true); // Creating a FileWriter Object
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter); // Creating a BufferedWriter Object     
			bufferWritter.write("\nAverage MPG of your vehicle #"+vehicleNo+" is:"+efficiency); //Writing output to the file
			bufferWritter.write("");
			bufferWritter.close(); //Closing the BufferedWriter object
			
			System.out.println("Want to continue calculating for more vehicles? (y/n)"); //Asking user if he wants to calculate for more vehicles
			choice = in.nextLine();	
			vehicleNo++;
		}
		while(choice.equalsIgnoreCase("y"));
		System.out.println("\n** Thank You for using the system ! **");
		in.close();	// Closing the scanner object	
	}
	
	public static double calculate(){
		
		//Declaring variable for taking distance traveled and gallons of fuel consumed as input from user
		double dist, fuel; 
		String choice;
		Scanner in1 = new Scanner(System.in); //Scanner object to accept input from standard input

		do{
			//Prompt the user for entering miles traveled
			System.out.println("Enter the total distance travelled by your vehicle in Miles");
			dist = in1.nextDouble();
			
			//Checking for wrong input
			if(dist < 0)
				System.out.println("\nYou've entered an invalid input (Please enter a non negative value)");
		}
		while(dist<0);
			
		do{
			//Prompt the user for entering miles traveled
			System.out.println("Enter the total quantity of fuel consumed (in Gallons)");
			fuel = in1.nextDouble();
			
			//Checking for wrong input
			if(fuel <= 0)
				System.out.println("\nYou've entered an invalid input (Please enter a value greater than Zero");
		}
		while(fuel <= 0);
			
		double mpg = dist/fuel;    //Calculating Fuel Efficiency
		return mpg;                //Sending the value to main function
		
	}//End of calculate function
}//End of class CS401Lab1
