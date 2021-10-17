package main.color;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since
 */

public class NewColor extends Color
{   String name;
    public NewColor(int r, int g, int b, double a)
    {   super(r,g,b, (int) ((255 * a) + 0.5));
        setName();
    }

    public String toString()
    {   return "R: " + getRed() + " G: " + getGreen() + " B: " + getBlue() + " A: " + ((getAlpha() - 0.5) / 255);
    }

    void displayColor()
    {   ColorPicker rects = new ColorPicker(this);
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(220, 240);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void setName()
    {   Scanner sc = new Scanner(System.in);
        System.out.println("Name This Color");
        name = sc.nextLine();
        sc.close();
    }
}