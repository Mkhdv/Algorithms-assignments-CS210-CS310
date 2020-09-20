
// PrimeCounter.java: takes an integer N as a command-line argument and writes
// the number of primes <= N.

import edu.princeton.cs.algs4.StdOut;

public class PrimeCounter {
    // Returns true if x is prime, and false otherwise.
    private static boolean isPrime(int x) {

        // check and eliminate all even options
        if (x > 2 && x % 2 == 0)
            return false;

        // check if the argument is a composite odd number
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) { return false; }
        }
        return true;
    }
    // Returns the number of primes <= N.
    private static int primes(int N) {

        // count all prime numbers via isPrime() static method
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) { count++; }
       
        }
        return count;
    }
    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(primes(N));
    }
}