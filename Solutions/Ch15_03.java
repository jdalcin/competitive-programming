public class Ch15_03 {
	
	private static class BinaryTreeNode {
		Integer value;
		BinaryTreeNode left, right;
		
		BinaryTreeNode (Integer value, BinaryTreeNode left, BinaryTreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	//returns the first value larger than a given key, as would appear in an in order traversal, in a BST
	//takes O(h) time complexity and O(1) space complexity
	private static Integer firstKeyLarger(BinaryTreeNode head, Integer key) {
		Integer bestResult = null; // value that is greater than the key, final output is the first of in order tr.
		while (head != null) {
			if (head.value > key) {
				if (bestResult == null || head.value < bestResult) {
					bestResult = head.value;
				}
				head = head.left;
			} else {
				head = head.right;
			}
		}
		return bestResult;
	}
	
	public static void main(String []args) {
		BinaryTreeNode head = new BinaryTreeNode(19, new BinaryTreeNode(7, new BinaryTreeNode(3, 
				new BinaryTreeNode(2, null, null), new BinaryTreeNode(5, null, null)), new BinaryTreeNode(
				11, null, new BinaryTreeNode(17, new BinaryTreeNode(13, null, null), null))),
				new BinaryTreeNode(43, new BinaryTreeNode(23, null, new BinaryTreeNode(37, new BinaryTreeNode(
				29, null, new BinaryTreeNode(31, null, null)), new BinaryTreeNode(41, null, null))), 
				new BinaryTreeNode(47, null, new BinaryTreeNode(53, null, null))));
		System.out.println(firstKeyLarger(head, 23));
	}
}
