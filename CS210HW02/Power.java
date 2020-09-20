// Power.java: reads integers a and b from command line and writes the value
// of a to the power b, computed recursively.

import edu.princeton.cs.algs4.StdOut;

public class Power {
    // Returns a to the power b, computed recursively.
    private static int power(int a, int b) {

        // Initialize variable for return value
        int n = 0; 

        // Condition for powers of 0
        if (b == 0) {
            n = 1;
        } 
        // Condition for all powers above 0
        if (b >= 1) {
            n = a * power(a, b -1);
        }
        return n;
    }
  

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println(power(a, b));
    }
}