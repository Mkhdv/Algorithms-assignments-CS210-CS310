
// Ramanujan.java: Prints the integers <= N (command-line argument) that
// can be expressed as the sum of two distinct cubes.

import edu.princeton.cs.algs4.StdOut;

public class Ramanujan {
    public static void main(String[] args) {
        // Read integer from command-line
        int n = Integer.parseInt(args[0]);

        // Initialize variables to hold cubic values
        int a3 = 0;
        int b3 = 0;
        int c3 = 0;
        int d3 = 0;

        // Check all potential 'a' values
        for (int a = 1; 0 < a && a * a * a <= n; a++) {
            a3 = a * a * a;

            // Check all possible 'b' values, avoiding repetiotion with 'a'
            for (int b = a; b >= a && b * b * b <= n - a * a * a; b++) {
                b3 = b * b * b;

                // Check all 'c' values, avoiding repetition with 'a' and 'b'
                for (int c = a + 1; c > a && c * c * c <= n; c++) {
                    c3 = c * c * c;

                    // Check all 'd' values avoiding all repetitions
                    for (int d = c; d >= c && d * d * d <= n - c * c * c; d++) {
                        d3 = d * d * d;

                        // Print matching results in form  a^3 + b3 = c^3 + d^3
                        if (a3 + b3 == c3 + d3) {
                            StdOut.print((a3 + b3) +  " = ");
                            StdOut.print(a + "^3 + " + b + "^3 = ");
                            StdOut.print(c + "^3 + " + d + "^3");
                            StdOut.println();
                        }
                    }
                }
            }
        }
    }
}