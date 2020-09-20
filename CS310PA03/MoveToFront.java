// package cs310;
import edu.princeton.cs.algs4.*;


public class MoveToFront {
	  public static char[] list = new char[256];

	// apply move−to−front encoding ,
	// reading from standard input and writing to standard output
	   public static void encode() {
		   
		      for (int i = 0; i < 256 ; i++) {
		          list[i] = (char)i;
		      }
		      
	      while (!BinaryStdIn.isEmpty()) {
	         char c = BinaryStdIn.readChar();
	         int move = 0;  
	         
	         for (int i = 0; i < 256; i++) {
	        	 	if(list[i] == c) {
	        	 		move = i;
	        	 		break;
	        	 	}   
	         }
	         System.arraycopy(list, 0, list, 1, move);
	         list[0] = c;
	         BinaryStdOut.write(move, 8);
	      }
	      BinaryStdOut.close();
	   }

	// apply move−to−front decoding ,
	// reading from standard input and writing to standard output
	   public static void decode() {	   
		   
		      for (int i = 0; i < 256 ; i++) {
		          list[i] = (char)i;
		      }
    	      
	      while (!BinaryStdIn.isEmpty()) {
	          char c = BinaryStdIn.readChar(8);
	          char ch = list[c];
	          BinaryStdOut.write(ch, 8);
	          int move = 0;
		         
		         for (int i = 0; i < 256; i++) {
		        	 	if(list[i] == ch) {
		        	 		move = i;
		        	 		break;
		        	 	}   
		         }
		         System.arraycopy(list, 0, list, 1, move);
		         list[0] = ch;
	      }	      
	      BinaryStdOut.close();
	   }

	// if args[0] is ’−’, apply move−to−front encoding 
	// if args[0] is ’+’, apply move−to−front decoding
	public static void main(String[] args) {
	
	       if (args[0].equals("-")) 
	          encode();
	       
	       if (args[0].equals("+")) 
	          decode();
	    }
	}
