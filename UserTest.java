package edu.ucalgary.ensf409;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;
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

	/**
	 * Tests if the order form is outputed correctly with
	 * correct input
	 */
	@Test
	public void testOrderForm() throws IOException{
		FurnitureBuilder mb = new FurnitureBuilder();

        Filing[] filings = new Filing[5];

        filings[0] = new Filing("F023", "Small", "N", "Y", "Y", 150, "002");
        filings[1] = new Filing("F025", "Small", "Y", "Y", "Y", 300, "003");
        filings[2] = new Filing("F054", "Small", "Y", "N", "N", 50, "004");
        filings[3] = new Filing("F028", "Small", "N", "Y", "N", 50, "002");
		filings[4] = new Filing("F015", "Small", "N", "N", "Y", 50, "003");

        mb.buildFurniture(filings, 1);


		User.orderForm(mb);
		BufferedReader reader = null;

		String filename = "Orders/orderform1.txt";
		File form = new File(filename);
		int i = 1;
		while(form.exists()) {
			String tmp = "Orders/orderform";
			tmp += Integer.toString(i);
			tmp += ".txt";
			filename = tmp;
			i++;
			form = new File(filename);
		}
		filename = "Orders/orderform" + (i - 2) + ".txt";
		String output = "";

		try {
			reader = new BufferedReader(new FileReader(filename));
			output = "";
			String next = reader.readLine();
			while (next != null) {
				output += next + "\n";
				next = reader.readLine();
			}
			output = output.stripTrailing();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		String expected = "Furniture Order Form\n\nFaculty Name:\nContact:\nDate:\n\nOriginal Request: small filing, 1\n\nItems Ordered\nID: F054\nID: F028\nID: F015\n\nTotal Price: $150";
		assertEquals("The generated output and the expected output do not match.", expected, output);
	}

	/**
	 * Tests if the order form is outputed correctly with
	 * a furnitureBuilder that couldn't build anything. If behaviour is correct
	 * the order form will not be produced and an IllegalArguementException will occur
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testOrderFormWithBlankList() throws IOException{
		FurnitureBuilder mb = new FurnitureBuilder();

        Filing[] filings = new Filing[5];

        filings[0] = new Filing("F023", "Small", "N", "Y", "Y", 150, "002");
        filings[1] = new Filing("F025", "Small", "Y", "Y", "Y", 300, "003");
        filings[2] = new Filing("F054", "Small", "Y", "N", "N", 50, "004");
        filings[3] = new Filing("F028", "Small", "N", "Y", "N", 50, "002");
		filings[4] = new Filing("F015", "Small", "N", "N", "Y", 50, "003");

        mb.buildFurniture(filings, 20);


		User.orderForm(mb);

	}
}

