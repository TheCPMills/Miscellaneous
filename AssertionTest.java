package LogicAndDataTypes;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.math.*;
import java.net.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

class AssertionTest {
    public static void main(String args[]) {
        int value = 15;
        try {
            assert value >= 20 : " Underweight";
        } catch (AssertionError ex) {
            System.out.println("value is underweight");
        } finally {
            System.out.println("value is " + value);
        }
    }
}