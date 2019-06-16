package com.rcf.algorithms;

import static com.rcf.algorithms.utils.PrimeUtil.*;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 */

/**
 * @author Ryan Fleck
 * @since 0.0.3
 */
public class PrimeFactor {

    /**
     * Counts backwards from the square root of the ceil to determine the largest
     * prime factor. Not a good solution, need to find a proper way to build and
     * recurse through a full tree of factors.
     * 
     * @param ceil
     * @return
     */
    public static long largestPrimeFactor( long ceil ) {

        long max = (long) Math.sqrt( ceil ) + 1;
        long first = 0;

        for ( double x = 2; x < max; x++ ) {
            double check = ceil / x;
            if ( wholep( check ) ) {
                long checkl = (long) check;
                if ( first == 0 )
                    first = checkl;
                if ( factorp( checkl, ceil ) && primep( checkl ) ) {
                    return checkl;
                }
            }
        }

        return largestPrimeFactor( first );
    }

    /**
     * Counts backwards from the square root of the ceil to determine the largest
     * prime factor. This first attempt is a failure, as it only processes all of
     * the whole factors of ceil. Reattempt soon.
     * 
     * @param ceil
     * @return
     */
    @Deprecated
    public static long largestPrimeFactorV1( long ceil ) {

        long max = (long) Math.sqrt( ceil ) + 1;

        for ( double x = 1; x < max; x++ ) {
            double check = ceil / x;
            if ( wholep( check ) ) {
                long checkl = (long) check;
                if ( factorp( checkl, ceil ) && primep( checkl ) ) {
                    return checkl;
                }
            }
        }

        return 0;
    }

    private static boolean wholep( double x ) {
        return ( x % 1 == 0.0 ) ? true : false;
    }
}
