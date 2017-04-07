public class Ch10_03 {
	
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
	
	static class Status {
		int numTargetNodes;
		Tree lCA;
		Status (int numTargetNodes, Tree lCA) {
			this.numTargetNodes = numTargetNodes;
			this.lCA = lCA;
		}
	}
	
	
	static Status LCA(Tree currNode, Tree targetNode1, Tree targetNode2) {
		if (currNode == null) {
			return new Status(0, null);
		} 
		Status leftSubtreeStatus = LCA(currNode.left, targetNode1, targetNode2);
		Status rightSubtreeStatus = LCA(currNode.right, targetNode1, targetNode2);
		if (targetNode1 == currNode) {
			leftSubtreeStatus.numTarget
		}
		
		
	}
	public static void main(String []args) {
		Tree bT = new Tree(5, new Tree(10, new Tree(8, null, null), new Tree(6, null, null)),
				  new Tree(10, new Tree(6, null, null), new Tree(8, null, null)));
		System.out.println(LCA(bT, bT.left.right, bT.right.left).lCA.value);
	}
	
}
