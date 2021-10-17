package main.math;
import net.objecthunter.exp4j.*;
import java.util.*;

public class Equations {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        sc.close();

        // set expression
        Expression e = new ExpressionBuilder("((x+y)/(x-y))^2").variables("x", "y").build().setVariable("x", x).setVariable("y", y);
        
        // evaluate expression
        double result = e.evaluate();
        System.out.println(result);
    }
}