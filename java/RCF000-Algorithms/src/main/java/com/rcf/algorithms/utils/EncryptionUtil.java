package com.rcf.algorithms.utils;

import java.math.BigDecimal;

import org.jasypt.util.numeric.BasicDecimalNumberEncryptor;

/**
 * @author Ryan Fleck
 * @since 0.0.4
 */
public class EncryptionUtil {

    private BasicDecimalNumberEncryptor encryptor;

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        EncryptionUtil eu = new EncryptionUtil();

        if ( args.length <= 0 ) {
            System.out.println( "Please provide an argument for the encryption tool." );
            System.exit( 1 );
        }

        System.out.println( eu.encrypt( Long.valueOf( args[0] ) ) );

    }

    public EncryptionUtil() {
        this.encryptor = new BasicDecimalNumberEncryptor();
        // Set in /etc/environment (this is not exactly a security-critical key)
        System.out.println( "Friendly reminder that encryption key is '" + System.getenv( "ALGO_PASS" ) + "'." );
        encryptor.setPassword( System.getenv( "ALGO_PASS" ) );
    }

    public BigDecimal encrypt( long x ) {
        return encryptor.encrypt( BigDecimal.valueOf( Long.valueOf( x ) ) );
    }

    public long decrypt( BigDecimal x ) {
        return encryptor.decrypt( x ).longValue();
    }

    public int decrypti( BigDecimal x ) {
        return (int) encryptor.decrypt( x ).longValue();
    }

}
