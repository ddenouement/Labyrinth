import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ua.princeton.lib.In;



public class Graph {

	private final int V;
	private final int vert;
	private int[] vertices;
	Bag<Integer>[] adj;
	
	
	public Graph (int n)
	{
		V = n;
		vert = V*V;
		vertices = new int[vert];
		adj = (Bag<Integer>[]) new Bag[vert];
		for (int v=0; v<vert; v++)
			adj[v] = new Bag<Integer>();
	}
	
	
	public Graph(In in) {
        try {
            this.V = in.readInt();
            vert = V*V;
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = (Bag<Integer>[]) new Bag[vert];
            for (int v = 0; v < vert; v++) {
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }
	
	private void validateVertex(int v) {
        if (v < 0 || v >= vert)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public int V() {
		return V;
	}
	
	public int vert(){
		return vert;
	}
		
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	
	

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		
		
		
		
	}
	
	
}
