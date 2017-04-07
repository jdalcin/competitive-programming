import java.util.*;

public class Graph2 {
	//vertices must be from <0, 1, 2,..., n>
	
	private static int V; //size of array in graph
	private static List<List<Integer>> adj = new ArrayList<List<Integer>>(V);
	
	//structure to represent a graph
	Graph2 (int VSize) {
		V = VSize;
		
		for (int i = 0; i < V; i++) {
			adj.add(new LinkedList<Integer>());
		}
	}
	
	//function to add edge into graph
	private static void addEdge(int v, int u) {
		if (v > V) {
			adj.add(new LinkedList<Integer>());
			V = v;
		}
		adj.get(v).add(u);
	}
	
	//function to do DFS starting from vertex v of your choice. Nodes must be connected to v.
	private static void DFS(int v) {
		//mark all vertices as not visited
		boolean[] visited = new boolean[V];
		
		DFSUtil(v, visited);
	}
	
	// function used by DFS
	private static void DFSUtil(int v, boolean[] visited) {
		//mark the current node as visited and print
		visited[v] = true;
		System.out.print(v + " ");
		
		//Recur for all vertices adjacent to the vertex
		Iterator<Integer> i = adj.get(v).listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	//vertices adjacent to given vertex
	private static void adjacencies(int v) {
		
		Iterator<Integer> i = adj.get(v).listIterator();
		System.out.println ("Vertices adjacent to " + v + ": ");
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}
	
	public static void main(String []args) {
		Graph2 graph = new Graph2(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3); 
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);
		
		DFS(0);
		System.out.println();
		adjacencies(1);
		
	}
	
	
	
}
