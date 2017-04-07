public class Ch10_01 {
	
	static class Tree {
		int value;
		Tree left;
		Tree right;
		boolean balanced;
		int height;
		Tree(int value, Tree left, Tree right) {
			this.value = value;
			this.right = right;
			this.left = left;
		}
	}
	
	static void changeBalanced(Tree head) {
		int x, y;
		boolean balance = true;
		if(head == null) {
			return;
		}
		changeBalanced(head.left);
		changeBalanced(head.right);
		if (head.left == null && head.right == null) {
			head.height = 0;
			head.balanced = balance;
			return;
		} 
		if (head.left == null) {
			x = 0;
		} else {
			x = head.left.height;
			balance = head.left.balanced;
		}
		if (head.right == null) {
			y = 0;
		} else {
			y = head.right.height;
			if (balance) {
				balance = head.right.balanced;
			}
		}
		
		balance = Math.abs(x-y) <= 1;
		head.balanced = balance;
		head.height = Math.max(x,y) + 1;
	}
	
	static boolean isBalanced(Tree head) {
		changeBalanced(head);
		return head.balanced;
	}
	
	// checks if binary tree is balanced - has O(n) time complexity and O(h) space complexity
	public static void main(String []args) {
		Tree bT = new Tree(5, new Tree(10, new Tree(8, null, null), new Tree(6, null, null)),
				  new Tree(15, new Tree(4, null, null), new Tree(3, null, null)));
		System.out.println(isBalanced(bT));
	}
}
