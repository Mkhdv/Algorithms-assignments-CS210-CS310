
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class MinMax {
    // Linked list class.
    private static class Node {
        private int item;
        private Node next;
    }

    // Return the minimum value in the given linked list.
    public static int min(Node first) {
        int min = Integer.MAX_VALUE;
        for (Node n = first; n != null; n = n.next) {
            if (min > n.item) {
                min = n.item;
            }
        }
        return min;
    }

    // Return the maximum value in the given linked list.
    public static int max(Node first) {
        int max = Integer.MIN_VALUE;
        for (Node n = first; n != null; n = n.next) {
            if (max < n.item) {
                max = n.item;
            }
        }
        return max;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int[] items = new int[1000];
        for (int i = 0; i < 1000; i++) {
            items[i] = StdRandom.uniform(-10000, 10000);
        }
        Node first = null; 
        for (int item : items) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }
        StdOut.println(min(first) == StdStats.min(items) 
                       && max(first) == StdStats.max(items));
    }
}