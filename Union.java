package LogicAndDataTypes;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class Union<T, U>
{   public T first;
    public U second;
    Union(T t, U u)
    {   first = t;
        second = u;
    }
    
    public String toString()
    {   return first + " :: " + second;
    }
}