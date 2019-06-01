package com.rcf.algorithms;

import static com.rcf.algorithms.Main.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

    @Test
    public void testGetSetHelloMessage() {
        // AssertEquals takes ( expected, actual )
        String testString = "Hm, this should work...";
        // Hello, World is default, should be unaltered at this point.
        assertEquals( "Hello, World!", getHelloMessage() );
        setHelloMessage( testString );
        assertEquals( testString, getHelloMessage() );
    }

}
