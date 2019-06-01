package com.rcf.hello;

import static com.rcf.hello.Main.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void testGetSetHelloMessage() {
		// AssertEquals takes ( expected, actual )
		String testString = "Hm, this should work...";
		// Hello, World is default, should be unaltered at this point.
		assertEquals("Hello, World!", getHelloMessage());
		setHelloMessage(testString);
		assertEquals(testString, getHelloMessage());
	}

}
