import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ua.princeton.lib.In;
import ua.princeton.lib.StdOut;
import ua.princeton.lib.StdRandom;


public class Tester {
	
	
	private static final String testFile = "8x8.txt";
	
	public Tester()
	{
		In in = new In(testFile);
		Graph G = new Graph(in);
		Stack<Integer> path = new Stack<Integer>();
		int start = 0;
		int pathTo = StdRandom.uniform(G.vert());
//		int pathTo = 4;
		System.out.println("Find path to: \n"+pathTo+"\n");
		
		BFS bfs = new BFS(G, start);

		if (bfs.pathTo(pathTo) == null)
			System.out.println( "This path doen's exist");
		else {
			for (int w : bfs.pathTo(pathTo))
				path.add(w);
			if (path.size()==1) System.out.println("Path (BFS):\nDistance: "+bfs.distance(pathTo)+":\n"+path.pop());
			else {
				System.out.print("Path (BFS):\nDistance: "+bfs.distance(pathTo)+"\n");
//				System.out.println("Visited: "+bfs.visited());
				int upTo = path.size();
			for (int r = 0; r < upTo-1; r++)
				System.out.print(path.pop()+" - ");
				System.out.println(path.pop());
			System.out.println();
			}
		}
		
		
		DFS dfs = new DFS(G, start);
		
		path.clear();
		if (dfs.pathTo(pathTo) == null)
			System.out.println( "This path doen's exist");
		else {
			for (int w : dfs.pathTo(pathTo))
				path.add(w);
			if (path.size()==1) System.out.print("Path (DFS):\nDistance: "+bfs.distance(pathTo)+":\n"+path.pop());
			else {
				System.out.print("Path (DFS):\nDistance: "+dfs.distance(pathTo)+"\n");
//				System.out.println("Visited: "+dfs.visited());
				int upTo = path.size();
			for (int r = 0; r < upTo-1; r++)
				System.out.print(path.pop()+" - ");
				System.out.println(path.pop());
			System.out.println();
			}
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		Tester t = new Tester();
		
	}

}
