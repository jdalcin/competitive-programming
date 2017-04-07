import java.util.*;

public class Ch15_01B {
	
	private static class BinaryTreeNode {
		Integer value;
		BinaryTreeNode left, right;
		
		BinaryTreeNode (Integer value, BinaryTreeNode left, BinaryTreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	private static class QueueEntry {
		BinaryTreeNode node;
		Integer lowerBound, upperBound;
		
		QueueEntry (BinaryTreeNode node, Integer lowerBound, Integer upperBound) {
			this.node = node;
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
	}
	
	// checks if nodes exhibit the binary search tree property - takes O(b) space complexity and O(n) time 
	// complexity, where b is number of nodes along base of tree and n is the number of nodes
	// On cases where the violation occurs on a small depth, this method runs fast
	private static boolean isBinaryTree(BinaryTreeNode head) {
		if (head == null) {
			return false;
		}
		Queue<QueueEntry> BFSQueue = new LinkedList<QueueEntry>();
		BFSQueue.add(new QueueEntry(head, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		while (!BFSQueue.isEmpty()) {
			QueueEntry currEntry = BFSQueue.poll();
			BinaryTreeNode leftChild = currEntry.node.left;
			BinaryTreeNode rightChild = currEntry.node.right;
			
			if (currEntry.node.value <= currEntry.lowerBound || currEntry.node.value >= currEntry.upperBound) {
				return false;
			}
			if (leftChild != null) {
				BFSQueue.add(new QueueEntry(leftChild, currEntry.lowerBound, currEntry.node.value));
			}
			if (rightChild != null) {
				BFSQueue.add(new QueueEntry(rightChild, currEntry.node.value, currEntry.upperBound));
			}
		}
		return true;
	}
	
	private static boolean isBinaryTreeRecursion(BinaryTreeNode head) {
		return head == null ? false : checkBinaryTreeRecursion(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private 4static boolean checkBinaryTreeRecursion(BinaryTreeNode root, Integer lowerBound, Integer upperBound) {
		//base cases
		if (root == null) {
			return true;
		}
		if (root.value <= lowerBound || root.value >= upperBound) {
			return false;
		}
		
		return checkBinaryTreeRecursion(root.left, lowerBound, root.value) && 
				checkBinaryTreeRecursion(root.right, root.value, upperBound);
		
	}
	
	public static void main(String []args) {
		BinaryTreeNode BT = new BinaryTreeNode(10, new BinaryTreeNode(5, new BinaryTreeNode(3, null, null),
				new BinaryTreeNode(7, null, null)), new BinaryTreeNode(15, new BinaryTreeNode(13, null, null),
				new BinaryTreeNode(20, null, new BinaryTreeNode(25, null, null))));
		System.out.println(isBinaryTreeRecursion(BT));
		System.out.println(isBinaryTree(BT));
	}
}
