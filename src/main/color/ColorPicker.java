package main.color;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class ColorPicker extends JPanel
{   Color color;
    ColorPicker(Color colors)
    {   color = colors;
    }
    
    ColorPicker(int r, int g, int b, double a)
    {   color = new NewColor(r,g,b,a);
    }
    
    protected void paintComponent(Graphics g)
    {   super.paintComponent(g);
        g.setColor(color);
        g.fillRect(10,10,200,200);
    }
    
    public void displayColor()
    {   ColorPicker rects = new ColorPicker(color);
        JFrame frame = new JFrame("New Color");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(245, 275);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ColorPicker(125, 25, 37, 1).displayColor();
    }
}