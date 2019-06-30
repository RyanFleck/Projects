package com.rcf.algorithms.utils.solutions;

/**
 * Spoiler Alert! These are the final solutions for Project Euler problems. The
 * solutions to more difficult problems, along with the answers, are not listed
 * in this repository. Generally, if your solution continues to run for more
 * than a short while, you've done it wrong.
 */

import com.rcf.algorithms.utils.EncryptionUtil;

import java.math.BigDecimal;

/**
 * @author Ryan Fleck
 * @category Restricted
 * @since 0.0.1
 * @see site/ALGO_KEY
 */
public class Euler {
    public static final EncryptionUtil x = new EncryptionUtil();

    // Hooray for light encryption. Reminder that all unit tests will fail with incorrect key.
    public static final int p001 = x.decrypti( new BigDecimal( "-64681746081878680182312117442505712475123482608" ) );
    public static final int p002 = x.decrypti( new BigDecimal( "623888384613689165347418993922157640744418934800" ) );
    public static final long p003 = x.decrypt( new BigDecimal( "311304093592878841323040399204522556299266752528" ) );
    public static final long p004 = x.decrypt( new BigDecimal( "-606776993557810851371750593881793618991481094128" ) );
    public static final long p005 = x.decrypt( new BigDecimal( "100623801086305193835044367501971251782274252816" ) );
    public static final long p006 = x.decrypt( new BigDecimal( "354311619593123323547013772237766168882391810064" ) );
}
