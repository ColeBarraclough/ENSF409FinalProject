package edu.ucalgary.ensf409;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.management.Query;

/**
 * 
 * @author Adeshpal Virk
 * @since March 27, 2021
 * @version 1.0
 * {@summary} This class connects to the database and is used to retrieve data within the database.
 *
 */

public class Management {
	
	/**
	 * database url information
	 */
    public final String DBURL; //store the database url information
    /**
     * user's account username
     */
    public final String USERNAME; //store the user's account username
    /**
     * user's account password
     */
    public final String PASSWORD; //store the user's account password
    /**
     * connection to database
     */
    private Connection dbConnect;
    /**
     * results from database
     */
    private ResultSet results;
    /**
     * results from database
     */
   // ArrayList<String> id = new ArrayList<>(); // Stores id's for current furniture type.
    /**
     * ArrayList of Furniture objects
     */
    public ArrayList<Furniture> list = new ArrayList<Furniture>();
    /**
     * Array of Furniture objects.
     */
    public Furniture[] listOfFurnitures;
    /**
     * Converts ArrayList to Array.
     */
    public Furniture[] getListOfFurniture() {
    	return listOfFurnitures;
    }
    public void toArray() {
    	listOfFurnitures = new Furniture[list.size()];
    	for(int i=0; i< list.size();i++) {
    		listOfFurnitures[i] = list.get(i);
    	}
    }

    
    /**
     * The constructor does not use the database.
     * @param DBURL database url information
     * @param USERNAME user's account username
     * @param PASSWORD user's account password
     */
	public Management(String DBURL,String USERNAME,String PASSWORD) {
		this.DBURL = DBURL;
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
	}
	/**
	 * Does not use the database.
	 * @return database url information.
	 */
	public String getDburl() {
		return this.DBURL;
	}
	/**
	 * Does not use the database.
	 * @return user's account username.
	 */
	public String getUsername() {
		return this.USERNAME;
	}
	/**
	 * Does not use the database.
	 * @return user's account password.
	 */
	public String getPassword() {
		return this.PASSWORD;
	}
	/**
	 * Establishes a connection to the database.
	 */
	public void initializeConnection() {
		
        try{
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Could not establish a connection to database.");
        }
    }
	/**
	 * Creates a Chair object and adds it to an ArrayList of Furniture.
	 * @param type Determines which type of chair is requested.
	 */
	public void chairArray(String type) {
		try {               
			Statement myStmt = dbConnect.createStatement();
			String query = "SELECT * FROM chair";
			results = myStmt.executeQuery(query);
			while (results.next()){
				if(results.getString("Type").equals(type)) {
					Chair temp = new Chair(results.getString("ID"),
							results.getString("Type"),
							results.getString("Legs"),
							results.getString("Arms"),
							results.getString("Seat"),
							results.getString("Cushion"),
							results.getInt("Price"),
							results.getString("ManuID"));
					list.add(temp);
				}
                
			}
			
			myStmt.close();
		}catch(SQLException ex){
			System.out.println("Could not get the names from table chair.");
		}
		return ;
	}
	/**
	 * Creates a Desk object and adds it to an ArrayList of Furniture.
	 * 
	 * @param type Determines which type of desk is requested.
	 */
	public void deskArray(String type) {
		try {               
			Statement myStmt = dbConnect.createStatement();
			String query = "SELECT * FROM desk";
			results = myStmt.executeQuery(query);
			while (results.next()){
				if(results.getString("Type").equals(type)) {
					Desk temp = new Desk(results.getString("ID"),
							results.getString("Type"),
							results.getString("Legs"),
							results.getString("Top"),
							results.getString("Drawer"),
							results.getInt("Price"),
							results.getString("ManuID"));
					list.add(temp);
				}
                
			}
			
			myStmt.close();
		}catch(SQLException ex){
			System.out.println("Could not get the names from table desk.");
		}
		return ;
	}
	/**
	 * Creates a Filing object and adds it to an ArrayList of Furniture.
	 * @param type Determines which type of filing is requested.
	 */
	public void filingArray(String type) {
		try {               
			Statement myStmt = dbConnect.createStatement();
			String query = "SELECT * FROM filing";
			results = myStmt.executeQuery(query);
			while (results.next()){
				if(results.getString("Type").equals(type)) {
					Filing temp = new Filing(results.getString("ID"),
							results.getString("Type"),
							results.getString("Rails"),
							results.getString("Drawers"),
							results.getString("Cabinet"),
							results.getInt("Price"),
							results.getString("ManuID"));
					list.add(temp);
				}
                
			}
			
			myStmt.close();
		}catch(SQLException ex){
			System.out.println("Could not get the names from table filing.");
		}
		return ;
	}
	
	/**
	 * Creates a Lamp object and adds it to an ArrayList of Furniture.
	 * @param type Determines which type of lamp is requested.
	 */
	public void lampArray(String type) {
		try {               
			Statement myStmt = dbConnect.createStatement();
			String query = "SELECT * FROM lamp";
			results = myStmt.executeQuery(query);
			while (results.next()){
				if(results.getString("Type").equals(type)) {
					Lamp temp = new Lamp(results.getString("ID"),
							results.getString("Type"),
							results.getString("Base"),
							results.getString("Bulb"),
							results.getInt("Price"),
							results.getString("ManuID"));
					list.add(temp);
				}
                
			}
			
			myStmt.close();
		}catch(SQLException ex){
			System.out.println("Could not get the names from table lamp.");
		}
		return ;
	}
	/**
	 * Determines which furniture category is being requested.
	 * @param input A string array that contains the full request of the user.
	 */
	public void createArray(String[] input) {
	 String table = input[1];
	 	if(table.equals("Chair")) {
	 		this.chairArray(input[0]);
	 	}
	 	else if(table.equals("Desk")) {
	 		this.deskArray(input[0]);
	 	}
	 	else if(table.equals("Filing")) {
	 		this.filingArray(input[0]);
	 	}
	 	else if(table.equals("Lamp")) {
	 		this.lampArray(input[0]);
	 	}
	 
 }
	

	/**
	 * If request cannot be filled, this method takes in the manufacturer IDs for the specified product
	 * and returns a String that contains the names of recommended manufacturers.
	 * @param manuIDs manufacturer IDs.
	 * @return String with names of recommended manufacturers.
	 */
	public String manuIDstoNames(ArrayList<String> manuIDs) {
		String names = "";
		for(int i =0 ; i< manuIDs.size();i++) {
	        try {
	        	Statement myStmt = dbConnect.createStatement();
	            String query = "SELECT * FROM manufacturer Where ManuID = "+manuIDs.get(i)+";";
	            results = myStmt.executeQuery(query);
	            while (results.next()){
	                names += results.getString("Name");
	                if(!(i == (manuIDs.size() - 1))) {
	                	 names += ", ";
	                }
				}
	            
	            myStmt.close();

	        } catch (SQLException ex) {
				System.out.println("Could not get names.");
	        }
		}
		return names;
	}
/**
 * If the requested order is possible this updates the database.
 * @param category the category to which the item belongs.
 * @param builder A FurnitureBuilder Object.
 */
	public void updateDatabase(String category, FurnitureBuilder builder) {
		String[] IDs = builder.getIds();
		for(int i =0 ; i< IDs.length;i++) {
	        try {
	            String query = "UPDATE "+category.toLowerCase()+" SET "+this.getSetStatement(category)+" Where ID = ?;";
	            
	            PreparedStatement myStmt = dbConnect.prepareStatement(query);

	            myStmt.setString(1, IDs[i]);
	            myStmt.executeUpdate();
	            myStmt.close();

	        } catch (SQLException ex) {
				System.out.println("Could not update"+category+".");
	        }
		}
		
    }
	/**
	 * Creates a statement that corresponds to setting each part within a category to false.
	 * @param category the category to which the item belongs.
	 * @return A String that contains the command needed to sets part availability to false.
	 */
	public String getSetStatement(String category) {
		String setStatement = "";
	 	if(category.equals("Chair")) {
	 		 setStatement = "Legs = 'N', Arms = 'N', Seat = 'N', Cushion = 'N'";
	 	}
	 	else if(category.equals("Desk")) {
	 		 setStatement = "Legs = 'N', Top = 'N', Drawer = 'N'";
	 	}
	 	else if(category.equals("Filing")) {
	 		 setStatement = "Rails = 'N', Drawers = 'N', Cabinet = 'N'";
	 	}
	 	else {
	 		 setStatement = "Base = 'N', Bulb = 'N'";
	 	}
	 	return setStatement;
	}


	/**
	 * Returns an arrayList of all of the manufacturers
	 * @param array An array of furniture
	 * @return An arrayList of all of the manufacturers
	 */
	public ArrayList<String> manufacturers(Furniture[] array) {
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
		return manuIDs;
	}
	
}
