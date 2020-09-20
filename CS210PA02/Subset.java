
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Takes a command-line integer k; reads in a sequence of strings from 
// standard input; and prints out exactly k of them, uniformly at random. 
// Note that each item from the sequence is printed out at most once.
public class Subset {
    public static void main(String[] args) {
        
        // Read integer from Standard Input
        int k = Integer.parseInt(args[0]);

        // Create reszizing array q for input strings
        ResizingArrayRandomQueue<String> q = 
            new ResizingArrayRandomQueue<String>();

        // Read all input strings into array q
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        StdOut.println();

        // Print k random values from the array
        String j = null;
        for (int i = 0; i < k; i++) {
            j = q.dequeue();
            StdOut.println(j);
        }
    }
}