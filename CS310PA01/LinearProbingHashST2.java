// package cs310;

import edu.princeton.cs.algs4.*;

public class LinearProbingHashST2<Key, Value> {
	
	private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int f;			// number of key-value pairs including 'deleted'
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values
	boolean[] flags;         // boolean array to indicate if an item is active or deleted




    public LinearProbingHashST2() {
        this(INIT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
	public LinearProbingHashST2(int capacity) {
        m = capacity;
        n = 0;
        f = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
        flags = new boolean[m];
    }

    public int size() {        
    	    return n;
    }
    

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        
        if (flags[hash(key)] == false) return false; 
        
        return get(key) != null;
        }

    // hash function for keys - returns value between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        LinearProbingHashST2<Key, Value> temp = new LinearProbingHashST2<Key, Value>(capacity);
        f = 0;
        for (int i = 0; i < m; i++) {
            if (keys[i] != null && flags[i] == true) {
                temp.put(keys[i], vals[i]);
                temp.flags[i] = true;
                f++;
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
        flags = temp.flags;
     
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (f >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        flags[i] = true;
        n++;
        f++;
    }


    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key) && flags[i] == true)
        
                return vals[i];
        return null;
    }


    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        // delete key and associated value
        flags[i] = false;
        n--;
        
        // control the disparity between 'deleted' and 'active' items
        if (n > 0 && n <= m/8) resize(m/2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null && flags[i] == true) queue.enqueue(keys[i]);
        return queue;
    }


    public static void main(String[] args) { 
        LinearProbingHashST2<String, Integer> st = new LinearProbingHashST2<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        StdOut.println();
        StdOut.println("Before the deletion: \nSize of the table = " + st.size());
        StdOut.println("n = " + st.n);
        StdOut.println("m = " + st.m);

        // print keys
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));}
        
        st.delete("S");
        st.delete("A");

        StdOut.println();
        StdOut.println("After A and S are deleted: \nSize of the table = " + st.size());
        StdOut.println("n = " + st.n);
        StdOut.println("m = " + st.m);

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));}

    }
}
	

