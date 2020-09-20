// package cs310;
import java.util.Scanner;

public class EditDistance {
// read 2 strings from standard input.
// compute and print the edit distance
// between them and output an optimal
// alignment and associated penalties.


	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		String a = input.nextLine();
		String b = input.nextLine();

		Path path = 	Match.match(a, b);
		     	
		
			System.out.println("Edit distance = " + path.cost);
	        System.out.println();
	        System.out.println("Optimal alignment:");
	        
	        for (Path p = path; p != null; p = p.next) {
	        		if(p.next != null && p.cost == p.next.cost) {
		    	        System.out.println(a.charAt(p.row) + " " + b.charAt(p.col) + " " + '0');
		    	        		}
	        		if(p.next != null && p.cost == p.next.cost + 1) {
			    	    System.out.println(a.charAt(p.row) + " " + b.charAt(p.col) + " " + '1');
	        			}
	        		if(p.next != null && p.cost == p.next.cost + 2) {
			    	    System.out.println(a.charAt(p.row) + " " + "-" + " " + '2');
	        			}
	        }

	}
}