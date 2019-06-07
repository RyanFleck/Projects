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
    
    @Test
    public void testSmallestMultipleRange() {
        assertEquals( 2520, Multiples.smallestMultipleRange( 10 ));
    }
    
    @Test
    public void testDetermineStep() {
        assertEquals( 210l, Multiples.determineRangeStep( 10 ));
        assertEquals( 9699690l, Multiples.determineRangeStep( 20 ));
        assertEquals( 6469693230l, Multiples.determineRangeStep( 30 ));
    }
    
    @Test
    public void testEuler005() {
        assertEquals( Euler.p005, Multiples.smallestMultipleRange( 20 ));
    }

}
