package TextTricks;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Console
{   public static <T> void println(T type)
    {   System.out.println(type);
    }

    public static <T> void print(T type)
    {   System.out.print(type);
    }
    
    public static void sleep(long l)
    {   try
        {   Thread.sleep(l);
        }
        catch(InterruptedException ex)
        {   Thread.currentThread().interrupt();
        }
    }
}