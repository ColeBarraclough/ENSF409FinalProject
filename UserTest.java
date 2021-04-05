package edu.ucalgary.ensf409;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	public void testFormatString0() {
		String tester = "TeSt FunCtiOn";
		tester = User.formatString(tester);
		assertEquals( "Test Function ", tester);
	}
	@Test
	public void testFormatString1() {
		String tester = "TEST FUNCTION";
		tester = User.formatString(tester);
		assertEquals( "Test Function ", tester);
	}
	@Test
	public void testFormatString2() {
		String tester = "test function";
		tester = User.formatString(tester);
		assertEquals( "Test Function ", tester);
	}
	@Test
	public void testIsAlpha0() {
		String tester = "TeSt FunCtiOn";
		boolean val = User.isAlpha(tester);
		assertEquals( true, val);
	}
	@Test
	public void testIsAlpha1() {
		String tester = "SingleWord";
		boolean val = User.isAlpha(tester);
		assertEquals( true, val);
	}
	@Test
	public void testIsAlpha2() {
		String tester = "NotValid1";
		boolean val = User.isAlpha(tester);
		assertEquals( false, val);
	}
	@Test
	public void testIsAlpha4() {
		String tester = "NotValid~";
		boolean val = User.isAlpha(tester);
		assertEquals( false, val);
	}
	@Test
	public void testIsAlpha3() {
		String tester = " ";
		boolean val = User.isAlpha(tester);
		assertEquals( true, val);
	}
}
