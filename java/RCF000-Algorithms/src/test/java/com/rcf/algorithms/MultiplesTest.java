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
        assertEquals( 2520, Multiples.smallestMultipleRange( 10 ) );
    }

    @Test
    public void testDetermineStep() {
        assertEquals( 210l, Multiples.determineRangeStep( 10 ) );
        assertEquals( 9699690l, Multiples.determineRangeStep( 20 ) );
        assertEquals( 6469693230l, Multiples.determineRangeStep( 30 ) );
    }

    @Test
    public void testSumOfNaturalRange() {
        assertEquals( 362880, Multiples.productOfNaturalRange( 10 ) );
    }

    @Test
    public void testSumOfSquares() {
        assertEquals( 385, Multiples.sumOfSquares( 10 ) );
        assertEquals( 338350l, Multiples.sumOfSquares( 100 ) );
    }
    
    @Test
    public void testSquareOfSums() {
        assertEquals( 3025, Multiples.squareOfSums( 10 ));
        assertEquals( 25502500l, Multiples.squareOfSums( 100 ));
    }

    @Test
    public void testNaturalRangeDifference() {
        assertEquals( 2640, Multiples.naturalRangeDifference( 10 ) );

    }

    @Test
    public void testEuler005() {
        assertEquals( Euler.p005, Multiples.smallestMultipleRange( 20 ) );
    }
    
    @Test
    public void testEuler006() {
        assertEquals( Euler.p006, Multiples.naturalRangeDifference( 100 ) );

    }

}
