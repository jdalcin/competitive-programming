import java.util.*;

public class Ch17_practice {
	
	private static class Node {
		int value;
		Node right;
		Node left;
		
		Node(int value, Node left, Node right) {
			this.right = right;
			this.left = left;
			this.value = value;
		}
	}
	
	private static void BFS(Node head) {
		Set<Node> hash = new HashSet<Node>();
		
		BFSUtil(head, hash);
	}
	
	private static void BFSUtil(Node head, Set<Node> hash) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		hash.add(head);
		while (!queue.isEmpty()) {
			Node root = queue.poll();
			System.out.print(root.value + " ");
			if (root.left != null && !hash.contains(root.left)) {
				queue.add(root.left);
				hash.add(root.left);
			}
			if (root.right != null && !hash.contains(root.right)) {
				queue.add(root.right);
				hash.add(root.right);
			}
		}
	}
	
	private static void DFS(Node head) {
		Set<Node> hash = new HashSet<Node>();
		
		DFSUtil(head, hash);
	}
	
	private static void DFSUtil(Node head, Set<Node> hash) {
		if (head == null || hash.contains(head)) {
			return;
		}
		
		System.out.print(head.value + " ");
		hash.add(head);
		DFSUtil(head.left, hash);
		DFSUtil(head.right, hash);
	}
	
	private static void iteratorPractice(List<Integer> list) {
		Iterator<Integer> p1 = list.listIterator();
		while(p1.hasNext()) {
			System.out.print(p1.next() + " ");
		}
		System.out.println();
	}
	
	private static class Graph {
		private int V;
		private List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
		
		Graph(int V) {
			this.V = V;
			for (int i = 0; i < V; i++) {
				adjacencyList.add(new LinkedList<Integer>());
			}
		}
		
		private void addEdge(Integer v, Integer u) {
				adjacencyList.get(v).add(u);
		}
		
		private void addNode() {
				adjacencyList.add(new LinkedList<Integer>());
		}
		
		private void DFS(Integer v) {
			Set<Integer> hash = new HashSet<Integer>();
			System.out.print("DFS: ");
			DFSUtil(v, hash);
			System.out.println();
		}
		
		private void DFSUtil(Integer v, Set<Integer> hash) {
			if (hash.contains(v)) {
				return;
			}
			System.out.print(v + " ");
			hash.add(v);
			Iterator<Integer> p1 = adjacencyList.get(v).listIterator();
			while (p1.hasNext()) {
				DFSUtil(p1.next(), hash);
			}
		}
		
		private void BFS(Integer v) {
			Set<Integer> hash = new HashSet<Integer>();
			
			BFSUtil(v, hash);
		}
		
		private void BFSUtil(Integer v, Set<Integer> hash) {
			Queue<Iterator<Integer>> queue = new LinkedList<Iterator<Integer>>();
			Iterator<Integer> vertexSuccessors = adjacencyList.get(v).listIterator();
			queue.add(vertexSuccessors);
			System.out.print("BFS: " + v + " ");
			hash.add(v);
			while(!queue.isEmpty()) {
				vertexSuccessors = queue.poll();
				while (vertexSuccessors.hasNext()) {
					Integer vertex = vertexSuccessors.next();
					if (!hash.contains(vertex)) {
						System.out.print(vertex + " ");
						queue.add(adjacencyList.get(vertex).listIterator());
						hash.add(vertex);
					}
				}
			}
			System.out.println();
		}
		private void printAdjacencyList() {
			for (int i = 0; i < adjacencyList.size(); i++) {
				Iterator<Integer> p1 = adjacencyList.get(i).listIterator();
				System.out.println("Successor vertices of " + i + ":");
				while (p1.hasNext()) {
					System.out.print(p1.next() + " ");
				}
				System.out.println();
			}
		}
		
	}
	
	public static void main(String []args) {
		Node graphHead = new Node(0, new Node(1, null, new Node(2, null, new Node(3, null, null))), 
				new Node(4, null, null));
		graphHead.left.right.left = graphHead;
		graphHead.right.right = graphHead.left.right;
		System.out.print("DFS: "); DFS(graphHead);
		System.out.println();
		System.out.print("BFS: "); BFS(graphHead);
		List<Integer> list = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println();
		System.out.print("Iterator: "); iteratorPractice(list);
		
		System.out.println("\n");
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(4, 2);
		graph.printAdjacencyList();
		System.out.println("\n");
		graph.DFS(0);
		graph.BFS(0);
	}
	
}
