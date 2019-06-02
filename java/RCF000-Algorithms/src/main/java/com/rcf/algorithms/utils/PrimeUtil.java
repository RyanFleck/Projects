/**
 * Utility library for handling prime numbers. Functions mostly ported from
 * https://github.com/RyanFleck/Projects/blob/master/js/rcf022_PrimeLib.js
 */
package com.rcf.algorithms.utils;

import java.util.ArrayList;

/**
 * Read about the fundamental theorem of arithmetic here, perhaps all of these
 * methods need to be rewritten to take advantage of this theorem:
 * https://www.mathsisfun.com/numbers/fundamental-theorem-arithmetic.html
 * 
 * @author Ryan Fleck
 */
public class PrimeUtil {

    /**
     * Produces integer array of positive primes up to ceiling value.
     * 
     * @param ceil Upper integer limit for the list of primes.
     * @return List of prime numbers up to ceiling value as integers.
     */
    public static int[] upTo( int ceil ) {

        ArrayList<Integer> primes = new ArrayList<Integer>();
        if ( ceil >= 3 ) {
            primes.add( (int) 2 );
        } else {
            return new int[] {};
        }
        for ( int x = 3; x < ceil; x += 2 ) {
            if ( primep( x ) )
                primes.add( x );
        }
        return ArrayUtil.toIntArray( primes );
    }

    /**
     * Brute force primality test.
     * 
     * @param a Number to apply primality test to.
     * @return Boolean with result of primality test.
     */
    public static boolean primep( int a ) {
        int limit = (int) Math.sqrt( a ) + 1;
        for ( int x = 2; x < limit; x++ ) {
            if ( a % x == 0 )
                return false;
        }
        return true;
    }

    /**
     * Brute force primality test. Uses longs. Re-implement with generics?
     * 
     * @param a Number to apply primality test to.
     * @return Boolean with result of primality test.
     */
    public static boolean primep( long a ) {
        int limit = (int) Math.sqrt( a ) + 1;
        for ( long x = 2; x < limit; x++ ) {
            if ( a % x == 0 )
                return false;
        }
        return true;
    }

    /**
     * Answers 'is A a factor of B?' with a boolean.
     * 
     * @param a Smaller number, may be a factor of B.
     * @param b Larger number, checks if A is a factor.
     * @return If A is a factor of B, returns true.
     */
    public static boolean factorp( int a, int b ) {
        return ( b % a == 0 ) ? true : false;
    }

    /**
     * Answers 'is A a factor of B?' with a boolean. Takes longs.
     * 
     * @param a Smaller number, may be a factor of B.
     * @param b Larger number, checks if A is a factor.
     * @return If A is a factor of B, returns true.
     */
    public static boolean factorp( long a, long b ) {
        return ( b % a == 0 ) ? true : false;
    }

    /**
     * Sums prime numbers up to the provided ceiling.
     * 
     * @param ceil Limit for value of primes in sum.
     * @return Sum of primes below ceil.
     */
    public static int sum( int ceil ) {
        return sumRange( 0, ceil );
    }

    /**
     * Sums prime numbers within a given range. Brute force method.
     * 
     * @param floor Lower limit for value of prime numbers. Minimum 2.
     * @param ceil  Upper limit for value of prime numbers. Minimum floor + 1.
     * @return Integer result of sum.
     */
    public static int sumRange( int floor, int ceil ) {

        int sum = 0;

        floor = lowerLimit( floor, 2 );
        ceil = lowerLimit( ceil, floor + 1 );

        // Check if lower limit is even, then if prime.
        if ( floor % 2 == 0 ) {
            if ( primep( floor ) )
                sum += floor;

            floor++;
        }

        for ( int x = floor; x < ceil; x += 2 ) {
            if ( primep( x ) ) {
                sum += x;
            }
        }

        return sum;
    }

    private static int lowerLimit( int input, int lowerBound ) {
        return ( input < lowerBound ) ? lowerBound : input;
    }

}
