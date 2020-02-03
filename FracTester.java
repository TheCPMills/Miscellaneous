package Math;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class FracTester
{   static void main()
    {   Integer a = new Integer(2);
        Integer b = new Integer(3);
        Long c = new Long(5);
        Long d = new Long(7);
        Float e = new Float(3.5);
        Float f = new Float(10.25);
        Double g = new Double(2.75);
        Double h = new Double(5.125);
        Frac i = new Frac(3, 5);
        Frac j = new Frac(7, 8);
        System.out.println(a + " / " + b + " = " + new Frac(a, b));
        System.out.println(a + " / " + c + " = " + new Frac(a, c));
        System.out.println(a + " / " + e + " = " + new Frac(a, e));
        System.out.println(a + " / " + g + " = " + new Frac(a, g));
        System.out.println(a + " / " + i + " = " + new Frac(a, i));
        System.out.println(c + " / " + b + " = " + new Frac(c, b));
        System.out.println(c + " / " + d + " = " + new Frac(c, d));
        System.out.println(c + " / " + f + " = " + new Frac(c, f));
        System.out.println(c + " / " + h + " = " + new Frac(c, h));
        System.out.println(c + " / " + j + " = " + new Frac(c, j));
        System.out.println(e + " / " + b + " = " + new Frac(e, b));
        System.out.println(e + " / " + d + " = " + new Frac(e, d));
        System.out.println(e + " / " + f + " = " + new Frac(e, f));
        System.out.println(e + " / " + h + " = " + new Frac(e, h));
        System.out.println(e + " / " + i + " = " + new Frac(e, j));
        System.out.println(g + " / " + a + " = " + new Frac(g, a));
        System.out.println(g + " / " + d + " = " + new Frac(g, d));
        System.out.println(g + " / " + f + " = " + new Frac(g, f));
        System.out.println(g + " / " + h + " = " + new Frac(g, h));
        System.out.println(g + " / " + i + " = " + new Frac(g, i));
        System.out.println(i + " / " + a + " = " + new Frac(i, a));
        System.out.println(i + " / " + d + " = " + new Frac(i, d));
        System.out.println(i + " / " + e + " = " + new Frac(i, e));
        System.out.println(i + " / " + h + " = " + new Frac(i, h));
        System.out.println(i + " / " + j + " = " + new Frac(i, j));
    }
}