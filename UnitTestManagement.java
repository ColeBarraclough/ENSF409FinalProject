package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
//import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class UnitTestManagement {

	//Enter Username and Password here to test database
	private Management database = new Management("jdbc:mysql://localhost/inventory","Tyler","ensf409");


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
}