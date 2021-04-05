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
 * {@summary} Unit tests for the object Furinture.
 *
 */

public class UnitTestFurniture {
	
	@Test
	
	/**
	 * Creates a Chair object and test if the
	 * getter methods in Chair.java can returne
	 * the correct information on the parts
	 */
	
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
	
	/**
	 * Creates a Chair object and test if the
	 * getter methods in Furinture.java can returne
	 * the correct information on the ID, type,
	 * price and manufacture ID
	 */
	
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
	
	/**
	 * Creates a Desk object and test if the
	 * getter methods in Desk.java can returne
	 * the correct information on the parts
	 */
	
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
	
	/**
	 * Creates a Desk object and test if the
	 * getter methods in Furinture.java can returne
	 * the correct information on the ID, type,
	 * price and manufacture ID
	 */
	
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
	
	/**
	 * Creates a Filing object and test if the
	 * getter methods in Filing.java can returne
	 * the correct information on the parts
	 */

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
	
	/**
	 * Creates a Filing object and test if the
	 * getter methods in Furinture.java can returne
	 * the correct information on the ID, type,
	 * price and manufacture ID
	 */
	
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
	
	/**
	 * Creates a Lamp object and test if the
	 * getter methods in Lamp.java can returne
	 * the correct information on the parts
	 */

	public void testLampParts() {
		Lamp testLamp = new Lamp("L045", "Desk", "Y", "N", 18, "002");
		boolean[] parts = new boolean[2];
		parts[0] = testLamp.getBase();
		parts[1] = testLamp.getBulb();
		boolean[] check = {true, false};
		assertTrue("Getters in Lamp.java returned the incorrect value", Arrays.equals(parts, check));
	}
	
	@Test
	
	/**
	 * Creates a Lamp object and test if the
	 * getter methods in Furinture.java can returne
	 * the correct information on the ID, type,
	 * price and manufacture ID
	 */
	
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
}