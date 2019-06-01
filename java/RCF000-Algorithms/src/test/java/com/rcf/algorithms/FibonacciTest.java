package com.rcf.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testGenerateTo() {
        assertArrayEquals( new int[] { 0, 1, 1, 2, 3, 5 }, Fibonacci.generateTo( 7 ) );
        assertArrayEquals( new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 }, Fibonacci.generateTo( 90 ) );
        
    }

}
