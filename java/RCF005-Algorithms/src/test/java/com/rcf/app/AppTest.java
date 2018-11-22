package com.rcf.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void jUnitFunctional() throws Exception{
		System.out.println("1 Running test...");
		assertTrue( true );
	}
	
	public void testJUnitMethod() throws Exception{
		System.out.println("2 Running test...");
		assertTrue(App.jUnitTest());
	}
	
	public void thisShouldFail() throws Exception{
		System.out.println("3 Running test...");
		assertTrue( false );
	}
}
