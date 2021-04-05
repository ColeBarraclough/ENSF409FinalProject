package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
//import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class UnitTestManagementAndFurnitureBuilder {
	
	//Enter Username and Password here to test database
	private Management database = new Management("jdbc:mysql://localhost/inventory","Tyler","ensf409");
	
	@Test
	
	//Test Management.java and FurnitureBuilder.java for one set of Mesh Chairs
	
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
		String[][] check = {{"C0942", "C9890"}};
		assertTrue("A non-cheapest list of chairs was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	//Test Management.java and FurnitureBuilder.java for one set of Kneeling Chairs
	
	public void testDatabaseFurnitureBuilderChairNotPossible() {
        database.initializeConnection();
		String[] request = {"Kneeling", "Chair"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		assertFalse("Failed to detect that the build was impossible", mb.buildFurniture(database.listOfFurnitures, 1));
	}
	
	@Test
	
	//Test Management.java and FurnitureBuilder.java for two sets of Standing Desk
	
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
	
	//Test Management.java and FurnitureBuilder.java for two sets of Large Filing
	
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
	
	//Test Management.java and FurnitureBuilder.java for three sets of Desk Lamp
	
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