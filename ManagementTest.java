package edu.ucalgary.ensf409;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;
//import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ManagementTest {

	//Enter Username and Password here to test database
	private Management database = new Management("jdbc:mysql://localhost/inventory","root","ensf409");


	@Test
	
	//Test Management.java for Mesh Chair
	
	public void testDatabaseChair() {
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
	
	//Test Management.java for Traditional Desk
	
	public void testDatabaseDesk() {
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
	
	//Test Management.java for Small Filing
	
	public void testDatabaseFiling() {
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
	
	//Test Management.java for Study Lamp
	
	public void testDatabaseLamp() {
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

	@Test

	public void updateDatabaseTest() {
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
		boolean[][] check = {new boolean[]{false, false, false, false}, new boolean[]{true, false, true, true}, new boolean[]{false, false, false, false}};
		assertTrue("An incorrect list of lamps was created", Arrays.deepEquals(idList, check));
	}
}
