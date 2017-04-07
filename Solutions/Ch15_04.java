import java.util.*;

public class Ch15_04 {
	
	private static class BinaryTreeNode {
		Integer value;
		BinaryTreeNode left, right;
		
		BinaryTreeNode (Integer value, BinaryTreeNode left, BinaryTreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	private static List<Integer> kList = new ArrayList<Integer>();;
	
	//returns k largest elements in the binary search tree
	//takes O(h + k) time complexity and O(k) space complexity
	private static void kLargestElements(BinaryTreeNode head, Integer k) {
		kList.clear();
		kLargest(head, k);
	}
	
	private static void kLargest(BinaryTreeNode head, Integer k) {
		if (kList.size() == k || head == null) {
			return;
		}
		kLargest(head.right, k);
		if (kList.size() == k) {
			return;
		} else {
			kList.add(head.value);
		}
		kLargest(head.left, k);
	}
	
	public static void main(String []args) {
		BinaryTreeNode head = new BinaryTreeNode(19, new BinaryTreeNode(7, new BinaryTreeNode(3, 
				new BinaryTreeNode(2, null, null), new BinaryTreeNode(5, null, null)), new BinaryTreeNode(
				11, null, new BinaryTreeNode(17, new BinaryTreeNode(13, null, null), null))),
				new BinaryTreeNode(43, new BinaryTreeNode(23, null, new BinaryTreeNode(37, new BinaryTreeNode(
				29, null, new BinaryTreeNode(31, null, null)), new BinaryTreeNode(41, null, null))), 
				new BinaryTreeNode(47, null, new BinaryTreeNode(53, null, null))));
		kLargestElements(head, 3);
		System.out.println(kList);
	}
}
