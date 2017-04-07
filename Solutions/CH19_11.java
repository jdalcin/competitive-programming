import java.util.*; 

public class CH19_11 {
	
	public static class GraphVertex implements Comparable<GraphVertex> {
		String name;
		List<AdjVertexWithDistance> edges;
		int shortestDistanceFromSource;
		int numEdgesFromSource; // num edges from shortest distance from source
		GraphVertex pred; // predecessor vertex with shortest path leading into current node
		
		GraphVertex(String name, List<AdjVertexWithDistance> edges) {
			this.name = name;
			this.edges = edges;
			this.shortestDistanceFromSource = Integer.MAX_VALUE;
			this.pred = null;
			this.numEdgesFromSource = Integer.MAX_VALUE;
		}
		
		@Override
		public int compareTo(GraphVertex other) {
			if (shortestDistanceFromSource < other.shortestDistanceFromSource) {
				return 1;
			} else if (shortestDistanceFromSource > other.shortestDistanceFromSource) {
				return -1;
			} else {
				if (numEdgesFromSource < other.numEdgesFromSource) {
					return 1;
				} else if (numEdgesFromSource > other.numEdgesFromSource) {
					return -1;
				} else {
					return 0;
				}
			}
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			
			GraphVertex that = (GraphVertex) o;
			if (name == that.name) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}
	
	public static class AdjVertexWithDistance {
		GraphVertex adjVertex;
		int weight;
		
		AdjVertexWithDistance(GraphVertex adjVertex, int weight) {
			this.adjVertex = adjVertex;
			this.weight = weight;
		}
	}
	
	//returns shortest path with fewest edges
	public static LinkedList<GraphVertex> shortestPath(GraphVertex source, GraphVertex sink) {
		PriorityQueue<GraphVertex> minHeap = new PriorityQueue<GraphVertex>();
		LinkedList<GraphVertex> shortestPath = new LinkedList<GraphVertex>();
		Set<GraphVertex> traversedVertices = new HashSet<GraphVertex>();
		source.shortestDistanceFromSource = 0;
		source.numEdgesFromSource = 0;
		minHeap.add(source);
		while (!minHeap.isEmpty()) {
			GraphVertex current = minHeap.remove();
			traversedVertices.add(current);
			for (AdjVertexWithDistance edge : current.edges) {
				if (!traversedVertices.contains(edge.adjVertex)) {
					if (current.shortestDistanceFromSource + edge.weight <= edge.adjVertex.shortestDistanceFromSource) {
						if (current.shortestDistanceFromSource + edge.weight < edge.adjVertex.shortestDistanceFromSource) {
							edge.adjVertex.shortestDistanceFromSource = current.shortestDistanceFromSource + edge.weight;
						}
						if (current.numEdgesFromSource < edge.adjVertex.numEdgesFromSource) {
							edge.adjVertex.numEdgesFromSource = current.numEdgesFromSource + 1;
						}
						edge.adjVertex.pred = current;
					}
					minHeap.add(edge.adjVertex);
				}
			}
		}
		shortestPath.add(sink);
		GraphVertex minPath = sink.pred;
		while (minPath.pred != null) {
			shortestPath.add(minPath);
			minPath = minPath.pred;
		}
		shortestPath.add(source);
		Collections.reverse(shortestPath);
		return shortestPath;
	}
	
	public static void main(String[] args) {
		//create graph
		GraphVertex A = new GraphVertex("A", new LinkedList<AdjVertexWithDistance>());
		GraphVertex B = new GraphVertex("B", new LinkedList<AdjVertexWithDistance>());
		GraphVertex C = new GraphVertex("C", new LinkedList<AdjVertexWithDistance>());
		GraphVertex D = new GraphVertex("D", new LinkedList<AdjVertexWithDistance>());
		GraphVertex E = new GraphVertex("E", new LinkedList<AdjVertexWithDistance>());
		GraphVertex F = new GraphVertex("F", new LinkedList<AdjVertexWithDistance>());
		GraphVertex G = new GraphVertex("G", new LinkedList<AdjVertexWithDistance>());
		A.edges.addAll(Arrays.asList(new AdjVertexWithDistance(C, 2), new AdjVertexWithDistance(D, 2)));
		B.edges.addAll(Arrays.asList(new AdjVertexWithDistance(C, 2), new AdjVertexWithDistance(F, 3)));
		C.edges.addAll(Arrays.asList(new AdjVertexWithDistance(A, 2), new AdjVertexWithDistance(B, 2), new AdjVertexWithDistance(E, 3), new AdjVertexWithDistance(D, 1)));
		D.edges.addAll(Arrays.asList(new AdjVertexWithDistance(A, 2), new AdjVertexWithDistance(C, 1), new AdjVertexWithDistance(G, 1)));
		E.edges.addAll(Arrays.asList(new AdjVertexWithDistance(C, 3), new AdjVertexWithDistance(E, 1)));
		F.edges.addAll(Arrays.asList(new AdjVertexWithDistance(B, 3), new AdjVertexWithDistance(E, 1), new AdjVertexWithDistance(G, 1)));
		G.edges.addAll(Arrays.asList(new AdjVertexWithDistance(D, 1), new AdjVertexWithDistance(F, 1)));
		//output path with shortest path and fewest edges
		LinkedList<GraphVertex> shortestPath = shortestPath(A, E);
		for (GraphVertex vertex : shortestPath) {
			System.out.print(vertex.name + " ");
		}
	}
}
