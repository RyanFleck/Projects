package com.rcf.algorithms.utils;

import java.util.ArrayList;

public class Array {

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

}
