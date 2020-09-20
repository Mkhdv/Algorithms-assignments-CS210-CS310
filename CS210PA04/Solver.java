
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinkedStack;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;

// A solver based on the A* algorithm for the 8-puzzle and its generalizations.
public class Solver {
    private LinkedStack<Board> solution;
    private int moves;

    // Helper search node class.
    private class SearchNode {
        private Board board;
        private int moves;
        private SearchNode previous;

        SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        }
    }
     
    // Find a solution to the initial board (using the A* algorithm).
    public Solver(Board initial) {
        if (initial == null) {
            throw new NullPointerException();
        }
        if (initial.isSolvable() == false) {
            throw new IllegalArgumentException();
        }
        MinPQ<SearchNode> pq = new MinPQ<SearchNode>(new ManhattanOrder());
        solution = new LinkedStack<Board>();
        pq.insert(new SearchNode(initial, 0, null));
        SearchNode node; 
        while (!pq.isEmpty()) {
            node = pq.delMin();
            if (node.board.isGoal()) {
                moves = node.moves;
                while (node.previous != null) {
                    solution.push(node.board);
                    node = node.previous;
                }
                break;
            }
            Iterable<Board> neighbors = node.board.neighbors();
            for (Board n : neighbors) {
                if (!n.equals(node.previous)) {
                    pq.insert(new SearchNode(n, node.moves + 1, node));
                }
            }
        }
    }
    // The minimum number of moves to solve the initial board.
    public int moves() {
        return moves;
    }

    // Sequence of boards in a shortest solution.
    public Iterable<Board> solution() {
        return solution;
    }

    // Helper hamming priority function comparator.
    private static class HammingOrder implements Comparator<SearchNode> {
        public int compare(SearchNode a, SearchNode b) {
            int x = a.board.hamming() + a.moves;
            int y = b.board.hamming() + b.moves;
            return x - y;
        }
    }
    
    // Helper manhattan priority function comparator.
    private static class ManhattanOrder implements Comparator<SearchNode> {
        public int compare(SearchNode a, SearchNode b) {
            int x = a.board.manhattan() + a.moves;
            int y = b.board.manhattan() + b.moves;
            return x - y;
        }
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board initial = new Board(tiles);
        if (initial.isSolvable()) {
            Solver solver = new Solver(initial);
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution()) {
                StdOut.println(board);
            }
        }
        else {
            StdOut.println("Unsolvable puzzle");
        }
    }
}