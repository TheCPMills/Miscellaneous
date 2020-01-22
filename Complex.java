package Math;

public class Complex {
    double real, imaginary;
    public Complex(double r, double i) {
        real = r;
        imaginary = i;
    }
    public void multiply(Complex c) {
        double r1r2 = real * c.real;
        double r1i2 = real * c.imaginary;
        double i1r2 = imaginary * c.real;
        double i1i2 = -(imaginary * c.imaginary);
        System.out.println(toString() + " * " + c.toString() + " = " + new Complex(r1r2 + i1i2, r1i2 + i1r2).toString());
    }
    public String toString() {
        return imaginary >= 0 ? real + " + " + imaginary + "i" : real + " - " + -imaginary + "i";
    }
}