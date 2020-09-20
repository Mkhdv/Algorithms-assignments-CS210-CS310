
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.StdOut;

// Models a board in the 8-puzzle game or its generalization.
public class Board {
    private int[][] tiles;
    private int N;
    private int hamming;
    private int manhattan;

    // Construct a board from an N-by-N array of tiles, where 
    // tiles[i][j] = tile at row i and column j, and 0 represents the blank 
    // square.
    public Board(int[][] tiles) {
	    this.tiles = tiles;
        hamming = 0;
        manhattan = 0;   
	    int sought = 0;     
	    if (tiles == null)
            throw new NullPointerException();
        this.N = tiles.length;
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) {
                sought = (i == N - 1 && j == N - 1) ? 0 : sought + 1;
                int got = tiles[i][j];
                if (sought != 0 && got != sought) {
                    hamming++;
                }  
		if (got!=0){
                int row = (this.tiles[i][j] - 1) / N;
                int col = (this.tiles[i][j] - 1) % N;
                manhattan += Math.abs(row - i) + Math.abs(col - j);
            }
        }
        }
    }

    // Tile at row i and column j.
    public int tileAt(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N)
            throw new IndexOutOfBoundsException();

        return tiles[i][j];
    }
    
    // Size of this board.
    public int size() {

        return N;
    }

    // Number of tiles out of place.
    public int hamming() {

        return hamming;
    }

    // Sum of Manhattan distances between tiles and goal.
    public int manhattan() {

        return manhattan;
    }

    // Is this board the goal board?
    public boolean isGoal() {

        return hamming == 0;
    }

    // Is this board solvable?
    public boolean isSolvable() {

        int a = (blankPos() - 1) / N;
        if (N % 2 != 0){
            if (inversions() % 2 != 0) {
                return false;
            }
	    }
        else{
           if ((a + inversions()) % 2 == 0) {
                return false;
            }
		}
	return true;    
	}


    // Does this board equal that?
    public boolean equals(Board that) {
	if (that == this) { 
            return true;
        }
        if (that == null) {
            return false;
        }
        if (that.getClass() != this.getClass()) { 
            return false; 
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tiles[i][j] != that.tiles[i][j])
                    return false;
            }
        }
        return true;
    }

    // All neighboring boards.
    public Iterable<Board> neighbors() {

        LinkedQueue<Board> queue = new LinkedQueue<Board>();

        int i = (this.blankPos() - 1) / N; 
        int j = (this.blankPos() - 1) % N; 

        if (i - 1 >= 0) {
            int[][] altClone = this.cloneTiles();
            int temp =  altClone[i - 1][j];
	        altClone[i - 1][j] = altClone[i][j]; 
            altClone[i][j] = temp;
            queue.enqueue(new Board(altClone));
        }

        if (j + 1 < this.size()) {
            int[][] altClone = this.cloneTiles();
            int temp =  altClone[i][j + 1];
	        altClone[i][j + 1] = altClone[i][j]; 
            altClone[i][j] = temp;
            queue.enqueue(new Board(altClone));
        }

        if (i + 1 < this.size()) {
            int[][] altClone = this.cloneTiles();
            int temp =  altClone[i +1][j];
	        altClone[i + 1][j] = altClone[i][j]; 
            altClone[i][j] = temp;
            queue.enqueue(new Board(altClone));
        }

        if (j - 1 >= 0) {
            int[][] altClone = this.cloneTiles();
            int temp =  altClone[i ][j - 1];
	        altClone[i][j - 1] = altClone[i][j]; 
            altClone[i][j] = temp;
            queue.enqueue(new Board(altClone));
        }

        return queue;
    }

    // String representation of this board.
    public String toString() {
        String s = N + "\n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s += String.format("%2d", tiles[i][j]);
                if (j < N - 1) {
                    s += " ";
                }
            }
            if (i < N - 1) {
                s += "\n";
            }
        }
        return s;
    }

    // Helper method that returns the position (in row-major order) of the 
    // blank (zero) tile.
    private int blankPos() {
        int pos = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pos++;
                if (tiles[i][j] == 0) {
                    return pos;
                }
            }
        }
        return -1; 
    }

    // Helper method that returns the snumber of inversions.
    private int inversions() {

        int invc = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int t = tiles[i][j];
                if (t > 0) {
                    for (int k = i * N + j + 1; k < N * N; k++) {
                        int row = k / N;
                        int col = k % N;
                        if (tiles[row][col] > 0 && tiles[row][col] < t)
                            invc++;
                    }
                }
            }
        }
        return invc;
    }


    // Helper method that clones the tiles[][] array in this board and 
    // returns it.
    private int[][] cloneTiles() {
        int[][] clone = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                clone[i][j] = tiles[i][j];
            }
        }
        return clone;
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
        Board board = new Board(tiles);
        StdOut.println(board.hamming());
        StdOut.println(board.manhattan());
        StdOut.println(board.isGoal());
        StdOut.println(board.isSolvable());
        for (Board neighbor : board.neighbors()) {
            StdOut.println(neighbor);
        }
    }
}