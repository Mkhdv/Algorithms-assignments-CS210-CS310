// package cs310;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class TestPerf {

	public static long LinearProbingHashST(String x[]) {
		
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
            long start = System.currentTimeMillis();
            for(int i = 0; i < x.length; i++){
    	        String key = x[i];
    	        if (!st.contains(key))  st.put(key, 1); 
            else                    st.put(key, st.get(key) + 1); 
            }
        long finish = System.currentTimeMillis();
    	    return (finish - start);
	}
	
	
	public static long SeparateChainingHashST(String x[]) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        long start = System.currentTimeMillis();
            for(int i = 0; i < x.length; i++){
        	    String key = x[i];
        	    if (!st.contains(key))  st.put(key, 1); 
            else                    st.put(key, st.get(key) + 1); 
            }
        long finish = System.currentTimeMillis();
        return (finish - start);
	}
	
	
	public static long ST(String x[]) {
        ST<String, Integer> st = new ST<String, Integer>();
            long start = System.currentTimeMillis();
            for(int i = 0; i < x.length; i++){
        	    String key = x[i];
        	    if (!st.contains(key))  st.put(key, 1); 
            else                    st.put(key, st.get(key) + 1); 
            }
        long finish = System.currentTimeMillis();
		return (finish - start);
	}
	
    public static long SequentialSearchST(String x[]) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
            long start = System.currentTimeMillis();
            for(int i = 0; i < x.length; i++){
        	    String key = x[i];
        	    if (!st.contains(key))  st.put(key, 1); 
            else                    st.put(key, st.get(key) + 1); 
            }
        long finish = System.currentTimeMillis();
        return (finish - start);
    }
    
	public static void main(String[] args) {
		
        In in = new In(args[0]);
        String[] tale = in.readAllStrings(); 
   
        StdOut.println();
        StdOut.println("LinearProbingHashST time: " + LinearProbingHashST(tale) + " ms");
	    StdOut.println("SeparateChainingHashST time: " + SeparateChainingHashST(tale) + " ms");
	    StdOut.println("ST time: "+ ST(tale) + " ms");
	    StdOut.println("SequentialSearchST time: " + SequentialSearchST(tale) + " ms");

	    
	}
}

