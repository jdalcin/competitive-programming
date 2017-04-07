import java.util.*;

public class GraphMatrix {
	//produces an adjacency matrix to implement a graph
	
	private static int V; //number of vertices in the graph
	private static List<int[]> adjacencyMatrix = new ArrayList<int[]>(V);
	
	GraphMatrix(int VSize) {
		V = VSize;
		
		for (int i = 0; i < V; i++) {
			adjacencyMatrix.add(new int[V]);
		}
	}
	
	private static void addEdge(int v, int u) {
		if (v > V || u > V) {
			System.out.println("You cannot connect edges for vertices that are not yet in the graph");
		}
		adjacencyMatrix.get(v)[u] += 1;
	}
	
	/*private static void addNode(int v) {
		if (v > V + 1 || v < 0) {
			System.out.println("Can only add node valued " + V + 1);
		}
		if (v <= V) {
			System.out.println("Node is already in the graph.");
		}
		V = v;
		adjacencyMatrix.add(new int[V]);
		for (int i = 0; i < adjacencyMatrix.size() - 1; i++) {
			adjacencyMatrix.get(i)[V - 1];
		} */
	
	private static void printGraph(GraphMatrix graph) {
		List<int[]> graphMatrix = graph.adjacencyMatrix;
		System.out.print("  ");
		for (int i = 0; i < graph.V; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n  ------------------");
		int count = 0;
		for (int[] row : graphMatrix) {
			System.out.print(count++ + "|");
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String []args) {
		GraphMatrix graph = new GraphMatrix(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);
		printGraph(graph);
	}
}
