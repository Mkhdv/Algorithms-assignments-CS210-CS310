// ThreeSort.java: Takes three integers as command-line arguments and writes
// them in ascending order, separated by spaces.

import edu.princeton.cs.algs4.StdOut;

public class ThreeSort {
    public static void main(String[] args) {

        // Get three integers in random order
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        // Sort integers in ascending order
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = (a + b + c) - (max + min);

        // Print out sorted result
        StdOut.println(min + " " + mid + " " + max);
    }
}