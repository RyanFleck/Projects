package com.rcf.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplesTest {

	@Test
	public void testFindMultiples() {
		assertEquals(23, Multiples.sumTwoMultiplesBelow(3,5,10));
		assertEquals(233168, Multiples.sumTwoMultiplesBelow(3,5,1000));
	}

}
