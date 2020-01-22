package Math;
import net.objecthunter.exp4j.*;
public class Sums {
    public static void main(String[] args) throws Exception {
        int k = 0;
        int n = 10;
        int sum = 0;
        Expression ex = new ExpressionBuilder("3x-1").variables("x").build();
        for(; k <= n; k++) {
            sum += ex.setVariable("x", k).evaluate();
        }
        System.out.println(sum);
    }
}