
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

// A data type that provides autocomplete functionality for a given set of 
// string and weights, using Term and BinarySearchDeluxe. 
public class Autocomplete {
    public Term[] quries;
    
    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null) {
            throw new NullPointerException();
        }
        this.quries = terms;
        Arrays.sort(quries);
    }

    // All terms that start with the given prefix, in descending order of
    // weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new NullPointerException();
        }
        Term temp = new Term(prefix, 0);

        int i = BinarySearchDeluxe.firstIndexOf(quries, temp, Term.byPrefixOrder(prefix.length()));
        int j = BinarySearchDeluxe.lastIndexOf(quries, temp, Term.byPrefixOrder(prefix.length()));
        if (i == -1 || j == -1) {
            throw new NullPointerException();
        }
            Term[] matches = new Term[j - i + 1];
            matches = Arrays.copyOfRange(quries, i, j);
            Arrays.sort(matches, Term.byReverseWeightOrder());
            return matches;
    }

    // The number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) {
            throw new NullPointerException();
        }
        Term temp = new Term(prefix, 0);
        int i = BinarySearchDeluxe.firstIndexOf(quries, temp, Term.byPrefixOrder(prefix.length()));
        int j = BinarySearchDeluxe.lastIndexOf(quries, temp, Term.byPrefixOrder(prefix.length()));
            return j - i + 1;
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            long weight = in.readLong(); 
            in.readChar(); 
            String query = in.readLine(); 
            terms[i] = new Term(query.trim(), weight); 
        }
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++) {
                StdOut.println(results[i]);
            }
        }
    }
}