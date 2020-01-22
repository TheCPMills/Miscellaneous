package Math;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.math.*;
import java.net.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

/**
 * @version Version
 * @since 
 */

public class Tester {
    static void polarToRect(double r, double t) {
        Maths m = new Maths();
        System.out.println("x = " + r * m.cos(m.degreesToRadians(t)));
        System.out.println("y = " + r * m.sin(m.degreesToRadians(t)));
    }

    static void RectToPolar(double x, double y) {
        Maths m = new Maths();
        System.out.println("r = " + m.pow(m.pow(x, 2) + m.pow(y, 2), 0.5));
        System.out.println("t = " + m.radiansToDegrees(m.arctan(y/x)));
    }
    public static void main(String[] args) {
        Tester test = new Tester();
    }
}