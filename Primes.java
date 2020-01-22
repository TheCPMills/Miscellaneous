package Math;
class Primes
{   static boolean isPrime(int num)
    {   for(int i = 2; i < num; i++)
        {   if(num % i == 0)
            {   return false;
            }
        }
        return true;
    }

    static int nextPrime(int num)
    {   while(!isPrime(++num))
        {   
        }
        return num;
    }
    
    public static void main(String[] args)
    {   int k = 2;
        for(int i = 1; i < 11; i++)
	{   for(int j = 1; j <= k; j++)
	    {   System.out.print(k + " ");
	    }
	    System.out.println();
	    k = nextPrime(k);
        }
    }
    
    static void main2()
    {   int sum = 0;
        int s = 0;
        int u = 0;
        int m = 0;
        for(int i = 1; i < 6; i++)
	{   sum += (Math.pow(i, 2) + i - 1);
        }
        System.out.println("sum: " + sum);
        for(int i = 1; i < 6; i++)
	{   s += Math.pow(i, 2);
        }
        System.out.println("s: " + s);
        for(int i = 1; i < 6; i++)
	{   u += i;
        }
        System.out.println("u: " + u);
        for(int i = 1; i < 6; i++)
	{   m += 1;
        }
        System.out.println("m: " + m);
        System.out.println("new sum: " + (s + u - m));
    }
}