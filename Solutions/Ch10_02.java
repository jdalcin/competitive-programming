public class Ch10_02 {
	
	static class Tree {
		int value;
		Tree left;
		Tree right;
		Tree(int value, Tree left, Tree right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	// checks if a binary tree is symmetric - takes O(n) time complexity and O(h) space complexity
	static boolean checkSymmetric(Tree leftNode, Tree rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}
		if (leftNode == null || rightNode == null) {
			return false;
		}
		boolean symmetry1 = checkSymmetric(leftNode.left, rightNode.right);
		boolean symmetric = leftNode.value == rightNode.value;
		boolean symmetry2 = checkSymmetric(leftNode.right, rightNode.left);
		return symmetric && symmetry1 && symmetry2;
	}
	
	static boolean isSymmetric(Tree head) {
		return head != null && checkSymmetric(head.left, head.right);
	}
	
	public static void main(String []args) {
		Tree bT = new Tree(5, new Tree(10, new Tree(8, null, null), new Tree(6, null, null)),
				  new Tree(10, new Tree(6, null, null), new Tree(8, null, null)));
		System.out.println(isSymmetric(bT));
	}
	
}
