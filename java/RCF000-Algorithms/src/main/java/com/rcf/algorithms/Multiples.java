package com.rcf.algorithms;

/*
 * Multiples of 3 and 5 Problem 1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 */

/**
 * @author Ryan Fleck
 */
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
}
