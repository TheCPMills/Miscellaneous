package Math;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.math.*;
import java.net.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import org.apache.commons.math.complex.*;

/**
 * @version Version
 * @since 
 */

public class testComplex{
    static final org.apache.commons.math.complex.Complex I = org.apache.commons.math.complex.Complex.I;
    public static void main(String[] args) {
        org.apache.commons.math.complex.Complex negOne = new org.apache.commons.math.complex.Complex(1, 1).log();
        System.out.println(negOne.getReal() + " + " + negOne.getImaginary() + "i");
        System.out.println(Math.log(Math.pow(2, 0.5)) + " + " + Math.PI/4 + "i");
    }
}