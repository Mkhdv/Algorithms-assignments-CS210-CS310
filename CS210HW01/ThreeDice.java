
// ThreeDice.java: Writes the sum of three random integers between 1 and 6, such
// as you might get when rolling three dice.

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeDice {
    public static void main(String[] args) {

        // Get sum of three random numbers from 1 to 6
        int r = StdRandom.uniform(1, 7) + StdRandom.uniform(1, 7) 
        + StdRandom.uniform(1, 7);

        // Print out the sum
        StdOut.println(r);
    }
}
