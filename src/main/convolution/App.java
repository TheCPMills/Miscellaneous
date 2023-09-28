package main.convolution;

import org.apache.commons.math3.complex.*;
import org.apache.commons.math3.transform.*;

public class App {
    static final double I = 1;

    // for convolution, it's IFFT(FFT(x) * FFT(y)) where x is the array and y is the kernel
    // for correlation, it's the same as convolution except it's the complex conjugate of FFT(y) times i or IFFT(FFT(x) * FFT(y[reversed]))
        // it could also be the complex conjugate of FFT(x) times i or IFFT(FFT(x[reversed]) * FFT(y)), but convention is y.

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // create an array
        double[] array = { 1, 2, 3, 4, 5 };

        // create a kernel
        double[] kernel = { 1, 2, 3, 4, 5 };

        // pad zeros to array and kernel to make them have a length of N+M-1
        int N = array.length;
        int M = kernel.length;
        int P = N + M - 1;
        double[] arrayPadded = new double[P];
        double[] kernelPadded = new double[P];
        for (int i = 0; i < P; i++) {
            if (i < N) {
                arrayPadded[i] = array[i];
            } else {
                arrayPadded[i] = 0;
            }
            if (i < M) {
                kernelPadded[i] = kernel[i];
            } else {
                kernelPadded[i] = 0;
            }
        }

        // pad the array and kernel to a length of 2^k
        double k = Math.ceil(Math.log(P) / Math.log(2));
        int length = (int) Math.pow(2, k);
        double[] arrayPadded2 = new double[length];
        double[] kernelPadded2 = new double[length];
        for (int i = 0; i < length; i++) {
            if (i < P) {
                arrayPadded2[i] = arrayPadded[i];
                kernelPadded2[i] = kernelPadded[i];
            } else {
                arrayPadded2[i] = 0;
                kernelPadded2[i] = 0;
            }
        }

        System.out.println("Convolution of array and kernel:");
        convolve(arrayPadded2, kernelPadded2, P);
        System.out.println("=========================================\nCorrelation of array and kernel:");
        correlate(arrayPadded2, kernelPadded2, P);
        System.out.println("=========================================\nCorrelation of kernel and array:");
        correlate(kernelPadded2, arrayPadded2, P, true);
    }

    static void convolve(double[] array, double[] kernel, int P) {
        // take the convolution of the array and kernel using the fast fourier transform
        FastFourierTransformer fft = new FastFourierTransformer(DftNormalization.STANDARD);
        Complex[] arrayFrequency = fft.transform(array, TransformType.FORWARD);

        Complex[] kernelFrequency = fft.transform(kernel, TransformType.FORWARD);
        
        Complex[] convolvedFrequency = new Complex[kernelFrequency.length];
        for (int i = 0; i < kernelFrequency.length; i++) {
            convolvedFrequency[i] = arrayFrequency[i].multiply(kernelFrequency[i]);
        }
        
        Complex[] convolved = fft.transform(convolvedFrequency, TransformType.INVERSE);

        // print the convolved array
        for (int i = 0; i < P; i++) {
            System.out.println(convolved[i].getReal());
        }
    }

    static void correlate(double[] array, double[] kernel, int P) {
        // find last index of non-zero element in kernel
        int lastNonZeroIndex = 0;
        for (int i = kernel.length - 1; i >= 0; i--) {
            if (kernel[i] != 0) {
                lastNonZeroIndex = i;
                break;
            }
        }

        // reverse the kernel
        for (int i = 0; i < lastNonZeroIndex / 2; i++) {
            double temp = kernel[i];
            kernel[i] = kernel[lastNonZeroIndex - i];
            kernel[lastNonZeroIndex - i] = temp;
        }

        convolve(array, kernel, P);
    }

    static void correlate(double[] array, double[] kernel, int P, boolean kernelCorrelatedWithArray) {
        if (kernelCorrelatedWithArray) {
            // find the last index of non-zero element in array
            int lastNonZeroIndexArray = 0;
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] != 0) {
                    lastNonZeroIndexArray = i;
                    break;
                }
            }

            // reverse the array
            for (int i = 0; i < lastNonZeroIndexArray / 2; i++) {
                double temp = array[i];
                array[i] = array[lastNonZeroIndexArray - i];
                array[lastNonZeroIndexArray - i] = temp;
            }

            // find last index of non-zero element in kernel
            int lastNonZeroIndexKernel = 0;
            for (int i = kernel.length - 1; i >= 0; i--) {
                if (kernel[i] != 0) {
                    lastNonZeroIndexKernel = i;
                    break;
                }
            }

            // reverse the kernel
            for (int i = 0; i < lastNonZeroIndexKernel / 2; i++) {
                double temp = kernel[i];
                kernel[i] = kernel[lastNonZeroIndexKernel - i];
                kernel[lastNonZeroIndexKernel - i] = temp;
            }

            convolve(array, kernel, P);
        } else {
            correlate(array, kernel, P);
        }
    }

    static double[] fft(double[] array) {
        double[] y = new double[array.length];

        if (array.length == 1) {
            return array;
        }

        // split the array into two halves
        double[] e = new double[array.length / 2 + array.length % 2];
        double[] o = new double[array.length / 2];

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                e[i / 2] = array[i];
            } else {
                o[i / 2] = array[i];
            }
        }

        double[] even = fft(e);
        double[] odd = fft(o);

        for (int k = 0; k < array.length / 2 - 1; k++) {
            double w = Math.cos(2 * Math.PI * k / array.length) + I * Math.sin(2 * Math.PI * k / array.length);
            y[k] = even[k] + w * odd[k];
            y[k + array.length / 2] = even[k] - w * odd[k];
        }
        
        return y;
    }

    static double[] ifft(double[] array) {
        double[] y = new double[array.length];

        if (array.length == 1) {
            return array;
        }

        // split the array into two halves
        double[] e = new double[array.length / 2 + array.length % 2];
        double[] o = new double[array.length / 2];

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                e[i / 2] = array[i];
            } else {
                o[i / 2] = array[i];
            }
        }

        double[] even = fft(e);
        double[] odd = fft(o);

        for (int k = 0; k < array.length / 2 - 1; k++) {
            double w = Math.cos(-2 * Math.PI * k / array.length) + I * Math.sin(-2 * Math.PI * k / array.length);
            y[k] = (even[k] + w * odd[k]) / array.length;
            y[k + array.length / 2] = (even[k] - w * odd[k]) / array.length;
        }

        return y;
    }
}