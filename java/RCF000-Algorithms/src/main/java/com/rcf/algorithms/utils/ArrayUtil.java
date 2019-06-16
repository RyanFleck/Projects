package com.rcf.algorithms.utils;

import java.util.ArrayList;

/**
 * @author Ryan Fleck
 * @since 0.0.3
 */
public class ArrayUtil {

    /*
     * Find a way to combine these two methods: too much shared code in sum(int[])
     * and sum(double[])
     */

    /**
     * @param arr Array of integers.
     * @return The sum of all integers in the array.
     */
    public static int sum( int[] arr ) {
        int arr_len = arr.length;
        int counter = 0;
        for ( int x = 0; x < arr_len; x++ )
            counter += arr[x];

        return (int) counter;
    }

    /**
     * @param arr Array of doubles.
     * @return The sum of all items in the array, as a double.
     */
    public static double sum( double[] arr ) {
        int arr_len = arr.length;
        double counter = (double) 0.0;
        for ( int x = 0; x < arr_len; x++ )
            counter += arr[x];

        return (double) counter;
    }

    /**
     * Converts an Integer ArrayList to an Array of type int
     * 
     * @param a The ingested ArrayList.
     * @return Int array of equal length, using int primitives.
     */
    public static int[] toIntArray( ArrayList<Integer> a ) {
        int[] returnedArray = new int[a.size()];
        for ( int x = 0; x < a.size(); x++ ) {
            returnedArray[x] = a.get( x );
        }
        return returnedArray;
    }

    /**
     * Converts an Long ArrayList to an Array of type int
     * 
     * @param a The ingested ArrayList.
     * @return Int array of equal length, using int primitives.
     */
    public static long[] toLongArray( ArrayList<Long> a ) {
        long[] returnedArray = new long[a.size()];
        for ( int x = 0; x < a.size(); x++ ) {
            returnedArray[x] = a.get( x );
        }
        return returnedArray;
    }

}
