
// Transpose.java: reads a square matrix of doubles from standard input, and
// the computes and writes its transpose.

import edu.princeton.cs.algs4.StdArrayIO;

public class Transpose {
    // Transposes the square matrix x in place.
    private static void transpose(double[][] x) {

        // Initialize temporary variable
        double t = 0.0;

        // Transpose matrix via two for-loops and temporary variable
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < (x[0].length); j++) {
                t = x[i][j];
                x[i][j] = x[j][i];
                x[j][i] = t;
            }
        }
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        double[][] x = StdArrayIO.readDouble2D();
        transpose(x);
        StdArrayIO.print(x);
    }
}