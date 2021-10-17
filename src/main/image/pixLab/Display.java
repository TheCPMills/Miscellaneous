package main.image.pixLab;
import javax.swing.*;

/**
 * @version Version
 * @since 
 */

public class Display
{   public static void displayProfile()
    {   Profile m = new Profile();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(400,637);  
        f.setVisible(true);  
    }
}