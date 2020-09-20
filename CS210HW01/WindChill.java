// WindChill.java: Takes two doubles t and v as command-line arguments and
// writes the wind chill w, calculated as w=35.74+0.6215t+(0.4275t-35.75)v^0.16.

import edu.princeton.cs.algs4.StdOut;

public class WindChill {
    public static void main(String[] args) {

        // Take two double numbers as command-line arguments
        double t = Double.parseDouble(args[0]);
        double v = Double.parseDouble(args[1]);

        // Implement the formula to find the wind chill value
        double w = 35.74 + 0.6215*t + (0.4275*t - 35.75) * Math.pow(v, 0.16);

        // Print out the result
        StdOut.println(w);
    }
}