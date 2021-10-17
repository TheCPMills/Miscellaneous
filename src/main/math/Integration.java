package main.math;
import net.objecthunter.exp4j.*;
import java.util.*;

public class Integration {
     double LRect(String equation, double start, double end, int divisions) {
        double[] sums = new double[divisions];
        double separation = (end - start) / (divisions);
        Expression e = new ExpressionBuilder(equation).variables("x").build();
        for(int index = 0; index < divisions; index++) {
            double y = e.setVariable("x", start).evaluate();
            sums[index] = rectArea(separation, y);
            start += separation;
        }
        double total = 0;
        for(double d : sums) {
            total += d;
        }
        return total;
    }

    double RRect(String equation, double start, double end, int divisions) {
        double[] sums = new double[divisions];
        double separation = (end - start) / (divisions);
        Expression e = new ExpressionBuilder(equation).variables("x").build();
        for (int index = 0; index < divisions; index++) {
            double y = e.setVariable("x", start + separation).evaluate();
            sums[index] = rectArea(separation, y);
            start += separation;
        }
        double total = 0;
        for (double d : sums) {
            total += d;
        }
        return total;
    }

    double MRect(String equation, double start, double end, int divisions) {
        double[] sums = new double[divisions];
        double separation = (end - start) / (divisions);
        Expression e = new ExpressionBuilder(equation).variables("x").build();
        for (int index = 0; index < divisions; index++) {
            double y = e.setVariable("x", start + (separation / 2)).evaluate();
            sums[index] = rectArea(separation, y);
            start += separation;
        }
        double total = 0;
        for (double d : sums) {
            total += d;
        }
        return total;
    }

    double Trap(String equation, double start, double end, int divisions) {
        double[] sums = new double[divisions];
        double separation = (end - start) / (divisions);
        Expression e = new ExpressionBuilder(equation).variables("x").build();
        for (int index = 0; index < divisions; index++) {
            double y1 = e.setVariable("x", start).evaluate();
            double y2 = e.setVariable("x", start + separation).evaluate();
            sums[index] = trapArea(separation, y1, y2);
            start += separation;
        }
        double total = 0;
        for (double d : sums) {
            total += d;
        }
        return total;
    }
    private double rectArea(double x, double y) {
        return x * y;
    }
    
    private double trapArea(double x, double y1, double y2) {
        return x * ((y1 + y2) / 2);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting Value: ");
        double x1 = sc.nextDouble();
        System.out.println("Ending Value: ");
        double x2 = sc.nextDouble();
        System.out.println("Partitions: ");
        int parts = sc.nextInt();
        sc.close();

        String equation = "x^3+2";

        double left = new Integration().LRect(equation, x1, x2, parts);
        double right = new Integration().RRect(equation, x1, x2, parts);
        double mid = new Integration().MRect(equation, x1, x2, parts);
        double trap = new Integration().Trap(equation, x1, x2, parts);
        System.out.println("\nLeft:\t" + left + "\nRight:\t" + right + "\nMid:\t" + mid + "\nTrap:\t" + trap);
    }
}