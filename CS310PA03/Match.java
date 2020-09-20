//package cs310;
public class Match {
 
    
    public static Path match(String a, String b) {
    int m = a.length() + 1;
    int n = b.length() + 1;

    Path[][] opt = new Path [m][n];
    Path first = new Path();;
    Path last = new Path();

    for(int i = 0; i < m; i++) { //!
    		last = new Path();
    		last.row = i;
    		last.col = n-1;
    		if(first == null) { first = last; }
    		opt[i][n-1] = last;

    		opt[i][n-1].cost = 2 * (m-i-1);

    }
    
    System.out.println();
    
    for(int j = 0; j < n; j++) {
		last = new Path();
		last.row = m - 1;
		last.col = j;
		if(first == null) { first = last; }
		opt[m-1][j] = last;
		opt[m-1][j].cost = 2 * (n-j-1);
		
    }
    
    for(int i = m-2; i >= 0; i--) {
    		for(int j = n-2; j >= 0; j--) {
    			last = new Path();
    			last.row = i;
    			last.col = j;
    			if(first == null) { first = last; }
    			opt[i][j] = last;
    			opt[i][j].cost = penalty(a.charAt(i), b.charAt(j));
    			
    		}
    }
	  
    for(int i = m-2; i >= 0; i--) {
		for(int j = n-2; j >= 0; j--) {
			opt[i][j].cost = min(opt[i + 1][j + 1].cost + (a.charAt(i) == b.charAt(j) ? 0 : 1), 
					opt[i+1][j].cost + 2, opt[i][j+1].cost + 2);
			
			if(opt[i][j].cost == opt[i + 1][j + 1].cost) { opt[i][j].next = opt[i+1][j+1]; }
			if(opt[i][j].cost == opt[i + 1][j + 1].cost + 1) { opt[i][j].next = opt[i+1][j+1]; }
			if(opt[i][j].cost == opt[i+1][j].cost + 2) { opt[i][j].next = opt[i+1][j]; }
			if(opt[i][j].cost == opt[i][j+1].cost + 2) { opt[i][j].next = opt[i][j+1]; }
						
			opt[i][j].col = j;
			opt[i][j].row = i;

		}
	}
        return opt[0][0];    
    }
    
 
    private static int penalty(char a, char b) {
    	if(a == b) {
    		return 0;
    	}
    		return 1;
    }

    private static int min(int a, int b, int c) {
    	
    	return Math.min(Math.min(a, b), c);
    }

    
    
    
    public static void main(String[] args) {
        Path path = Match.match("AACAGTTACC", "TAAGGTCA");
        for (Path p = path; p != null; p = p.next)
            System.out.println(p.row + " " + p.col + " " + p.cost);
    }
}
