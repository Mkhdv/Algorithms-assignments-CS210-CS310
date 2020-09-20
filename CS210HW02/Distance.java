
// Distance.java: reads two position vectors from standard input, and then
// computes and writes the Euclidean distance between the two.

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;

public class Distance {
    // Returns the Euclidean distance between the position vectors x and y.
    private static double distance(double[] x, double[] y) {

        // Initialize variable to hold product of values
        double a = 0.0;
        
        // Find ditance using Euclids formula
        for (int i = 0; i < x.length; i++) {
            a += (x[i] - y[i]) * (x[i] - y[i]);
        }
        return Math.sqrt(a);
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        double[] x = StdArrayIO.readDouble1D();
        double[] y = StdArrayIO.readDouble1D();
        StdOut.println(distance(x, y));
    }
}