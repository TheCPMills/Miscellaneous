package TextTricks;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since
 */

public class JOKEBOT
{   static String a = "\"I went to school with hitmen. Yeah,\nthey kept guns in their lockers.\"";
    static String b = "\n\n\t~George Jude Horan";
    public static void tellJoke()
    {   for(int j = 0; j < a.length(); j++)
        {   Console.sleep(100);
            System.out.print(a.substring(j,j + 1));
        }
        for(int j = 0; j < b.length(); j++)
        {   Console.sleep(100);
            System.out.print(b.substring(j,j + 1));
        }
    }
}
