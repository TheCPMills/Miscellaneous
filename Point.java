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

public class Point {
    double x, y, z, w;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
        z = 0;
        w = 0;
    }
    
    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        w = 0;
    }
    
    Point(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    double distance(Point p) {
        double a = Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2) + Math.pow(z - p.z, 2) + Math.pow(w - p.w, 2);
        return Math.sqrt(a);
    }

    public String toString() {
        String s = "";
        if(w != 0) {
            return "(" + x + ", " + y + ", " + z +  ", " + w + ")";
        }
        if (z != 0) {
            return "(" + x + ", " + y + ", " + z + ")";
        }
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(4,3);
        System.out.println(p1.distance(p2));
    }
}