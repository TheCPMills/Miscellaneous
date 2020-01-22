package TextTricks;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Text
{   public static void countdown()
    {   String s = "COUNTDOWN";
        System.out.println(s);
        for(int i = 10; i > 0; i--)
        {   System.out.print("\f");
            System.out.print(s + "\n    " + i);
            Console.sleep(1000);
        }
        System.out.print("\f");
        System.out.print(s + "\n LIFTOFF");
    }
    
    static void slots()
    {   char[] c = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String s = "";
        for(int k = 0; k < 3; k++)
        {   int i = 0;
            while(i < 1)
            {   for(int j = 0; j < 100; j++)
                {   System.out.print("\f" + s + c[j % 26]);
                    Console.sleep(10);
                }
                i++;
            }
            s += "7\t";
            System.out.print("\f" + s);
        }
        System.out.println("\n      WINNER");
    }

    public static void main(String[] args) {
        countdown();
    }
}