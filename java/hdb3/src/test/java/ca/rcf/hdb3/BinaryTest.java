/**
 * 
 */
package ca.rcf.hdb3;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.rcf.hdb3.conversion.Binary;

/**
 * @author rflec028
 *
 */
public class BinaryTest {

	/**
	 * Test method for {@link ca.rcf.hdb3.conversion.Binary#encode(java.lang.String)}.
	 */
	@Test
	public void testEncode() {
		assertEquals("0110100001100101011011000110110001101111", Binary.encode("hello"));
		assertEquals("01110100011001010111001101110100", Binary.encode("test"));
		assertEquals("01100001011000100110001100100000001100010011001000110011", Binary.encode("abc 123"));

	}

	/**
	 * Test method for {@link ca.rcf.hdb3.conversion.Binary#decode(java.lang.String)}.
	 */
	@Test
	public void testDecode() {
		// pass("Not yet implemented");
		assertEquals("hello", Binary.decode("0110100001100101011011000110110001101111"));
		assertEquals("test", Binary.decode("01110100011001010111001101110100"));
		assertEquals("abc 123", Binary.decode("01100001011000100110001100100000001100010011001000110011"));

	}
	
	// @Test
	public void testAintegratedTest() {
		assertEquals("hello", Binary.decode(Binary.encode("hello")));
		assertEquals("abc 123", Binary.decode(Binary.encode("abc 123")));
		assertEquals("test", Binary.decode(Binary.encode("test")));
		
	}

}
