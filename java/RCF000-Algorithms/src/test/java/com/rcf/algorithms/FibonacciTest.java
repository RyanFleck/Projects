package com.rcf.algorithms;

import static org.junit.Assert.*;
import com.rcf.algorithms.utils.ArrayUtil;
import com.rcf.algorithms.utils.solutions.Euler;

import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testGenerateTo() {
        assertArrayEquals( new int[] { 0, 1, 1, 2, 3, 5 }, Fibonacci.generateTo( 7 ) );
        assertArrayEquals( new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 }, Fibonacci.generateTo( 90 ) );

    }

    @Test
    public void testGenerateToEven() {
        assertArrayEquals( new int[] { 0, 2 }, Fibonacci.generateToEven( 7 ) );
    }

    @Test
    public void testEuler002() {
        assertEquals( Euler.p002, ArrayUtil.sum( Fibonacci.generateToEven( 4000000 ) ) );
    }

}
