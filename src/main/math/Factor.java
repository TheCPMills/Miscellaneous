package main.math;

import java.util.*;

public class Factor {
    List<Integer> list = new ArrayList<Integer>();

    public Factor(int num) {
        while (num > 0) {
            list.add(0, num % 10);
            num /= 10;
        }
    }

    public static List<Integer> factors(int num) {
        List<Integer> d = new ArrayList<Integer>();
        if (num < 0) {
            num = -num;
        }
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                d.add(i);
            }
        }
        return d;
    }

    public static String factoring(int b, int c) {
        List<Integer> d = factors(c);
        int g;
        if (d.size() % 2 == 0) {
            g = d.size() / 2;
        } else {
            g = d.size() / 2 + 1;
        }
        for (int i = 0, j = d.size() - 1; i < g; i++, j--) {
            if (d.get(i) + d.get(j) == b && d.get(i) * d.get(j) == c) {
                System.out.println(d.get(i) + " and " + d.get(j));
                return d.get(i) + " and " + d.get(j);
            }
            if (-d.get(i) + d.get(j) == b && -d.get(i) * d.get(j) == c) {
                System.out.println(-d.get(i) + " and " + d.get(j));
                return -d.get(i) + " and " + d.get(j);
            }
            if (d.get(i) + -d.get(j) == b && d.get(i) * -d.get(j) == c) {
                System.out.println(d.get(i) + " and " + -d.get(j));
                return d.get(i) + " and " + -d.get(j);
            }
            if (-d.get(i) + -d.get(j) == b && -d.get(i) * -d.get(j) == c) {
                System.out.println(-d.get(i) + " and " + -d.get(j));
                return -d.get(i) + " and " + -d.get(j);
            }
        }
        System.out.println("No common factors");
        return "No common factors";
    }

    public static String factor(int a, int b, int c) {
        int d;
        int e;
        String s = factoring(b, c * a);
        if (s.compareTo("No common factors") == 0) {
            if (a == 1) {
                if (b == 0) {
                    return "x2 + " + c;
                }
                if (b == 1) {
                    return "x2 + x + " + c;
                }
                if (b == -1) {
                    return "x2 + -x + " + c;
                }
                return "x2 + " + b + "x + " + c;
            }
            if (a == -1) {
                if (b == 0) {
                    return "-x2 + " + c;
                }
                if (b == 1) {
                    return "-x2 + x + " + c;
                }
                if (b == -1) {
                    return "-x2 + -x + " + c;
                }
                return "x2 + " + b + "x + " + c;
            }
            if (b == 0) {
                return a + "x2 + " + c;
            }
            if (b == 1) {
                return a + "x2 + x + " + c;
            }
            if (b == -1) {
                return a + "x2 + -x + " + c;
            }
            return a + "x2 + " + b + "x + " + c;
        }
        d = Integer.parseInt(s.substring(0, s.indexOf(" ")));
        e = Integer.parseInt(s.substring(s.indexOf("d ") + 2));
        int f = d / a;
        int g = e / a;
        if (f == g) {
            return "x = " + -d;
        }
        return "x = " + -d + " OR " + -e;
    }

    public static double gcd(double a, double b) {
        a = (a > 0) ? a : -a;
        b = (b > 0) ? b : -b;
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public static List<Integer> factor(int i) {
        List<Integer> factors = new ArrayList<Integer>();
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                factors.add(j);
            }
        }
        System.out.println("Factors of " + i + ": " + factors);
        return factors;
    }

    public static void primeFactorization(int i) {
        int count;
        for (int j = 2; j <= i; j++) {
            count = 0;
            while (i % j == 0) {
                i /= j;
                count++;
            }
            if (count != 0) {
                for (; count > 0; count--) {
                    System.out.print(j + "\t");
                }
            }
        }
    }

    public static boolean isPrime(int i) {
        List<Integer> num = factors(i);
        return num.size() == 2;
    }

    /*
     * @param a the coefficient of the quadratic term
     * 
     * @param b the coefficient of the linear term
     * 
     * @param c the coefficient of the constant term
     * 
     * @returns if the values of x that satify the equation is real
     */
    public static boolean discriminant(float a, float b, float c) {
        float d = (b * b) - (4 * a * c);
        if (d < 0) {
            return false;
        }
        return true;
    }

    /*
     * @param r the value under the radical
     * 
     * @returns the simplified radical
     */
    public static String simplifyRadical(int r) {
        List<Integer> f = factors(r);
        if (Math.sqrt(r) == (int) (Math.sqrt(r))) {
            return "" + (int) (Math.sqrt(r));
        }
        for (int i = f.size() - 1; i > 0; i--) {
            if (Math.sqrt(f.get(i)) == (int) (Math.sqrt(f.get(i)))) {
                return (int) ((Math.sqrt(f.get(i)))) + "√" + (int) (r / f.get(i));
            }
        }
        return "√" + r;
    }

    /*
     * @param a the coefficient of the quadratic term
     * 
     * @param b the coefficient of the linear term
     * 
     * @param c the coefficient of the constant term
     * 
     * @returns the value of the discriminant
     */
    public static float discriminantValue(float a, float b, float c) {
        if (discriminant(a, b, c)) {
            return (b * b) - (4 * a * c);
        }
        return Float.NaN;
    }

    /*
     * @param a the coefficient of the quadratic term
     * 
     * @param b the coefficient of the linear term
     * 
     * @param c the coefficient of the constant term
     * 
     * @returns the values of x that satify the equation
     */
    public static String quadForm(float a, float b, float c) {
        if (discriminant(a, b, c)) {
            float d = (float) ((-b + Math.sqrt((double) (b * b) - (4 * a * c))) / (2 * a));
            float e = (float) ((-b - Math.sqrt((double) (b * b) - (4 * a * c))) / (2 * a));
            System.out
                    .println("(" + -b + " ± " + simplifyRadical((int) (discriminantValue(a, b, c))) + ") / " + (2 * a));
            return d + " and " + e;
        }
        return "Imaginary Answers";
    }

    public static void main(String[] args) {
        factor(1, 4, 2);
        System.out.println(quadForm(1, 4, 2));
        factor(1, 4, 4);
        System.out.println(quadForm(1, 4, 4));
    }

    static void main2() {
        int sum = 0;
        int s = 0;
        int u = 0;
        int m = 0;
        for (int i = 1; i < 6; i++) {
            sum += (Math.pow(i, 2) + i - 1);
        }
        System.out.println("sum: " + sum);
        for (int i = 1; i < 6; i++) {
            s += Math.pow(i, 2);
        }
        System.out.println("s: " + s);
        for (int i = 1; i < 6; i++) {
            u += i;
        }
        System.out.println("u: " + u);
        for (int i = 1; i < 6; i++) {
            m += 1;
        }
        System.out.println("m: " + m);
        System.out.println("new sum: " + (s + u - m));
    }
}