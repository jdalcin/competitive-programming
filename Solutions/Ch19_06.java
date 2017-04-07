import java.util.*;

public class Ch19_06 {
	
	public static class GraphVertex {
		String name;
		List<GraphVertex> edges;
		
		GraphVertex(String name, List<GraphVertex> edges) {
			this.name = name;
			this.edges = edges;
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
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}
	
	public static void BFSOutputGraph(GraphVertex head) {
		Queue<GraphVertex> queue = new LinkedList<GraphVertex>();
		Set<GraphVertex> set = new HashSet<GraphVertex>();
		queue.add(head);
		set.add(head);
		while(!queue.isEmpty()) {
			GraphVertex current = queue.poll();
			System.out.print(current.name + " ");
			for (GraphVertex adjVertex : current.edges) {
				if (!set.contains(adjVertex)) {
					queue.add(adjVertex);
					set.add(adjVertex);
				}
			}
		}
	}
	
	public static GraphVertex cloneGraph(GraphVertex head) {
		if (head == null) {
			return null;
		}
		Map<String, GraphVertex> table = new Hashtable<String, GraphVertex>();
		cloneGraphHelper(head, table);
		return table.get(head.name);
	}
	
	public static void cloneGraphHelper(GraphVertex current, Map<String, GraphVertex> table) {
		if (table.containsKey(current.name)) {
			return;
		}
		GraphVertex cloneCurrent = new GraphVertex(new String(current.name), new LinkedList<GraphVertex>());
		for (GraphVertex adjVertex : current.edges) {
			cloneCurrent.edges.add(adjVertex);
		}
		table.put(cloneCurrent.name, cloneCurrent);
		for (GraphVertex adjVertex : current.edges) {
			cloneGraphHelper(adjVertex, table);
		}
	}
	
	public static void main(String[] args) {
		//create graph
		GraphVertex A = new GraphVertex("A", new LinkedList<GraphVertex>());
		GraphVertex B = new GraphVertex("B", new LinkedList<GraphVertex>());
		GraphVertex C = new GraphVertex("C", new LinkedList<GraphVertex>());
		GraphVertex D = new GraphVertex("D", new LinkedList<GraphVertex>());
		GraphVertex E = new GraphVertex("E", new LinkedList<GraphVertex>());
		GraphVertex F = new GraphVertex("F", new LinkedList<GraphVertex>());
		A.edges.addAll(Arrays.asList(B, C, D));
		B.edges.add(E);
		C.edges.add(F);
		//output original graph and its clone
		BFSOutputGraph(A);
		System.out.println();
		GraphVertex clone = cloneGraph(A);
		BFSOutputGraph(clone);
	}
}
