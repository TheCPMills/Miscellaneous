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

public class Vector {
   private final double x;
   private final double y;
   private final double z;
   
   public Vector(double x, double y, double z) {
       this.x = x == 0 ? 0: x;
       this.y = y == 0 ? 0: y;
       this.z = z == 0 ? 0: z;
   }

   public double getX() {
       return x;
   }

   public double getY() {
       return y;
   }

   public double getZ() {
       return z;
   }

   public String toString() {
       return "<" + x + " , " + y + " , " + z + ">";
   }

   public Vector add(Vector v) {
       return new Vector(x + v.getX(), y + v.getY(), z + v.getZ());
   }

   public Vector subtract(Vector v) {
       return add(v.scalarMultiply(-1));
   }

   public Vector scalarMultiply(double d) {
       return new Vector(d * x, d * y, d * z);
   }

   public double dotProduct(Vector v) {
       return (x * v.getX()) + (y * v.getY()) + (z * v.getZ());
   }

   public Vector crossProduct(Vector v) {
       return new Vector(y * v.getZ() - z * v.getY(), z * v.getX() - x * v.getZ(), x * v.getY() - y * v.getX());
   }

   public static void main(String args[]) {
       Vector v1 = new Vector(1,2,0);
       Vector v2 = new Vector(2,-5,0);
       System.out.println(v1.add(v2));
       System.out.println(v1.subtract(v2));
       System.out.println(v1.scalarMultiply(5));
       System.out.println(v1.dotProduct(v2));
       System.out.println(v1.crossProduct(v2));
       System.out.println(v2.crossProduct(v1));
   }
}