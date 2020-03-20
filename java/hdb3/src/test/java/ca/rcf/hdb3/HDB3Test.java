/**
 * 
 */
package ca.rcf.hdb3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author rflec028
 *
 */
public class HDB3Test {

	/**
	 * Test method for {@link ca.rcf.hdb3.HDB3#rawHDB3encode(java.lang.String)}.
	 */
	@Test
	public void testRawHDB3encode() {
		assertEquals("+0−000−0+−+00+−+−00−000+",HDB3.rawHDB3encode("101000001100001100000001"));
	}

	/**
	 * Test method for {@link ca.rcf.hdb3.HDB3#rawHDB3decode(java.lang.String)}.
	 */
	@Test
	public void testRawHDB3decode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.rcf.hdb3.HDB3#encode(java.lang.String)}.
	 */
	@Test
	public void testEncode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.rcf.hdb3.HDB3#decode(java.lang.String)}.
	 */
	@Test
	public void testDecode() {
		fail("Not yet implemented");
	}

}
