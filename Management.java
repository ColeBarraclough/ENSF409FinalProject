package edu.ucalgary.ensf409;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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
    private Connection dbConnect;
    private ResultSet results;
    ArrayList<String> id = new ArrayList<>(); // Stores id's for current furniture type.
    
    ArrayList<Chair> chairList = new ArrayList<Chair>();
    ArrayList<Desk> deskList = new ArrayList<Desk>();
    ArrayList<Filing> filingList = new ArrayList<Filing>();
    ArrayList<Lamp> lampList = new ArrayList<Lamp>();
    
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
	public void initializeConnection() {
		
        try{
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Could not establish a connection to database.");
        }
    }
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
					chairList.add(temp);
				}
                
			}
			
			myStmt.close();
		}catch(SQLException ex){
			System.out.println("Could not get the names from table studio.");
		}
		return ;
	}
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
					deskList.add(temp);
				}
                
			}
			
			myStmt.close();
		}catch(SQLException ex){
			System.out.println("Could not get the names from table studio.");
		}
		return ;
	}
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
					filingList.add(temp);
				}
                
			}
			
			myStmt.close();
		}catch(SQLException ex){
			System.out.println("Could not get the names from table studio.");
		}
		return ;
	}
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
					lampList.add(temp);
				}
                
			}
			
			myStmt.close();
		}catch(SQLException ex){
			System.out.println("Could not get the names from table studio.");
		}
		return ;
	}
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
	
	public static void main(String[] args) {

		Management myJDBC = new Management("jdbc:mysql://localhost/inventory","adesh","ensf409");
        myJDBC.initializeConnection();
		String[] input1 = {"Mesh","Chair","1"};
		myJDBC.createArray(input1);
        System.out.println(myJDBC.chairList.get(0).toString());
		String[] input2 = {"Traditional","Desk","1"};
		myJDBC.createArray(input2);
        System.out.println(myJDBC.deskList.get(0).toString());
		String[] input3 = {"Medium","Filing","1"};
		myJDBC.createArray(input3);
        System.out.println(myJDBC.filingList.get(0).toString());
		String[] input4 = {"Study","Lamp","1"};
		myJDBC.createArray(input4);
        System.out.println(myJDBC.lampList.get(0).toString());
    }
}
