package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
//import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class UnitTest {
	
	//Enter Username and Password here to test database
	private Management database = new Management("jdbc:mysql://localhost/inventory","Tyler","ensf409");
	
	@Test
	
	//Test getters in Chair.java
	
	public void testChairParts() {
		Chair testChair = new Chair("C2453", "Mesh", "Y", "N", "Y", "N", 75, "004");
		boolean[] parts = new boolean[4];
		parts[0] = testChair.getLegs();
		parts[1] = testChair.getArms();
		parts[2] = testChair.getSeat();
		parts[3] = testChair.getCushion();
		boolean[] check = {true, false, true, false};
		assertTrue("Getters in Chair.java returned the incorrect value", Arrays.equals(parts, check));
	}
	
	@Test
	
	//Test getters in Furinture.java with Chair
	
	public void testChairIdTypePriceManuId() {
		Chair testChair = new Chair("C2453", "Mesh", "Y", "N", "Y", "N", 75, "004");
		String[] info = new String[4];
		info[0] = testChair.getId();
		info[1] = testChair.getType();
		info[2] = String.valueOf(testChair.getPrice());
		info[3] = testChair.getManuId();
		String[] check = {"C2453", "Mesh", "75", "004"};
		assertTrue("Getters in Furniture.java returned the incorrect value", Arrays.equals(info, check));
	}
	
	@Test
	
	//Test getters in Desk.java
	
	public void testDeskParts() {
		Desk testDesk = new Desk("D2623", "Standing", "Y", "N", "Y", 50, "003");
		boolean[] parts = new boolean[3];
		parts[0] = testDesk.getLegs();
		parts[1] = testDesk.getTop();
		parts[2] = testDesk.getDrawer();
		boolean[] check = {true, false, true};
		assertTrue("Getters in Desk.java returned the incorrect value", Arrays.equals(parts, check));
	}
	
	@Test
	
	//Test getters in Furinture.java with Desk
	
	public void testDeskIdTypePriceManuId() {
		Desk testDesk = new Desk("D2623", "Standing", "Y", "N", "Y", 50, "003");
		String[] info = new String[4];
		info[0] = testDesk.getId();
		info[1] = testDesk.getType();
		info[2] = String.valueOf(testDesk.getPrice());
		info[3] = testDesk.getManuId();
		String[] check = {"D2623", "Standing", "50", "003"};
		assertTrue("Getters in Furniture.java returned the incorrect value", Arrays.equals(info, check));
	}

	@Test
	
	//Test getters in Filing.java

	public void testFilingParts() {
		Filing testFiling = new Filing("F594", "Small", "Y", "Y", "N", 100, "002");
		boolean[] parts = new boolean[3];
		parts[0] = testFiling.getRails();
		parts[1] = testFiling.getDrawers();
		parts[2] = testFiling.getCabinet();
		boolean[] check = {true, true, false};
		assertTrue("Getters in Filing.java returned the incorrect value", Arrays.equals(parts, check));
	}
	
	@Test
	
	//Test getters in Furinture.java with Filing
	
	public void testFilingIdTypePriceManuId() {
		Filing testFiling = new Filing("F594", "Small", "Y", "Y", "N", 100, "002");
		String[] info = new String[4];
		info[0] = testFiling.getId();
		info[1] = testFiling.getType();
		info[2] = String.valueOf(testFiling.getPrice());
		info[3] = testFiling.getManuId();
		String[] check = {"F594", "Small", "100", "002"};
		assertTrue("Getters in Furniture.java returned the incorrect value", Arrays.equals(info, check));
	}
	
	@Test
	
	//Test getters in Lamp.java

	public void testLampParts() {
		Lamp testLamp = new Lamp("L045", "Desk", "Y", "N", 18, "002");
		boolean[] parts = new boolean[2];
		parts[0] = testLamp.getBase();
		parts[1] = testLamp.getBulb();
		boolean[] check = {true, false};
		assertTrue("Getters in Lamp.java returned the incorrect value", Arrays.equals(parts, check));
	}
	
	@Test
	
	//Test getters in Furinture.java with Lamp
	
	public void testLampIdTypePriceManuId() {
		Lamp testLamp = new Lamp("L045", "Desk", "Y", "N", 18, "002");
		String[] info = new String[4];
		info[0] = testLamp.getId();
		info[1] = testLamp.getType();
		info[2] = String.valueOf(testLamp.getPrice());
		info[3] = testLamp.getManuId();
		String[] check = {"L045", "Desk", "18", "002"};
		assertTrue("Getters in Furniture.java returned the incorrect value", Arrays.equals(info, check));
	}
	
	@Test
	
	//Test FurnitureBuilder.java for one set of chairs
	
	public void testFurnitureBuilderChair1() {
        
        FurnitureBuilder mb = new FurnitureBuilder();

        Chair[] chairs = new Chair[5];

        chairs[0] = new Chair("C5842", "Task", "Y", "N", "Y", "N", 50, "002");
        chairs[1] = new Chair("C7492", "Task", "Y", "N", "N", "Y", 25, "003");
        chairs[2] = new Chair("C3847", "Task", "N", "Y", "Y", "N", 125, "004");
        chairs[3] = new Chair("C4893", "Task", "N", "Y", "N", "Y", 100, "002");
		chairs[4] = new Chair("C3884", "Task", "N", "Y", "N", "Y", 75, "003");

        mb.buildFurniture(chairs, 1);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"C5842", "C3884"}};
		assertTrue("A non-cheapest list of chairs was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	//Test FurnitureBuilder.java for one set of chairs
	
	public void testFurnitureBuilderChair2() {
        
        FurnitureBuilder mb = new FurnitureBuilder();

        Chair[] chairs = new Chair[5];

        chairs[0] = new Chair("C5842", "Task", "Y", "N", "Y", "N", 50, "002");
        chairs[1] = new Chair("C7492", "Task", "Y", "N", "N", "Y", 25, "003");
        chairs[2] = new Chair("C3847", "Task", "N", "Y", "Y", "N", 125, "004");
        chairs[3] = new Chair("C4893", "Task", "N", "Y", "N", "Y", 100, "002");
		chairs[4] = new Chair("C3884", "Task", "N", "Y", "N", "Y", 75, "003");

        mb.buildFurniture(chairs, 2);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"C5842", "C3884"}, {"C7492", "C3847"}};
		assertTrue("A non-cheapest list of chairs was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	//Test FurnitureBuilder.java for three sets of chairs
	
	public void testFurnitureBuilderChair3() {
        
        FurnitureBuilder mb = new FurnitureBuilder();

        Chair[] chairs = new Chair[5];

        chairs[0] = new Chair("C5842", "Task", "Y", "N", "Y", "N", 50, "002");
        chairs[1] = new Chair("C7492", "Task", "Y", "N", "N", "Y", 25, "003");
        chairs[2] = new Chair("C3847", "Task", "N", "Y", "Y", "N", 125, "004");
        chairs[3] = new Chair("C4893", "Task", "N", "Y", "N", "Y", 100, "002");
		chairs[4] = new Chair("C3884", "Task", "N", "Y", "N", "Y", 75, "003");

		assertFalse("Failed to detect that the build was impossible", mb.buildFurniture(chairs, 3));
	}
	
	@Test
	
	//Test FurnitureBuilder.java for one set of desks
	
	public void testFurnitureBuilderDesk1() {
        
        FurnitureBuilder mb = new FurnitureBuilder();

        Desk[] desks = new Desk[5];

        desks[0] = new Desk("D3456", "Standing", "Y", "N", "N", 25, "002");
        desks[1] = new Desk("D8478", "Standing", "Y", "Y", "Y", 300, "003");
        desks[2] = new Desk("D8035", "Standing", "Y", "Y", "N", 125, "004");
        desks[3] = new Desk("D0843", "Standing", "Y", "Y", "N", 100, "002");
		desks[4] = new Desk("D0693", "Standing", "N", "N", "Y", 75, "003");

        mb.buildFurniture(desks, 1);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"D0843", "D0693"}};
		assertTrue("A non-cheapest list of desks was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	//Test FurnitureBuilder.java for one set of filings
	
	public void testFurnitureBuilderFiling1() {
        
        FurnitureBuilder mb = new FurnitureBuilder();

        Filing[] filings = new Filing[5];

        filings[0] = new Filing("F023", "Small", "N", "Y", "Y", 150, "002");
        filings[1] = new Filing("F025", "Small", "Y", "Y", "Y", 300, "003");
        filings[2] = new Filing("F054", "Small", "Y", "N", "N", 50, "004");
        filings[3] = new Filing("F028", "Small", "N", "Y", "N", 50, "002");
		filings[4] = new Filing("F015", "Small", "N", "N", "Y", 50, "003");

        mb.buildFurniture(filings, 1);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"F054", "F028", "F015"}};
		assertTrue("A non-cheapest list of filings was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	//Test FurnitureBuilder.java for one set of lamps
	
	public void testFurnitureBuilderLamp1() {
        
        FurnitureBuilder mb = new FurnitureBuilder();

        Lamp[] lamps = new Lamp[5];

        lamps[0] = new Lamp("L030", "Desk", "N", "Y", 10, "002");
        lamps[1] = new Lamp("L374", "Desk", "Y", "Y", 300, "003");
        lamps[2] = new Lamp("L394", "Desk", "Y", "N", 11, "004");
        lamps[3] = new Lamp("L340", "Desk", "Y", "N", 10, "002");
		lamps[4] = new Lamp("L163", "Desk", "N", "Y", 10, "003");

        mb.buildFurniture(lamps, 1);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"L030", "L340"}};
		assertTrue("A non-cheapest list of lamps was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	//Test Management.java for Mesh Chair
	
	public void testDatabaseChair() {
        database.initializeConnection();
		String[] request = {"Mesh", "Chair"};
		database.createArray(request);
        database.toArray();
		String[] idList = new String[database.list3.length];
		for(int i = 0; i < database.list3.length; i++){
			idList[i] = database.list3[i].getId();
		}
		String[] check = {"C0942", "C6748", "C8138", "C9890"};
		assertTrue("An incorrect list of chairs was created", Arrays.equals(idList, check));
	}
	
	@Test
	
	//Test Management.java and FurnitureBuilder.java for one set of Mesh Chairs
	
	public void testDatabaseFurnitureBuilderChair() {
        database.initializeConnection();
		String[] request = {"Mesh", "Chair"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		mb.buildFurniture(database.list3, 1);
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
		assertFalse("Failed to detect that the build was impossible", mb.buildFurniture(database.list3, 1));
	}
	
	@Test
	
	//Test Management.java for Traditional Desk
	
	public void testDatabaseDesk() {
        database.initializeConnection();
		String[] request = {"Traditional", "Desk"};
		database.createArray(request);
        database.toArray();
		String[] idList = new String[database.list3.length];
		for(int i = 0; i < database.list3.length; i++){
			idList[i] = database.list3[i].getId();
		}
		String[] check = {"D0890", "D4231", "D8675", "D9352"};
		assertTrue("An incorrect list of desks was created", Arrays.equals(idList, check));
	}
	
	@Test
	
	//Test Management.java and FurnitureBuilder.java for two sets of Standing Desk
	
	public void testDatabaseFurnitureBuilderDesk() {
        database.initializeConnection();
		String[] request = {"Standing", "Desk"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		mb.buildFurniture(database.list3, 2);
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
	
	//Test Management.java for Small Filing
	
	public void testDatabaseFiling() {
        database.initializeConnection();
		String[] request = {"Small", "Filing"};
		database.createArray(request);
        database.toArray();
		String[] idList = new String[database.list3.length];
		for(int i = 0; i < database.list3.length; i++){
			idList[i] = database.list3[i].getId();
		}
		String[] check = {"F001", "F004", "F005", "F006", "F013"};
		assertTrue("An incorrect list of filings was created", Arrays.equals(idList, check));
	}
	
	@Test
	
	//Test Management.java and FurnitureBuilder.java for two sets of Large Filing
	
	public void testDatabaseFurnitureBuilderFiling() {
        database.initializeConnection();
		String[] request = {"Large", "Filing"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		mb.buildFurniture(database.list3, 2);
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
	
	//Test Management.java for Study Lamp
	
	public void testDatabaseLamp() {
        database.initializeConnection();
		String[] request = {"Study", "Lamp"};
		database.createArray(request);
        database.toArray();
		String[] idList = new String[database.list3.length];
		for(int i = 0; i < database.list3.length; i++){
			idList[i] = database.list3[i].getId();
		}
		String[] check = {"L223", "L928", "L980", "L982"};
		assertTrue("An incorrect list of lamps was created", Arrays.equals(idList, check));
	}
	
	@Test
	
	//Test Management.java and FurnitureBuilder.java for three sets of Desk Lamp
	
	public void testDatabaseFurnitureBuilderLamp() {
        database.initializeConnection();
		String[] request = {"Desk", "Lamp"};
		database.createArray(request);
        database.toArray();
		FurnitureBuilder mb = new FurnitureBuilder();
		mb.buildFurniture(database.list3, 3);
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