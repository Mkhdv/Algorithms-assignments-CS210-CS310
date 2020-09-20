import edu.princeton.cs.algs4.*;



public class DegreesOfSeparationBFS {
	
	public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        String source    = args[2];

        // StdOut.println("Source: " + source);

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.graph();
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.indexOf(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        
        Stack <Object> stack = new Stack <Object>();
        
        
        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            sink = sink.replace("\"", "");
            if (sg.contains(sink)) {
                int t = sg.indexOf(sink);
                StdOut.println(sink + " has a Bacon number of " + bfs.distTo(t)/2);            
                
                if (bfs.hasPathTo(t)) 
                {
                 
                for (int v : bfs.pathTo(t)) {
                		stack.push(sg.nameOf(v));
                }
                
                String hist[] = new String[stack.size()];
          	    int x = 0;
                while (!stack.isEmpty()) {
              		hist[x] = stack.pop().toString();
                		x++;
                }
                        
                for (int i = 0; i < hist.length - 2; i+=2) {
                		StdOut.println(hist[i] + " was in \"" + hist[i+1] + "\" with " + hist[i + 2]);
                }

                }
                else {
                    StdOut.println("Not connected");
                }
            }
            else {
                StdOut.println("   Not in database.");
            }
            
        }
        
	}
	
}