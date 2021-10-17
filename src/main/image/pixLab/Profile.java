package main.image.pixLab;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
import java.io.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Profile extends Canvas
{   public void paint(Graphics g)
    {   Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = null;
        //i = t.getImage("/Users/chasemiller/Documents/Code/Java/PixLab/images/dancing-banana.gif");
        i = t.getImage("/Users/chasemiller/Documents/Code/Java/MRPG/Character Profiles/cyborg.png"); 
        // try
        // {   URL url = new URL("http://www.leftyliars.com/wp-content/uploads/2018/10/npc.jpg");
            // i = ImageIO.read(url);
        // }
        // catch(IOException e)
        // {   e.printStackTrace();
        // }
        g.drawImage(i, 0,0,this); 
    }
}  