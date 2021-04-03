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
	private static String filename = "orderform1.txt";
	
	//Request user's input
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter a furniture category:");
		String val1 = sc.nextLine();
		while (isAlpha(val1) == false) {
			System.out.println("Enter enter a valid category containing only alphabets");
			val1 = sc.nextLine();
		}
		String category = formatString(val1);
		
		System.out.print("Please enter a furniture type:");
		String val2 = sc.nextLine();
		while (isAlpha(val2) == false) {
			System.out.println("Enter enter a valid type containing only alphabets");
			val2 = sc.nextLine();
		}
		String type = formatString(val2);
		
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
		String[] input1 = {type.trim(),category.trim(),Integer.toString(number)};
		myJDBC.createArray(input1);
		myJDBC.toArray();
		FurnitureBuilder builder = new FurnitureBuilder();
		if(!builder.buildFurniture(myJDBC.listOfFurnitures,number)) {  
			manufacturers(myJDBC.getListOfFurniture());
		}
		else {
			orderForm(type.trim(),category.trim(),Integer.toString(number),builder);
			myJDBC.updateDatabase(category.trim(),builder);
		}
		
		
		//call method to determine if the request can be filled
		//fillRequest()
			// if true, calls orderForm
			// if false, calls manufacturers
			
	}
	//Checks that the input string argument is strictly letters - no numbers, or other weird characters
	public static boolean isAlpha(String str) {
	   char [] arr = str.toCharArray();
	   
	   for (int i = 0; i < arr.length; i++) {
		   if ( !((arr[i] >= 'a'  && arr[i] <='z') || (arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] == ' ' ))) {
			   return false;
		   }
	   }
	   return true;
		
	}
	
		//Cleans up the String to make it acceptable to the database
	public static String formatString(String arg) {
		String str = arg.trim();
		String result ="";
		String[] arr = str.split("\\s");
		
		int i=0;
		
		while(i<arr.length){
			String test = arr[i];
			result += test.substring(0,1).toUpperCase();
			result += test.substring(1).toLowerCase();
			result+=" ";
			i++;
		}
		return result;
	}
	
	public static void orderForm(String type,String category,String number,FurnitureBuilder builder) {
		File form = new File(filename);
		BufferedWriter writer = null;
		
		//Filename must have been specified
		if (filename == null) {
			System.err.printf("Filename must be specified");
		    System.exit(1);
		}
		
		try {	//Create the file if it doesnt exist
			int i=1;
			while(form.exists()) {
				String yes = "orderform";
				yes += Integer.toString(i);
				yes += ".txt";
				filename = yes;
				i++;
				form = new File(filename);
			}
			form.createNewFile();
			System.out.println("The new order form file has been created");
		}
		catch (IOException e) {
		      System.out.println("An error occurred in creating the file.");
		      e.printStackTrace();
		}
		String faculty = "";
		String contact = "";
		String date = "";
		
		//Now write the order to the file
		try {
			writer = new BufferedWriter(new FileWriter(filename));
			writer.write("Furniture Order Form " + "\n\n" + "Faculty Name: " + faculty + "\n");
			writer.write("Contact: " + contact +"\n" + "Date: " + date + "\n\n");
			
			writer.write("Original Request: ");
			writer.write(type.toLowerCase() +" "+ category.toLowerCase() + ", " + number+ "\n\n");
			
			writer.write("Items Ordered" + "\n");
			String[] ID = builder.getIds();
			for(int i =0; i< ID.length ;i++) {
				writer.write("ID: " + ID[i] + "\n");
			}

			writer.write("\n" +"Total Price: " + Integer.toString(builder.getPrice()));
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
	public static void manufacturers(Furniture[] array) {
		//This method should access the class/method that
		// connects to the database
		ArrayList<String> manuIDs = new ArrayList<>();
		manuIDs.add(array[0].getManuId());
		for(int i = 1;i<array.length;i++) {
			for(int j=0; j< manuIDs.size();j++) {
				if(manuIDs.contains(array[i].getManuId())) {
					
				}
				else {
					manuIDs.add(array[i].getManuId());
				}
			}
		}
		System.out.println("manufactures: " + manuIDs);
	}

}
