package edu.ucalgary.ensf409;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

/**
 * 
 * @author Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea, Cole Barraclough
 * @since April 11, 2021
 * @version 1.2
 * {@summary} Unit tests for the functionality of Management.java.
 *
 */

 //IMPORTANT
 // Make sure to update the database back to the origonal before running these tests
 //IMPORTANT

public class ManagementTest {

	/**
	 * The database url, username and password
	 */
	private Management database = new Management(User.URL,User.USERNAME,User.PASSWORD);


	@Test
	
	/**
	 * Make a request for a list of Chairs of type Mesh
	 * from the database and tests if Management.java
	 * can return the correct list of Chairs
	 */
	
	public void testCreateArrayChair() {
        database.initializeConnection();
		String[] request = {"Mesh", "Chair"};
		database.createArray(request);
        database.toArray();
		String[] idList = new String[database.listOfFurnitures.length];
		for(int i = 0; i < database.listOfFurnitures.length; i++){
			idList[i] = database.listOfFurnitures[i].getId();
		}
		String[] check = {"C0942", "C6748", "C8138", "C9890"};
		assertTrue("An incorrect list of chairs was created", Arrays.equals(idList, check));
	}
	
	@Test
	
	/**
	 * Make a request for a list of Desks of type Traditional
	 * from the database and tests if Management.java
	 * can return the correct list of Desks
	 */
	
	public void testCreateArrayDesk() {
        database.initializeConnection();
		String[] request = {"Traditional", "Desk"};
		database.createArray(request);
        database.toArray();
		String[] idList = new String[database.listOfFurnitures.length];
		for(int i = 0; i < database.listOfFurnitures.length; i++){
			idList[i] = database.listOfFurnitures[i].getId();
		}
		String[] check = {"D0890", "D4231", "D8675", "D9352"};
		assertTrue("An incorrect list of desks was created", Arrays.equals(idList, check));
	}
	
	@Test
	
	/**
	 * Make a request for a list of Filings of type Small
	 * from the database and tests if Management.java
	 * can return the correct list of Filings
	 */
	
	public void testCreateArrayFiling() {
        database.initializeConnection();
		String[] request = {"Small", "Filing"};
		database.createArray(request);
        database.toArray();
		String[] idList = new String[database.listOfFurnitures.length];
		for(int i = 0; i < database.listOfFurnitures.length; i++){
			idList[i] = database.listOfFurnitures[i].getId();
		}
		String[] check = {"F001", "F004", "F005", "F006", "F013"};
		assertTrue("An incorrect list of filings was created", Arrays.equals(idList, check));
	}
	
	@Test
	
	/**
	 * Make a request for a list of Lamps of type Study
	 * from the database and tests if Management.java
	 * can return the correct list of Lamps
	 */
	
	public void  testCreateArrayLamp() {
        database.initializeConnection();
		String[] request = {"Study", "Lamp"};
		database.createArray(request);
        database.toArray();
		String[] idList = new String[database.listOfFurnitures.length];
		for(int i = 0; i < database.listOfFurnitures.length; i++){
			idList[i] = database.listOfFurnitures[i].getId();
		}
		String[] check = {"L223", "L928", "L980", "L982"};
		assertTrue("An incorrect list of lamps was created", Arrays.equals(idList, check));
	}

	@Test(expected = IllegalArgumentException.class)

	/**
	 * Make a request for a list of Lumps of type Study
	 * from the database. These don't exist so should throw
	 * an IllegalArgumentException.
	 */
	public void testCreateArrayIllegalInput() {
		database.initializeConnection();
		String[] request = {"Study", "Lump"};
		database.createArray(request);

	}

	@Test
	/**
	 * Make a request for a list of Lamps of type Stady
	 * from the database. These don't exist but will create an empty list
	 */
	public void testCreateArrayNonExistantInput() {
		database.initializeConnection();
		String[] request = {"Stady", "Lamp"};
		database.createArray(request);
		assertTrue("List created was not empty", database.getListOfFurniture() == null);
	}

	@Test
	
	/**
	 * Builds a Chair from FurnitureBuilder and tests
	 * if Management.java successfully removes the
	 * the purchased chairs form the database
	 */

	public void testUpdateDatabase() {
		database.initializeConnection();

		String category = "Chair";
		FurnitureBuilder myBuilder = new FurnitureBuilder();

		Chair chairOne = new Chair("C0914", "Task", "N", "N", "Y", "Y", 50, "002");
        Chair chairTwo = new Chair("C1148", "Task", "Y", "N", "Y", "Y", 125, "003");
        Chair chairThree = new Chair("C3405", "Task", "Y", "Y", "N", "N", 100, "003");

		Furniture[] myList = new Furniture[3];
		myList[0] = chairOne;
		myList[1] = chairTwo;
		myList[2] = chairThree;

		myBuilder.buildFurniture(myList, 1);
		database.updateDatabase(category, myBuilder);


		database.createArray(new String[]{"Task", "Chair"});
		database.toArray();
		boolean[][] idList = new boolean[database.listOfFurnitures.length][4];
		for(int i = 0; i < database.listOfFurnitures.length; i++){
			idList[i] = database.listOfFurnitures[i].getParts();
		}
		boolean[][] check = {new boolean[]{true, false, true, true}};
		assertTrue("An incorrect list of Chairs was created", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	/** 
	* Tests that entering a type of chair that does not exist
	* in the database results in an empty list
	*/

	public void testManagementChairArray() {
		database.initializeConnection();
		database.chairArray("Premium");
		assertTrue("List created was not empty", database.getListOfFurniture() == null);
	}
	
	@Test
	
	/**
	* Tests that entering a type of desk that does not exist
	*  in the database results in an empty list
	*/

	public void testManagementDeskArray() {
		database.initializeConnection();
		database.deskArray("Extendable");
		assertTrue("List created was not empty", database.getListOfFurniture() == null);
	}
	
	@Test
	
	/**
	* Tests that entering a  type of filing that does not exist
	* in the database results in an empty list
	*/

	public void testManagementFilingArray() {
		database.initializeConnection();
		database.filingArray("Grand");
		assertTrue("List created was not empty", database.getListOfFurniture() == null);
	}
	
	@Test
	
	/**
	* Tests that entering a  type of lamp that does not exist
	* in the database results in an empty list
	*/
	
	public void testManagementLampArray() {
		database.initializeConnection();
		database.lampArray("Shade");
		assertTrue("List created was not empty", database.getListOfFurniture() == null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	
	/**
	* Tests that if a category isnt a valid entry in the database, 
	* it will generate an IllegalArgumentException
	*/
	
	public void testCreateArray() {
		database.initializeConnection();
		String [] input = {"Traditional", "Table"};
		database.createArray(input);
	}
	
	@Test
	
	/**
	* Tests that an arraylist of ManuID will return the correct manufacturers
	*/
	
	public void testManuIDsToNames() {
		database.initializeConnection();
		ArrayList<String> input = new ArrayList<String>();
		input.add("002"); input.add("000"); input.add("005");
		assertTrue("String returned was incorrect", database.manuIDstoNames(input).equals("Office Furnishings, Fine Office Supplies"));
	}
}