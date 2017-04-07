import java.util.*;

public class Ch19_05 {
	
	public static enum Color {WHITE, BLACK};
	
	public static class GraphVertex {
		Color color;
		List<GraphVertex> edges;
		
		GraphVertex(Color color, List<GraphVertex> edges) {
			this.color = color;
			this.edges = edges;
		}
	}
	
	//assumes vertex inputted is within a connected graph
	public static boolean isMinimallyConnected(GraphVertex vertex) {
		if (vertex == null) {
			return false;
		}
		return !hasCycle(vertex);
	}
	
	public static boolean hasCycle(GraphVertex vertex) {
		if (vertex.color == Color.BLACK) {
			return true;
		}
		vertex.color = Color.BLACK;
		boolean isCycle = false;
		for (GraphVertex adjVertex : vertex.edges) {
			if (!isCycle) {
				isCycle = hasCycle(adjVertex);
			}
		}
		return isCycle;
	}
	
	public static void main(String[] args) {
		//create graph
		GraphVertex A = new GraphVertex(Color.WHITE, new LinkedList<GraphVertex>());
		GraphVertex B = new GraphVertex(Color.WHITE, new LinkedList<GraphVertex>());
		GraphVertex C = new GraphVertex(Color.WHITE, new LinkedList<GraphVertex>());
		GraphVertex D = new GraphVertex(Color.WHITE, new LinkedList<GraphVertex>());
		GraphVertex E = new GraphVertex(Color.WHITE, new LinkedList<GraphVertex>());
		GraphVertex F = new GraphVertex(Color.WHITE, new LinkedList<GraphVertex>());
		A.edges.addAll(Arrays.asList(B, C, D));
		B.edges.add(E);
		C.edges.add(F);
		E.edges.add(A);
		//outputs if graph is minimally connected
		System.out.println(isMinimallyConnected(A));
	}
}
