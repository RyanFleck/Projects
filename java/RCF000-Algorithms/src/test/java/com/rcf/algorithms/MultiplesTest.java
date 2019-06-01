package com.rcf.algorithms;

import static org.junit.Assert.*;
import com.rcf.algorithms.utils.solutions.Euler;

import org.junit.Test;

public class MultiplesTest {

    @Test
    public void testFindMultiples() {
        assertEquals( 23, Multiples.sumTwoMultiplesBelow( 3, 5, 10 ) );
    }

    @Test
    public void testEuler001() {
        assertEquals( Euler.p001, Multiples.sumTwoMultiplesBelow( 3, 5, 1000 ) );
    }

}
