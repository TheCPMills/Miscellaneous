package main.math;

/**
 * @version Version
 * @since 
 */
public class Combinatorics
{    public static void main(int n)
     {  long a = 0, b = 0, c = 0, d = 0;
        for(int r = 0; r <= n; r++)
        {   a += comb(r, n);
        }
        for(int r = 0; r <= n; r++)
        {   b += combr(r, n);
        }
        for(int r = 0; r <= n; r++)
        {   c += perm(r, n);
        }
        for(int r = 0; r <= n; r++)
        {    d += permr(r, n);
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
     }
     
     public static long comb(int r, int n)
     {   long temp1 = fact(n);
         long temp2 = fact(r);
         long temp3 = fact(n - r);
         return temp1 / (temp2 * temp3);
     }
     
     public static long combr(int r, int n)
     {   long temp1 = fact(r + n - 1);
         long temp2 = fact(r);
         long temp3 = fact(n - 1);
         return temp1 / (temp2 * temp3);
     }
     
     public static long perm(int r, int n)
     {   long temp1 = fact(n);
         long temp2 = fact(n - r);
         return temp1 / temp2;
     }
     
     public static long permr(int r, int n)
     {   return (long) (Math.pow(n, r));
     }
     
     public static long fact(int num)
     {   long facto = 1;
         for(int i = 1; i <= num; i++)
         {   facto = facto * i;
         }
         return facto;
     }
}
