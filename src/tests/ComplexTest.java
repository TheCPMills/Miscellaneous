package tests;
import org.apache.commons.math.complex.*;

/**
 * @version Version
 * @since 
 */

public class ComplexTest{
    static final Complex i = Complex.I;
    public static void main(String[] args) {
        Complex negOne = new Complex(1, 1).log();
        System.out.println(negOne.getReal() + " + " + negOne.getImaginary() + "i");
        System.out.println(Math.log(Math.pow(2, 0.5)) + " + " + Math.PI/4 + "i");
    }
}