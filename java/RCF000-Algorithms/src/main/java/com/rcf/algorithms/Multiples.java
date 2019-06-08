package com.rcf.algorithms;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 */
import static com.rcf.algorithms.utils.PrimeUtil.factorp;
import static com.rcf.algorithms.utils.PrimeUtil.primep;

import java.util.stream.LongStream;

public class Multiples {

    /**
     * @param a    First multiple.
     * @param b    Second multiple.
     * @param ceil All multiples below this number will be returned.
     * @return
     */
    public static int sumTwoMultiplesBelow( int a, int b, int ceil ) {

        byte[] used = new byte[ceil];
        int sum = 0;
        int currentA = a;
        int currentB = b;

        while ( currentA < ceil ) {
            sum += currentA;
            used[currentA] = 1;
            currentA += a;
        }

        while ( currentB < ceil ) {
            if ( used[currentB] == 0 ) {
                sum += currentB;
            }
            currentB += b;
        }

        return sum;
    }

    /**
     * 2520 is the smallest number that can be divided by each of the numbers from 1
     * to 10 without any remainder. What is the smallest positive number that is
     * evenly divisible by all of the numbers from 1 to 20?
     * 
     * @param target End of range, from one to (specified number).
     * @return Smallest number that can be cleanly divided by all numbers below
     *         (target).
     */
    public static long smallestMultipleRange( long target ) {
        long step = determineRangeStep( target );
        // Wow, check this out:
        long max = LongStream.range( 1, target ).reduce( ( x, y ) -> x * y ).getAsLong();
        long[] divisors = LongStream.range( 1, target ).filter( x -> !primep( x ) ).toArray();

        for ( long x = step; x < max; x += step ) {
            // Testing to see if this number is divisible by the remaining numbers.
            boolean ans = true;
            innerloop: for ( long y : divisors ) {
                if ( !factorp( y, x ) ) {
                    ans = false;
                    break innerloop; // Gotta be a better way to do this.
                }
            }

            if ( ans )
                return x;
        }

        return 0;
    }

    /**
     * Leverages the fundamental theory of arithmetic to find the multiple of all
     * primes in the multiple-range, which will be multiplied by another number to
     * determine the smallest common multiple of all numbers in target range.
     * 
     * @param target
     * @return
     */
    public static long determineRangeStep( long target ) {
        long step = 1l;
        for ( long x = 1; x < target; x++ ) {
            if ( primep( x ) )
                step *= x;
        }
        return step;
    }

    /**
     * @param target Numbers from 1 to (target) will be multiplied.
     * @return The product of all numbers between 1 and (target).
     */
    public static long productOfNaturalRange( long target ) {
        return LongStream.range( 1, target ).reduce( ( x, y ) -> x * y ).getAsLong();
    }

    /**
     * Finds the difference between the sum of the squares of the first (range of
     * digits) and the square of the sum.
     * 
     * @param target
     * @return
     */
    public static long naturalRangeDifference( long target ) {
        return squareOfSums( target ) - sumOfSquares( target );
    }

    /**
     * Provides the sum of numbers 1 through target when numbers are squared.
     * 
     * @param target
     * @return
     */
    public static long sumOfSquares( long target ) {
        return LongStream.range( 1, ( target + 1 ) ).reduce( ( x, y ) -> x + ( y * y ) ).getAsLong();
    }

    /**
     * Provides the square of the product of numbers 1 through target.
     * 
     * @param target
     * @return
     */
    public static long squareOfSums( long target ) {
        return square( LongStream.range( 1, ( target + 1 ) ).reduce( ( x, y ) -> x + y ).getAsLong() );
    }

    private static long square( long x ) {
        return x * x;
    }

}
