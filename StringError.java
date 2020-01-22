package LogicAndDataTypes;
import java.util.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class StringError extends Exception
{   String S = null;
    public StringError(String s)
    {   S = s;
    }
    
    public String sendError()
    {   return S;
    }
}