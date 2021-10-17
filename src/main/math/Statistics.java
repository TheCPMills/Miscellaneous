package main.math;

public class Statistics {
    public void linearRegression(double[] x, double[] y) {
        if(x.length != y.length) {
            System.out.println("Dimension Mismatch Error: x and y arrays differ in size");
        } else {
            double xmean = mean(x);
            double ymean = mean(y);
            double SSx = SSx(x, xmean);
            double SP = SP(x, xmean, y, ymean);
            double slope = slope(SSx, SP);
            double intercept = intercept(slope, xmean, ymean);
            double rS = residualsSquared(x, y, slope, intercept);
            double mRS = meanResidualsSquared(x, ymean, slope, intercept);
            double coefficientDetermination = coefficientDetermination(rS, mRS);
            System.out.println("f(x) = " + slope + "x + " + intercept);
            System.out.println("r^2 = " + coefficientDetermination);
        }
    }

    public double mean(double[] arr) {
        double sum = 0;
        for(double d : arr) {
            sum += d;
        }
        return sum/arr.length;
    }
    public double SSx(double[] x, double xmean) {
        double sum = 0;
        for(int k = 0; k < x.length; k++) {
            sum += Math.pow(x[k] - xmean, 2);
        }
        return sum;
    }

    public double SP(double[] x, double xmean, double[] y, double ymean) {
        double sum = 0;
        for(int k = 0; k < x.length; k++) {
            sum += (x[k] - xmean) * (y[k] - ymean);
        }
        return sum;
    }

    public double slope(double SSx, double SP) {
        return SP/SSx;
    }

    public double intercept(double slope, double xmean, double ymean) {
        return ymean - slope * xmean;
    }

    public double evaluate(double xvalue, double slope, double intercept) {
        return slope * xvalue + intercept;
    }

    public double residualsSquared(double[] x, double[] y, double slope, double intercept) {
        double sum = 0;
        for(int k = 0; k < x.length; k++) {
            sum += Math.pow(evaluate(x[k], slope, intercept) - y[k], 2);
        }
        return sum;
    }

    public double meanResidualsSquared(double[] x, double ymean, double slope, double intercept) {
        double sum = 0;
        for(int k = 0; k < x.length; k++) {
            sum += Math.pow(evaluate(x[k], slope, intercept) - ymean, 2);
        }
        return sum;
    }

    public double coefficientDetermination(double rS, double mRS) {
        return 1 - (rS/mRS);
    }

    public static void main(String[] args) {
        double[] x = {0, 1, 1.414, 1.732, 2, 2.236, 2.449, 2.646, 2.828, 3, 3.162, 3.317, 3.464, 3.606, 3.742, 3.873, 4};
        double[] y = {0, 1, 1.5, 2, 2, 2.25, 2.5, 2.75, 3, 3, 3.16666667, 3.33333333, 3.5, 3.66666667, 3.83333333, 4, 4};
        new Statistics().linearRegression(x, y);
    }
}