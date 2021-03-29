package edu.ucalgary.ensf409;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 
 * @author Hannah Oluyemisi Asaolu
 * @since March 27, 2021
 * @version 1.0
 * {@summary} This class takes in the user input for 
 * a) furnitrure category b)its type c) the number of items requested
 * 
 * This class also  generates an order form as a .txt file if the request can be filled.
 * Otherwise, it outputs the names of suggested manufacturers
 *
 */

public class User {
	private static String filename = "orderform.txt";
	
	//Request user's input
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter a furniture category:");
		String category = sc.nextLine();
		while (isAlpha(category) == false) {
			System.out.println("Enter enter a valid category containing only alphabets");
			category = sc.nextLine();
		}
		
		System.out.print("Please enter a furniture type:");
		String type = sc.nextLine();
		while (isAlpha(type) == false) {
			System.out.println("Enter enter a valid type containing only alphabets");
			type = sc.nextLine();
		}
		int number = 0;
		try {
			System.out.print("Please enter the number of items you need:");
			 number = sc.nextInt();
			sc.close();
			System.out.println("You requested "  + number + " "+ category + " " + "of type" + " "+ type);
		}
		catch(InputMismatchException e) {
			//e.printStackTrace();
			System.err.println("Please enter a valid integer amount of items");
		}
		Management myJDBC = new Management("jdbc:mysql://localhost/inventory","adesh","ensf409");
        myJDBC.initializeConnection();
		String[] input1 = {type,category,Integer.toString(number)};
		myJDBC.createArray(input1);
		myJDBC.toArray();
		ArrayList<Furniture> list2 = FurnitureBuilder.calculateLowestPrice(myJDBC.list3);
		for(int i =0; i<list2.size();i++) {
			System.out.println(list2.get(i).toString());
		}
		orderForm();
		
		//call method to determine if the request can be filled
		//fillRequest()
			// if true, calls orderForm
			// if false, calls manufacturers
			
	}
	
	//Checks that the input string argument is strictly letters - no numbers, or other wierd characters
	public static boolean isAlpha(String str) {
	   char [] arr = str.toCharArray();
	   
	   for (int i = 0; i < arr.length; i++) {
		   if (!( (arr[i] >= 'a' && arr[i] <='z') || (arr[i] >= 'A' && arr[i] <= 'Z') ) ) {
			   return false;
		   }
	   }
	   return true;
		
	}
	
	public static void orderForm() {
		File form = new File(filename);
		BufferedWriter writer = null;
		
		//Filename must have been specified
		if (filename == null) {
			System.err.printf("Filename must be specified");
		    System.exit(1);
		}
		
		try {	//Create the file if it doesnt exist
			
			if (!form.exists()) {
				form.createNewFile();
				System.out.println("The new order form file has been created");
			}
			else {
				System.out.println("File already exists");
			}
		}
		catch (IOException e) {
		      System.out.println("An error occurred in creating the file.");
		      e.printStackTrace();
		}
		String faculty = "Arts";
		String contact = "Emily Ann";
		String date = "Jan 1, 1920";
		
		//Now write the order to the file
		try {
			writer = new BufferedWriter(new FileWriter(filename));
			writer.write("Furniture Order Form " + "\n\n" + "Faculty Name: " + faculty + "\n");
			writer.write("Contact: " + contact +"\n" + "Date: " + date + "\n\n");
			
			writer.write("Original Request: " + "\n\n");
			
			writer.write("Items Ordered" + "\n");
			writer.write("ID: " + "\n" + "ID: " + "\n\n");
			writer.write("Total Price: ");
		}
		catch (Exception e) {
		      System.err.println("I/O error opening/writing file.");
		      System.err.println(e.getMessage());
		      System.exit(1);
		    }
		
		//Close the file
		finally {
			try {
				if (writer != null) {
					writer.close();
				}
			}catch(IOException e) {
				System.err.println("Error closing file.");
				System.exit(1);
			}
			
		}
	}
	
	//Prints out the names of possible manufacturers
	public void manufacturers() {
		//This method should access the class/method that
		// connects to the database
	}

}
