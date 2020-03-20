/**
 * 
 */
package ca.rcf.hdb3;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.rcf.hdb3.conversion.HDB3;

/**
 * @author rflec028
 *
 */
public class HDB3Test {

	/**
	 * Test method for {@link ca.rcf.hdb3.conversion.HDB3#binaryHDB3encode(java.lang.String)}.
	 */
	@Test
	public void testRawHDB3encode() {
		
		/*
		 * Of the four test cases from Wikipedia, two don't make sense to me.
		 * https://en.wikipedia.org/wiki/Modified_AMI_code
		 */
		
		assertEquals("+0-000-0+-+00+-+-00-000+", HDB3.binaryHDB3encode("101000001100001100000001"));
		assertEquals("+0-000-+000+-+-00-+-+000+-+-+-00-+0-+00+",HDB3.binaryHDB3encode("1010000100001100001110000111100001010000"));
		
		// assertEquals("+-00-+00+00",HDB3.rawHDB3encode("10000000000"));
		// assertEquals("+000+-+0", HDB3.rawHDB3encode("10000110"));
	}

	/**
	 * Test method for {@link ca.rcf.hdb3.conversion.HDB3#binaryHDB3decode(java.lang.String)}.
	 */
	@Test
	public void testRawHDB3decode() {
		// fail("Not yet implemented");
		assertEquals("00101000001100001100000001", HDB3.binaryHDB3decode("00+0-000-0+-+00+-+-00-000+"));
		assertEquals("001010000100001100001110000111100001010000",HDB3.binaryHDB3decode("00+0-000-+000+-+-00-+-+000+-+-+-00-+0-+00+"));
		
	}

	/**
	 * Test method for {@link ca.rcf.hdb3.conversion.HDB3#encode(java.lang.String)}.
	 */
	@Test
	public void testEncode() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.rcf.hdb3.conversion.HDB3#decode(java.lang.String)}.
	 */
	@Test
	public void testDecode() {
		// fail("Not yet implemented");
	}

}
