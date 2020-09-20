import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

// Models an N-by-N percolation system.
public class Percolation {
    ...
    
    // Create an N-by-N grid, with all sites blocked.
    public Percolation(int N) {
        ...
    }

    // Open site (i, j) if it is not open already.
    public void open(int i, int j) {
        ...
    }

    // Is site (i, j) open?
    public boolean isOpen(int i, int j) {
        ...
    }

    // Is site (i, j) full?
    public boolean isFull(int i, int j) {
        ...
    }

    // Number of open sites.
    public int numberOfOpenSites() {
        ...
    }

    // Does the system percolate?
    public boolean percolates() {
        ...
    }

    // An integer ID (1...N) for site (i, j).
    private int encode(int i, int j) {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        StdOut.println(perc.numberOfOpenSites() + " open sites");
        if (perc.percolates()) {
            StdOut.println("percolates");
        }
        else {
            StdOut.println("does not percolate");
        }
        
        // Check if site (i, j) optionally specified on the command line
        // is full.
        if (args.length == 3) {
            int i = Integer.parseInt(args[1]);
            int j = Integer.parseInt(args[2]);
            StdOut.println(perc.isFull(i, j));
        }
    }
}
