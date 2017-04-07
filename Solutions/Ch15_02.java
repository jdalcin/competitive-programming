public class Ch15_02 {
	
	private static class BinaryTreeNode {
		Integer value;
		String name;
		BinaryTreeNode left, right;
		
		BinaryTreeNode (Integer value, String name, BinaryTreeNode left, BinaryTreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.name = name;
		}
	}
	
	//finds first occurrence of a value in a binary search tree, as it would be outputted in an inOrderTraversal,
	// takes O(h) time complexity and O(1) space complexity
	private static String firstOccurrence(BinaryTreeNode head, Integer value) { 
		while (head != null) {
			if (head.value < value) {
				head = head.right;
			} else if (head.value > value) {
				head = head.left;
			} else {
				if (head.left != null && head.left.value == value) {
					head = head.left;
				} else {
					return head.name;
				}
			}
		}
 		return null;
	}
	
	public static void main(String []args) {
		BinaryTreeNode head = new BinaryTreeNode(108, "A", new BinaryTreeNode(108, "B", new BinaryTreeNode(
				-10, "C", new BinaryTreeNode(-14, "D", null, null), new BinaryTreeNode(2, "E", null, null))
				, new BinaryTreeNode(108, "F", null, null)), new BinaryTreeNode(285, "G", new BinaryTreeNode(
				243, "H", null, null), new BinaryTreeNode(285, "I", null, new BinaryTreeNode(401, "J", null,
						null))));
		System.out.println(firstOccurrence(head, 285));
	}
}
