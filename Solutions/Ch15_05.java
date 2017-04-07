public class Ch15_05 {
	private static class BinaryTreeNode {
		Integer value;
		BinaryTreeNode left, right;
		
		BinaryTreeNode (Integer value, BinaryTreeNode left, BinaryTreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	//returns LCA for two nodes in a binary search tree
	//takes O(h) time complexity and O(1) space complexity
	private static BinaryTreeNode LCA(BinaryTreeNode head, BinaryTreeNode node1, BinaryTreeNode node2) {
		while (head != null) {
			if (head.value > node1.value && head.value > node2.value) {
				head = head.left;
			} else if (head.value < node1.value && head.value < node2.value) {
				head = head.right;
			} else {
				return head;
			}
		}
		return null;
	}

	public static void main(String []args) {
		BinaryTreeNode head = new BinaryTreeNode(19, new BinaryTreeNode(7, new BinaryTreeNode(3, 
				new BinaryTreeNode(2, null, null), new BinaryTreeNode(5, null, null)), new BinaryTreeNode(
				11, null, new BinaryTreeNode(17, new BinaryTreeNode(13, null, null), null))),
				new BinaryTreeNode(43, new BinaryTreeNode(23, null, new BinaryTreeNode(37, new BinaryTreeNode(
				29, null, new BinaryTreeNode(31, null, null)), new BinaryTreeNode(41, null, null))), 
				new BinaryTreeNode(47, null, new BinaryTreeNode(53, null, null))));
		System.out.println(LCA(head, head.right.right.right, head.right.right).value);
	}
}
