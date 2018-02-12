import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;




public class BFS {

	
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private int s, visitedNodes;
	
	
	public BFS(Graph G, int s){
		
	 marked = new boolean[G.vert()];
     distTo = new int[G.vert()];
     edgeTo = new int[G.vert()];
     this.s = s;
     bfs(G, s);
     
	}
	
	
	private void bfs(Graph G, int s)
	{
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
 
		q.engueue(s);
		this.s = s;
		marked[s] = true;
		distTo[s] = 0;
		while (!q.isEmpty())
		{
			int v = q.dequeue();
			
			for (int w : G.adj(v))
			{
				if (!marked[w])
				{
					q.engueue(w);
 
					marked[w] = true;
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
				}
			}
		}
	}
	
	 public boolean hasPathTo(int v) {
	        return marked[v];
	    }
	 
	 public Iterable<Integer> pathTo(int v) {
	        if (!hasPathTo(v)) return null;
	        Stack<Integer> path = new Stack<Integer>();
	        for (int x = v; x != s; x = edgeTo[x])
	        {
	            path.push(x);
	        }
	        path.push(s);
	        return path;
	    }
	 
	 public int visited()
	 {
		 return visitedNodes;
	 }
	 
	public int distance(int v)
	{
		return distTo[v];
	}
	
}

