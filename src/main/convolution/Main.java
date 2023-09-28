package main.convolution;

import java.io.*;
import main.image.ImageProcessing;

public class Main {
    public static void main(String[] args) throws IOException {
        double[][] kernel2D = {
            { 0.003663, 0.014652, 0.025641, 0.014652, 0.003663 },
            { 0.014652, 0.058608, 0.095238, 0.058608, 0.014652 },
            { 0.025641, 0.095238, 0.150183, 0.095238, 0.025641 },
            { 0.014652, 0.058608, 0.095238, 0.058608, 0.014652 },
            { 0.003663, 0.014652, 0.025641, 0.014652, 0.003663 }
        };

        ImageProcessing.filter("image.png", kernel2D);
    }
}