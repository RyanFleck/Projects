/**
 * 
 */
package com.rcf.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author rflec028
 *
 */
public class TestMethods extends TestCase {

	/**
	 * @param name
	 */
	public TestMethods(String name) {
		super(name);
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void jUnitFunctional() throws Exception{
		System.out.println("4 Running test...");
		assertTrue( true );
	}
	
	public void testJUnitMethod() throws Exception{
		System.out.println("5 Running test...");
		assertTrue(App.jUnitTest());
	}
	
	public void thisShouldFail() throws Exception{
		System.out.println("6 Running test...");
		assertTrue( false );
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
