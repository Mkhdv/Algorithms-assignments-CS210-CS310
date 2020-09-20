
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BrutePointST<Value> implements PointST<Value> {
    RedBlackBST<Point2D, Value> bst = new RedBlackBST<Point2D, Value>();    

    private Node root;
    private int N;
    
    // 2d-tree (generalization of a BST in 2d) representation.
    private class Node {
        private Point2D p;   // the point
        private Value val;   // the symbol table maps the point to this value
        private RectHV rect; // the axis-aligned rectangle corresponding to
                             // this node
        private Node lb;     // the left/bottom subtree
        private Node rt;     // the right/top subtree
 
        // Construct a node given the point, the associated value, and the
        // axis-aligned rectangle corresponding to the node.
        public Node(Point2D p, Value val, RectHV rect) {
            this.p = p;
            this.val = val;
            this.rect = rect;
        }
        
    }
    
    // Construct an empty symbol table of points.
    public BrutePointST() {
        this.root = null;
        this.N = 0;
    }

    // Is the symbol table empty?
    public boolean isEmpty() { 
        return size() == 0;
    }

    // Number of points in the symbol table.
    public int size() {
        return bst.size();
    }

    // Associate the value val with point p.
    public void put(Point2D p, Value val) {
        if (p == null) throw new IllegalArgumentException();
        bst.put(p, val);
        
}


    // Value associated with point p.
    public Value get(Point2D p) {
 
         return bst.get(p);

    }


    // Does the symbol table contain the point p?
    public boolean contains(Point2D p) {
        if(p == null) throw new IllegalArgumentException();
            return bst.contains(p);
    }

    // All points in the symbol table.
    public Iterable<Point2D> points() {
        return bst.keys();

    }

    // All points in the symbol table that are inside the rectangle rect.
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null)
            throw new NullPointerException();
        Queue<Point2D> q = new Queue<Point2D>();
        for (Point2D c : bst.keys())
            if (rect.contains(c))
                q.enqueue(c);
        return q;
    }
    

    // A nearest neighbor to point p; null if the symbol table is empty.
    public Point2D nearest(Point2D p) {
        if (p == null)
            throw new NullPointerException();
        Point2D aim = null;
        double daim = Double.POSITIVE_INFINITY;
        for (Point2D point : bst.keys()) {
            if (point != null && (daim > point.distanceSquaredTo(p)
                && (!point.equals(p)))) {
                aim = point;
                daim = point.distanceSquaredTo(p);
            }
        }
        return aim;
}


    // k points that are closest to point p.
    public Iterable<Point2D> nearest(Point2D p, int k) {

          if (p == null)
            throw new NullPointerException();
          if (k == 0)
            throw new NullPointerException();
          MinPQ<Point2D> pq = new MinPQ<Point2D>(p.distanceToOrder());
        for (int a = 0; a < bst.size(); a++) {
            Point2D near = nearest(p);
            pq.insert(near);
            bst.delete(near);
        }
        Queue<Point2D> kpq = new Queue<Point2D>();
        for (int i = 0; i < k; i++) {
            kpq.enqueue(pq.delMin());
        }
        return kpq;
    }
        

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        BrutePointST<Integer> st = new BrutePointST<Integer>();
        double qx = Double.parseDouble(args[0]);
        double qy = Double.parseDouble(args[1]);
        double rx1 = Double.parseDouble(args[2]);
        double rx2 = Double.parseDouble(args[3]);
        double ry1 = Double.parseDouble(args[4]);
        double ry2 = Double.parseDouble(args[5]);
        int k = Integer.parseInt(args[6]);
        Point2D query = new Point2D(qx, qy);
        RectHV rect = new RectHV(rx1, ry1, rx2, ry2);
        int i = 0;
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            Point2D p = new Point2D(x, y);
            st.put(p, i++);
        }
        StdOut.println("st.empty()? " + st.isEmpty());
        StdOut.println("st.size() = " + st.size());
        StdOut.println("First " + k + " values:");
        i = 0;
        for (Point2D p : st.points()) {
            StdOut.println("  " + st.get(p));
            if (i++ == k) {
                break;
            }
        }
        StdOut.println("st.contains(" + query + ")? " + st.contains(query));
        StdOut.println("st.range(" + rect + "):");
        for (Point2D p : st.range(rect)) {
            StdOut.println("  " + p);
        }
        StdOut.println("st.nearest(" + query + ") = " + st.nearest(query));
        StdOut.println("st.nearest(" + query + ", " + k + "):");
        for (Point2D p : st.nearest(query, k)) {
            StdOut.println("  " + p);
        }
    }
}
