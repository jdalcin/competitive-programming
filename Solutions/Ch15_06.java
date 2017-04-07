import java.util.*;

public class Ch15_06 {
	
	private static class BinaryTreeNode {
		Integer value;
		BinaryTreeNode left, right;
		
		BinaryTreeNode (Integer value, BinaryTreeNode left, BinaryTreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	private static Integer index;
	
	private static BinaryTreeNode createBST(List<Integer> preorderList) {
		index = 1;
		BinaryTreeNode head = preorderList.isEmpty() ? null : new BinaryTreeNode(preorderList.get(0), null, null);
		createBST(head, preorderList, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return head;
	}
	
	private static void createBST(BinaryTreeNode root, List<Integer> preorderList, BinaryTreeNode parent, Integer lowerBound, Integer upperBound) {
		if (root == null) {
			return;
		}
		
		Integer next = preorderList.get(index);
		Integer curr = root.value;
		Integer prev = null;
		if (parent != null) {
			prev = parent.value;
		}
		if (curr > next) {
			root.left = new BinaryTreeNode(next, null, null);
			++index;
		} 
		createBST(root.left, preorderList, root, lowerBound, root.value);
		Integer updatedNext = preorderList.get(index);
		System.out.println(root.value + " " + prev + " " + updatedNext);
		if (prev == null) {
			if (curr < updatedNext) {
				root.right = new BinaryTreeNode(preorderList.get(index), null, null);
				++index;
			}
		} else {
			if (curr < updatedNext && lowerBound < updatedNext && upperBound > updatedNext) {
					root.right = new BinaryTreeNode(preorderList.get(index), null, null);
					index = index < preorderList.size() - 1 ? index + 1 : index;
			}
		}
		createBST(root.right, preorderList, root, root.value, upperBound);
	}
	
	private static void preorderTraversal (BinaryTreeNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preorderTraversal(head.left);
		preorderTraversal(head.right);
	}
	
	public static void main(String []args) {
		List<Integer> preorderList = new ArrayList<Integer>(Arrays.asList(10, 15, 13, 17, 19, 20));
		BinaryTreeNode head = createBST(preorderList);
		preorderTraversal(head);
	}
	
}
