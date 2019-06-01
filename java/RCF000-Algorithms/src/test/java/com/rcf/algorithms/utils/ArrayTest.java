package com.rcf.algorithms.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest {

	@Test
	public void testSum() {
		assertEquals(10, Array.sum(new int[] { 1, 2, 3, 4 }));
		assertEquals(-2, Array.sum(new int[] { 1, -2, 3, -4 }));
		assertEquals(-2, Array.sum(new int[] { 1, -2, 3, -4 }));
	}

	@Test
	public void testSumFloat() {
		assertEquals(10.0, Array.sum(new double[] { 1.0, 2.0, 3.0, 4.0 }), 0.0000001);
		assertEquals(12.201398, Array.sum(new double[] { 1.52345, 2.984598, 3.234, 4.45935 }), 0.0000001);
	}

}
