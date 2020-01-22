package Math;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version 3.6.4
 * @since 20 JULY 2018
 */

public class frac
{   final int numerator, denominator;
    /**
    * @author Chase P. Miller
    * @version Version 1.2.1
    * @since 20 JULY 2018
    * @param num the numerator
    * @param denom the denominator
    * @return frac object
    * Constructor
    */
    frac(int num, int denom)
    {   int gcm = gcm(num, denom);
        numerator = (num / gcm);
        denominator = (denom / gcm);
    }
    
    /**
    * @author Chase P. Miller
    * @version Version 1.0.1
    * @since 20 JULY 2018
    * @param a the first denominator
    * @param b the second denominator
    * @return greatest common multiple of two parameters
    * used to create common fractions
    */
    private static int gcm(int a, int b)
    {   return b == 0 ? a : gcm(b, a % b);
    }
    
    /**
    * @author Chase P. Miller
    * @version Version 1.0.0
    * @since 20 JULY 2018
    * @return String description of fraction
    * creates description of frac object
    */
    public String toString()
    {   return denominator < 0 ? -numerator + "/" + -denominator : numerator + "/" + denominator;
    }
    
    /**
    * @author Chase P. Miller
    * @version Version 1.0.0
    * @since 20 JULY 2018
    * @return wether the fraction is positive or negative
    * tells if fraction positive or negative
    */
    boolean isNegative()
    {   return numerator < 0 || denominator < 0;
    }
    
    /**
    * @author Chase P. Miller
    * @version Version 1.3.2
    * @since 20 JULY 2018
    * @param a the second fraction
    * @return sum of fractions
    * adds two fractions
    */
    frac add(frac a)
    {   int denom = denominator * a.denominator;
        int num = numerator * a.denominator + denominator * a.numerator;
        return new frac(num, denom);
    }
    
    /**
    * @author Chase P. Miller
    * @version Version 1.2.0
    * @since 20 JULY 2018
    * @param a the second fraction
    * @return difference of fractions
    * subtracts two fractions
    */
    frac subtract(frac a)
    {   int denom = denominator * a.denominator;
        int num = numerator * a.denominator - denominator * a.numerator;
        return new frac(num, denom);
    }
    
    /**
    * @author Chase P. Miller
    * @version Version 1.1.0
    * @since 20 JULY 2018
    * @param a the second fraction
    * @return product of fractions
    * multiplies two fractions
    */
    frac multiply(frac a)
    {   return new frac(numerator * a.numerator, denominator * a.denominator);
    }
    
    /**
    * @author Chase P. Miller
    * @version Version 1.4.2
    * @since 20 JULY 2018
    * @param a the second fraction
    * @return dividend of fractions
    * divides two fractions
    */
    frac divide(frac a)
    {   return new frac(numerator * a.denominator, denominator * a.numerator);
    }
} 