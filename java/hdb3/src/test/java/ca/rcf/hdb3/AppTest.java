package ca.rcf.hdb3;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	public void testIsBinary() {
		
		assertTrue(App.isBinary("1010111000010100010001000101010"));
		assertTrue(App.isBinary("101"));
		
		assertTrue(!App.isBinary("lol"));
		assertTrue(!App.isBinary("01010010010000010011a"));
		assertTrue(!App.isBinary("00201000100100010010"));
	}

}
