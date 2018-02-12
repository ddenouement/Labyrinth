import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;




public class DFS {

	
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private int s, visitedNodes;
	
	
	public DFS(Graph G, int s){
		
	 marked = new boolean[G.vert()];
     distTo = new int[G.vert()];
     edgeTo = new int[G.vert()];
     this.s = s;
     dfs(G, s);
     
	}
	
	
	private void dfs(Graph G, int s)
	{
		Stack<Integer> st = new Stack<Integer>();
	 
		st.add(s);
		this.s = s;
		marked[s] = true;
		distTo[s] = 0;
		
		while (!st.isEmpty())
		{
			int v = st.pop();
			
			for (int w : G.adj(v))
			{
				if (!marked[w])
				{
					st.add(w);
	 
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

