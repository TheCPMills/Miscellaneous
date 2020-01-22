package LogicAndDataTypes;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Generic<T>
{   T cool;
    public Generic(T type)
    {   cool = type;
    }
    
    public String toString()
    {   if(cool instanceof String)
        {   return "Special: " + cool;
        }
        return "Generic: " + cool;
    }
}