package com.rcf.algorithms.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayUtilTest {

    @Test
    public void testSum() {
        assertEquals( 10, ArrayUtil.sum( new int[] { 1, 2, 3, 4 } ) );
        assertEquals( -2, ArrayUtil.sum( new int[] { 1, -2, 3, -4 } ) );
        assertEquals( -2, ArrayUtil.sum( new int[] { 1, -2, 3, -4 } ) );
    }

    @Test
    public void testSumFloat() {
        assertEquals( 10.0, ArrayUtil.sum( new double[] { 1.0, 2.0, 3.0, 4.0 } ), 0.0000001 );
        assertEquals( 12.201398, ArrayUtil.sum( new double[] { 1.52345, 2.984598, 3.234, 4.45935 } ), 0.0000001 );
    }

    @Test
    public void testToIntArray() {
        
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add( 1 );
        x.add( 2 );
        x.add( 3 );
        
        assertArrayEquals( new int[] { 1, 2, 3 }, ArrayUtil.toIntArray( x ) );
    }

}
