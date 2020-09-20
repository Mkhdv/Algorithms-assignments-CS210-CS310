// KthString.java: Takes a command-line argument k and prints 
// the kth string from the end found on standard input, 
// assuming that standard input has k or more strings.

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KthString {
    public static String kStrings(int g, String s) {
        Queue<String> queue = new Queue<String>();
        String[]token = s.split(" ");
        for (String test : token) {
            queue.enqueue(test);
        }
        for (int i = 0; i < (token.length - g); i++) {
            queue.dequeue();
        }
        return queue.dequeue();
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(kStrings(n, StdIn.readAll()));
    }
}