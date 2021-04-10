package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/**
 * 
 * @author Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea, Cole Barraclough
 * @since April 5, 2021
 * @version 1.1
 * {@summary} Unit tests for the functionality of FurintureBuilde.java and Management.java together.
 *
 */

public class ManagementAndFurnitureBuilderTest {
	
	/**
	 * The database url, username and password
	 */
	private Management database = new Management(User.URL,User.USERNAME,User.PASSWORD);
	
	@Test
	
	/**
	 * Make a request for a list of Chairs of type Mesh
	 * from the database and tests if Management.java
	 * can send the correct list to FurnitureBuilder.java
	 * and can return the cheapest combination
	 * of chairs that can successfully create 1 chair of
	 * the specified type
	 */
	
	public void testDatabaseFurnitureBuilderChair() {
        database.initializeConnection();
		String[] request = {"Mesh", "Chair"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		mb.buildFurniture(database.listOfFurnitures, 1);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"C6748", "C8138", "C9890"}};
		assertTrue("A non-cheapest list of chairs was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	/**
	 * Make a request for a list of Chairs of type Kneeling
	 * from the database and tests if Management.java
	 * can send the correct list to FurnitureBuilder.java
	 * and can detect that it is impossible
	 * to create 1 chair of the specified type
	 */
	
	public void testDatabaseFurnitureBuilderChairNotPossible() {
        database.initializeConnection();
		String[] request = {"Kneeling", "Chair"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		assertFalse("Failed to detect that the build was impossible", mb.buildFurniture(database.listOfFurnitures, 1));
	}
	
	@Test
	
	/**
	 * Make a request for a list of Desks of type Standing
	 * from the database and tests if Management.java
	 * can send the correct list to FurnitureBuilder.java
	 * and can return the cheapest combination
	 * of desks that can successfully create 2 desks of
	 * the specified type
	 */
	
	public void testDatabaseFurnitureBuilderDesk() {
        database.initializeConnection();
		String[] request = {"Standing", "Desk"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		mb.buildFurniture(database.listOfFurnitures, 2);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"D1927", "D2341"}, {"D3820", "D4438"}};
		assertTrue("A non-cheapest list of desks was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	/**
	 * Make a request for a list of Filings of type Large
	 * from the database and tests if Management.java
	 * can send the correct list to FurnitureBuilder.java
	 * and can return the cheapest combination
	 * of filings that can successfully create 2 filings of
	 * the specified type
	 */
	
	public void testDatabaseFurnitureBuilderFiling() {
        database.initializeConnection();
		String[] request = {"Large", "Filing"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		mb.buildFurniture(database.listOfFurnitures, 2);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"F010", "F012"}, {"F011", "F015"}};
		assertTrue("A non-cheapest list of filings was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	/**
	 * Make a request for a list of Lamps of type Desk
	 * from the database and tests if Management.java
	 * can send the correct list to FurnitureBuilder.java
	 * and can return the cheapest combination
	 * of lamps that can successfully create 3 lamps of
	 * the specified type
	 */
	
	public void testDatabaseFurnitureBuilderLamp() {
        database.initializeConnection();
		String[] request = {"Desk", "Lamp"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		mb.buildFurniture(database.listOfFurnitures, 3);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"L013", "L208"}, {"L112", "L342"}, {"L564"}};
		assertTrue("A non-cheapest list of lamps was returned", Arrays.deepEquals(idList, check));
	}
	
}