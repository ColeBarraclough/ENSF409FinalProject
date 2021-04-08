package edu.ucalgary.ensf409;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea, Cole Barraclough
 * @since March 27, 2021
 * @version 1.0
 * {@summary} This class takes in the user input for 
 * a) furnitrure category b)its type c) the number of items requested
 * 
 * This class test all of the functionality in the User class
 *
 */

public class UserTest {

	/**
	 * Test to see if the string is properly formatted
	 * in this case random capitalization in the string
	 */

	@Test
	public void testFormatString0() {
		String tester = "TeSt FunCtiOn";
		tester = User.formatString(tester);
		assertEquals( "Test Function ", tester);
	}

	/**
	 * Test to see if the string is properly formatted
	 * in this case all capitalization in the string
	 */
	@Test
	public void testFormatString1() {
		String tester = "TEST FUNCTION";
		tester = User.formatString(tester);
		assertEquals( "Test Function ", tester);
	}

	/**
	 * Test to see if the string is properly formatted
	 * in this case all lower case in the string
	 */
	@Test
	public void testFormatString2() {
		String tester = "test function";
		tester = User.formatString(tester);
		assertEquals( "Test Function ", tester);
	}

	/**
	 * Test the isAplha function to see and this
	 * should be true
	 */
	@Test
	public void testIsAlpha0() {
		String tester = "TeSt FunCtiOn";
		boolean val = User.isAlpha(tester);
		assertEquals( true, val);
	}

	/**
	 * Test the isAplha function to see and this
	 * should be true
	 */
	@Test
	public void testIsAlpha1() {
		String tester = "SingleWord";
		boolean val = User.isAlpha(tester);
		assertEquals( true, val);
	}

	/**
	 * Test the isAplha function to see and this
	 * should be false
	 */
	@Test
	public void testIsAlpha2() {
		String tester = "NotValid1";
		boolean val = User.isAlpha(tester);
		assertEquals( false, val);
	}

	/**
	 * Test the isAplha function to see and this
	 * should be false
	 */
	@Test
	public void testIsAlpha4() {
		String tester = "NotValid~";
		boolean val = User.isAlpha(tester);
		assertEquals( false, val);
	}

	/**
	 * Test the isAplha function to see and this
	 * should be true
	 */
	@Test
	public void testIsAlpha3() {
		String tester = " ";
		boolean val = User.isAlpha(tester);
		assertEquals( true, val);
	}
}
