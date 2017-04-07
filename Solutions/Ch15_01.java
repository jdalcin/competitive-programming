
public class Ch15_01 {
	
	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	private static class isBSNode {
		boolean isBS;
		Node prevNode;
		
		isBSNode(boolean isBS, Node prevNode) {
			this.isBS = isBS;
			this.prevNode = prevNode;
		}
	}
	
	//checks if tree is BSTree  - takes O(n) time complexity and O(h) space complexity
	public static boolean isBSTree(Node root) {
		return root == null ? false : checkBSTree(root, null).isBS;
	}
	
	public static isBSNode checkBSTree(Node root, Node prevRoot) {
		if (root == null) {
			return new isBSNode(true, prevRoot);
		}
		
		isBSNode isLeftBS = checkBSTree(root.left, root);
		
		boolean isBS = true;
		if (isLeftBS.prevNode != root) {
			isBS = root.value > isLeftBS.prevNode.value;
			System.out.print(isBS + " " + isLeftBS.prevNode.value + " ");
			isLeftBS.prevNode.value = root.value;
		}
		System.out.print(isLeftBS.prevNode.value);
		System.out.println();
		isBSNode isRightBS = checkBSTree(root.right, root);
		return new isBSNode(isBS, isRightBS.prevNode);
	}
	
	public static void main(String []args) {
		Node BSTree = new Node(10, new Node(5, new Node(3, null, null), new Node(6, null, null)),
					  new Node(20, new Node(15, null, null), new Node(25, new Node(18, null, null), null)));
		System.out.println(isBSTree(BSTree));
	}
}
