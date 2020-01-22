package Math;

class Maths {
    static final double π = Math.PI;
    static final double e = Math.E;
    static final double i = Math.pow(-1, 0.5);
    double distance(Point p1, Point p2) {
        double x = pow((p1.x - p2.x), 2);
        double y = pow((p1.y - p2.y), 2);
        double z = pow((p1.z - p2.z), 2);
        double w = pow((p1.w - p2.w), 2);
        return pow((x + y + z + w), 0.5);
    }
    double pow(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    double log(double value) {
        return Math.log10(value);
    }
    double ln(double value) {
        return Math.log(value);
    }
    double log(double base, double value) {
        return ln(value) / ln(base);
    }
    double sin(double value) {
        return Math.sin(value);
    }
    double cos(double value) {
        return Math.cos(value);
    }
    double tan(double value) {
        return Math.tan(value);
    }
    double arcsin(double value) {
        return Math.asin(value);
    }
    double arccos(double value) {
        return Math.acos(value);
    }
    double arctan(double value) {
        return Math.atan(value);
    }
    double sinh(double value) {
        return Math.sinh(value);
    }
    double cosh(double value) {
        return Math.cosh(value);
    }
    double tanh(double value) {
        return Math.tanh(value);
    }
    double arcsinh(double value) {
        return ln(value + pow(pow(value, 2) + 1, 0.5));
    }
    double arccosh(double value) {
        return ln(value + pow(pow(value, 2) - 1, 0.5));
    }
    double arctanh(double value) {
        return 0.5 * ln((1 + value) / (1 - value));
    }
    double radiansToDegrees(double angleMeasure) {
        return angleMeasure * (180 / π);
    }
    double degreesToRadians(double angleMeasure) {
        return angleMeasure * (π / 180);
    }
    static void main() {
        Maths m = new Maths();
        Point p = new Point(2, 3, 5, 0);
        Point o = new Point(2, 7, 11, 5);
        System.out.println(m.distance(p, o));
        Point q = new Point(2, 3, 0, -10);
        Point r = new Point(6, 3, 6, -5);
        System.out.println(m.distance(q, r));
    }
}