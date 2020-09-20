// Ramanujan.java: Prints the integers <= N (command-line argument) that can be
// expressed as the sum of two distinct cubes.

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Ramanujan {
    // A data type that encapsulates a pair of numbers (i, j) 
    // and the sum of their cubes, ie, i^3 + j^3.
    private static class Pair implements Comparable<Pair> {
        private int i;          // first element of the pair
        private int j;          // second element of the pair
        private int sumOfCubes; // i^3 + j^3

        // Construct a pair (i, j).
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
            sumOfCubes = i * i * i + j * j * j;
        }

        // Compare this pair to the other by sumOfCubes.
        public int compareTo(Pair other) {
            return sumOfCubes - other.sumOfCubes;
        }
    }

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);

        MinPQ<Pair> p1 = new MinPQ<Pair>();

        for (int i = 1; i<= a; i++) {
            p1.insert(new Pair(i, i+1));
        }

        int v = 1;
        Pair prev = new Pair(0, 0);
        while (!p1.isEmpty()) {
            Pair r1 = p1.delMin();

            if (prev.sumOfCubes == r1.sumOfCubes) {
                v++;
                if (v == 2) {
                    StdOut.println(prev.sumOfCubes + " = " + prev);
                }
                
                StdOut.print(" = " + r1);
            }
            else { 
                if (v > 1) {
                    StdOut.println(); }
                v = 1;
            }
            prev = r1;

            if (r1.j < a) { p1.insert(new Pair(r1.i, r1.j + 1)); }
        }
        if (v > 1) { StdOut.println(); }
    }
}