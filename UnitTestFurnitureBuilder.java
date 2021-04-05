package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/**
 * 
 * @author Tyler Galea
 * @since April 5, 2021
 * @version 1.1
 * {@summary} Unit tests for the functionality of FurintureBuilde.java.
 *
 */

public class UnitTestFurnitureBuilder {

	@Test
	
	/**
	 * Creates a ArrayList of Chair objects and test if
	 * FurnitureBuilder.java can return the cheapest combination
	 * of chairs that can successfully create 1 chair of
	 * the specified type
	 */
	
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
	
	/**
	 * Creates a ArrayList of Chair objects and test if
	 * FurnitureBuilder.java list can return the cheapest combination
	 * of chairs that can successfully create 2 chairs of
	 * the specified type
	 */
	
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
	
	/**
	 * Creates a ArrayList of Chair objects and test if
	 * FurnitureBuilder.java can detect that it is impossible
	 * to create 3 chairs of the specified type
	 */
	
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
	
	/**
	 * Creates a ArrayList of Desk objects and test if
	 * FurnitureBuilder.java can return the cheapest combination
	 * of desks that can successfully create 1 desk of
	 * the specified type
	 */
	
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
	
	/**
	 * Creates a ArrayList of Filing objects and test if
	 * FurnitureBuilder.java can return the cheapest combination
	 * of filings that can successfully create 1 filing of
	 * the specified type
	 */
	
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
	
	/**
	 * Creates a ArrayList of Lamp objects and test if
	 * FurnitureBuilder.java can return the cheapest combination
	 * of lamps that can successfully create 1 lamp of
	 * the specified type
	 */
	
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
}