package com.rcf.algorithms;

import static org.junit.Assert.*;
import com.rcf.algorithms.utils.solutions.Euler;

import org.junit.Test;

public class PrimeFactorTest {

    @Test
    public void testLargestPrimeFactor() {
        assertEquals( 3, PrimeFactor.largestPrimeFactor( 9 ) );
        assertEquals( 31, PrimeFactor.largestPrimeFactor( 62 ) );
        assertEquals( 977, PrimeFactor.largestPrimeFactor( 16609 ) );
    }

    @Test
    public void euler003() {
        assertEquals( Euler.p003, PrimeFactor.largestPrimeFactor( 600851475143l ) );
    }

}
