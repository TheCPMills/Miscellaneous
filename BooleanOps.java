package LogicAndDataTypes;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.math.*;
/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class BooleanOps
{   boolean tautology(boolean a, boolean b)
    {   return true;
    }
    
    boolean contradiction(boolean a, boolean b)
    {   return false;
    }
    
    boolean A(boolean a, boolean b)
    {   return a;
    }
    
    boolean notA(boolean a, boolean b)
    {   return !a;
    }
    
    boolean B(boolean a, boolean b)
    {   return b;
    }
    
    boolean notB(boolean a, boolean b)
    {   return !b;
    }
    
    boolean conjunction(boolean a, boolean b)
    {   return a && b;
    }
    
    boolean alternativeDenial(boolean a, boolean b)
    {   return !(a && b);
    }
    
    boolean disjunction(boolean a, boolean b)
    {   return a || b;
    }
    
    boolean jointDenial(boolean a, boolean b)
    {   return !(a || b);
    }
    
    boolean abjunction(boolean a, boolean b)
    {   return (a && !b);
    }
    
    boolean implication(boolean a, boolean b)
    {   return (!a || b);
    }
    
    boolean converseAbjunction(boolean a, boolean b)
    {   return (!a && b);
    }
    
    boolean converseImplication(boolean a, boolean b)
    {   return (a || !b);
    }
    
    boolean exclusiveDisjunction(boolean a, boolean b)
    {   return (a ^ b);
    }
    
    boolean biconditional(boolean a, boolean b)
    {   return !(a ^ b);
    }
}