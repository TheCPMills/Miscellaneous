package main.math;

public class Conversions
{   public static void main(String[] args)
    {   System.out.println(fromHex("D0E00F"));
    }
    
    public static String toHex(int i)
    {   char[] c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String s = "";
        while(i > 0)
        {  int a = i % 16;
           s = c[a] + s;
           i /= 16;
        }
        return s;
    }

    public static int toBin(int i)
    {   String s = "";
        while(i > 0)
        {  int a = i % 2;
           s = a + s;
           i /= 2;
        }
        return Integer.parseInt(s);
    }

    public static int toOct(int i)
    {   String s = "";
        while(i > 0)
        {  int a = i % 8;
           s = a + s;
           i /= 8;
        }
        return Integer.parseInt(s);
    }

    public static int fromHex(String s)
    {   String a= "";
        int i = 0, e = 1;
        for(int j = s.length(); j > 0; j--)
        {  a = s.substring(j - 1, j);
           int r = 0;
           if(a.equals("1"))
           {   r = 1;
           }
           else if(a.equals("2"))
           {   r = 2;
           }
           else if(a.equals("3"))
           {   r = 3;
           }
           else if(a.equals("4"))
           {   r = 4;
           }
           else if(a.equals("5"))
           {   r = 5;
           }
           else if(a.equals("6"))
           {   r = 6;
           }
           else if(a.equals("7"))
           {   r = 7;
           }
           else if(a.equals("8"))
           {   r = 8;
           }
           else if(a.equals("9"))
           {   r = 9;
           }
           else if(a.equals("A"))
           {   r = 10;
           }
           else if(a.equals("B"))
           {   r = 11;
           }
           else if(a.equals("C"))
           {   r = 12;
           }
           else if(a.equals("D"))
           {   r = 13;
           }
           else if(a.equals("E"))
           {   r = 14;
           }
           else if(a.equals("F"))
           {   r = 15;
           }
           i += r * e;
           e *= 16;
        }
        return s.substring(0, 1).equals("-") ? -i : i;
    }
    
    public static int fromBin(int i)
    {   int exponent = 0;
        int num = 0;
        while(i > 0)
        {  num += Math.pow(2, exponent++) * (i % 10);
           i /= 10;
        }
        return num;
    }
    
    public static int fromOct(int i)
    {   int exponent = 0;
        int num = 0;
        while(i > 0)
        {  num += Math.pow(8, exponent++) * (i % 10);
           i /= 10;
        }
        return num;
    }
}