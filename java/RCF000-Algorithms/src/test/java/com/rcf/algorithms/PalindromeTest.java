package com.rcf.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcf.algorithms.utils.solutions.Euler;

public class PalindromeTest {

    @Test
    public void testPalindromep() {
        assertEquals( true, Palindrome.palindromep( 12344321l ) );
        assertEquals( true, Palindrome.palindromep( 1234321l ) );
        assertEquals( false, Palindrome.palindromep( 12345321l ) );
        assertEquals( false, Palindrome.palindromep( 1211l ) );

    }

    @Test
    public void testCheckNumberLength() {
        assertEquals( 7, Palindrome.checkNumberLength( 1234567 ) );
        assertEquals( 1, Palindrome.checkNumberLength( 1 ) );
        assertEquals( 10, Palindrome.checkNumberLength( 9685392704l ) );
        assertEquals( 17, Palindrome.checkNumberLength( 98392750012853724l ) );
    }

    @Test
    public void testCheckNumberAt() {
        assertEquals( 1, Palindrome.checkNumberAt( 1234567, 0 ) );
        assertEquals( 2, Palindrome.checkNumberAt( 1234567, 1 ) );
        assertEquals( 3, Palindrome.checkNumberAt( 1234567, 2 ) );
        assertEquals( 4, Palindrome.checkNumberAt( 1234567, 3 ) );
        assertEquals( 5, Palindrome.checkNumberAt( 1234567, 4 ) );
        assertEquals( 6, Palindrome.checkNumberAt( 1234567, 5 ) );
        assertEquals( 7, Palindrome.checkNumberAt( 1234567, 6 ) );
    }
    
    @Test
    public void euler() {
        assertEquals( 9009, Palindrome.largestPalindromeProduct( 2 ) );
        assertEquals( Euler.p004, Palindrome.largestPalindromeProduct( 3 ) );
    }

}
