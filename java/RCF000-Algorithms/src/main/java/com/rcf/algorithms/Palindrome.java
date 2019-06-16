/**
 * 
 */
package com.rcf.algorithms;

import java.util.ArrayList;
import java.util.Collections;

/*
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

/**
 * @author Ryan Fleck
 * @since 0.0.3
 */
public class Palindrome {

    public static long largestPalindromeProduct( int len ) {
        ArrayList<Long> ans = new ArrayList<Long>();
        long upperlimit = (long) ( Math.pow( 10, len ) - 1 );
        long lowerlimit = (long) ( Math.pow( 10, len - 1 ) - 1 );

        // Safest strategy is to multiply every number by all numbers equal to or above.
        // Probably a place far above the lower limit where the search can be stopped.

        for ( long x = upperlimit; x > lowerlimit; x-- ) {
            for ( long y = upperlimit; y >= x; y-- ) {
                long res = y * x;
                if ( palindromep( res ) )
                    ans.add( res );
            }
        }

        Collections.sort( ans );
        return ans.get( ans.size() - 1 );
    }

    /**
     * Checks if the given value is a palindrome.
     * 
     * @return Boolean value true if number is a palindrome.
     */
    public static boolean palindromep( long number ) {
        long numLen = checkNumberLength( number );
        for ( int x = 0; x < ( numLen / 2 ); x++ ) {
            if ( checkNumberAt( number, x ) != checkNumberAt( number, ( numLen - 1 - x ) ) ) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param number
     * @return Length of the number.
     */
    public static long checkNumberLength( long number ) {
        int count = 0;
        while ( number != 0 ) {
            number = number / 10l;
            count++;
        }
        return (long) count;
    }

    /**
     * Look ma, no arrays! I was asked a question very similar to this in C during
     * an interview for a division of a bigCo that worked on VMs and compilers.
     * 
     * @param number Value to process.
     * @param indice Indice to check.
     * @return Number at indice of given long value.
     */
    public static int checkNumberAt( long number, long indice ) {
        long revIndice = checkNumberLength( number ) - 1 - indice;
        return (int) ( dxp( number, revIndice ) - ( dxp( number, revIndice + 1 ) * 10 ) );
    }

    private static long dxp( long number, long indice ) {
        return (long) ( number / Math.pow( 10, indice ) );
    }
}
