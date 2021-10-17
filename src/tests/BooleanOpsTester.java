package tests;
import main.logic.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since 
 */

public class BooleanOpsTester
{   public static void main(String[] args)
    {   BooleanOps bO = new BooleanOps();
        boolean b1, b2;
        for(int k = 0; k < 16; k++)
        {   for(int i = 0; i < 2; i++)
            {   for(int j = 0; j < 2; j++)
                {   switch(i)
                    {   case 0: b1 = false;
                                break;
                        default: b1 = true;
                                break;
                    }
                    switch(j)
                    {   case 0: b2 = false;
                                break;
                        default: b2 = true;
                                break;
                    }
                    switch(k)
                    {   case 0: System.out.print(bO.tautology(b1, b2));
                                break;
                        case 1: System.out.print(bO.contradiction(b1, b2));
                                break;
                        case 2: System.out.print(bO.A(b1, b2));
                                break;
                        case 3: System.out.print(bO.notA(b1, b2));
                                break;
                        case 4: System.out.print(bO.B(b1, b2));
                                break;
                        case 5: System.out.print(bO.notB(b1, b2));
                                break;
                        case 6: System.out.print(bO.conjunction(b1, b2));
                                break;
                        case 7: System.out.print(bO.alternativeDenial(b1, b2));
                                break;
                        case 8: System.out.print(bO.disjunction(b1, b2));
                                break;
                        case 9: System.out.print(bO.jointDenial(b1, b2));
                                break;
                        case 10: System.out.print(bO.abjunction(b1, b2));
                                 break;
                        case 11: System.out.print(bO.implication(b1, b2));
                                 break;
                        case 12: System.out.print(bO.converseAbjunction(b1, b2));
                                 break;
                        case 13: System.out.print(bO.converseImplication(b1, b2));
                                 break;
                        case 14: System.out.print(bO.exclusiveDisjunction(b1, b2));
                                 break;
                        case 15: System.out.print(bO.biconditional(b1, b2));
                                 break;
                    }
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
    
    static void betterMain()
    {   BooleanOps bO = new BooleanOps();
        boolean b1, b2, b3 = true;
        for(int k = 0; k < 16; k++)
        {   for(int i = 0; i < 2; i++)
            {   for(int j = 0; j < 2; j++)
                {   switch(i)
                    {   case 0: b1 = false;
                                break;
                        default: b1 = true;
                                break;
                    }
                    switch(j)
                    {   case 0: b2 = false;
                                break;
                        default: b2 = true;
                                break;
                    }
                    switch(k)
                    {   case 0: b3 = bO.tautology(b1, b2);
                                break;
                        case 1: b3 = bO.contradiction(b1, b2);
                                break;
                        case 2: b3 = bO.A(b1, b2);
                                break;
                        case 3: b3 = bO.notA(b1, b2);
                                break;
                        case 4: b3 = bO.B(b1, b2);
                                break;
                        case 5: b3 = bO.notB(b1, b2);
                                break;
                        case 6: b3 = bO.conjunction(b1, b2);
                                break;
                        case 7: b3 = bO.alternativeDenial(b1, b2);
                                break;
                        case 8: b3 = bO.disjunction(b1, b2);
                                break;
                        case 9: b3 = bO.jointDenial(b1, b2);
                                break;
                        case 10: b3 = bO.abjunction(b1, b2);
                                 break;
                        case 11: b3 = bO.implication(b1, b2);
                                 break;
                        case 12: b3 = bO.converseAbjunction(b1, b2);
                                 break;
                        case 13: b3 = bO.converseImplication(b1, b2);
                                 break;
                        case 14: b3 = bO.exclusiveDisjunction(b1, b2);
                                 break;
                        case 15: b3 = bO.biconditional(b1, b2);
                                 break;
                    }
                    if(b3)
                    {   System.out.print(1);
                    }
                    else
                    {   System.out.print(0);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
}