import java.util.*;

public class Ch18_01 {
	
	public static List<Symbol> codeBook = new ArrayList<Symbol>();
	
	public static class Symbol {
		Character c;
		Double prob; // in percentage
		String code;
		String bitCode;
		Double bitSize;
		
		Symbol(Character c, Double prob) {
			this.c = c;
			this.prob = prob;
			this.code = c.toString();
		}
		
		Symbol(String code, Double prob) {
			this.code = code;
			this.prob = prob;
		}
		
	}
	
	public static class BinaryNode<Symbol> implements Comparable<BinaryNode<Symbol>>{
		BinaryNode<Symbol> left;
		BinaryNode<Symbol> right;
		Ch18_01.Symbol sym;
		
		BinaryNode(Ch18_01.Symbol sym, BinaryNode<Symbol> left, BinaryNode<Symbol> right) {
			this.sym = sym;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public int compareTo(BinaryNode<Symbol> node) {
			return Double.compare(sym.prob, node.sym.prob);
		}
	}
	
	public static List<BinaryNode<Symbol>> binaryNodeList(List<Symbol> symbols) {
		List<BinaryNode<Symbol>> binaryNodeList = new ArrayList<>();
		for (int i = 0; i < symbols.size(); i++) {
			binaryNodeList.add(new BinaryNode<Symbol>(symbols.get(i), null, null));
		}
		return binaryNodeList;
	}
	
	public static BinaryNode<Symbol> createCodeBook(List<Symbol> symbols) {
		PriorityQueue<BinaryNode<Symbol>> minHeap = new PriorityQueue<BinaryNode<Symbol>>();
		List<BinaryNode<Symbol>> symbolNodes = binaryNodeList(symbols);
		for (int i = 0; i < symbolNodes.size(); i++) {
			minHeap.add(symbolNodes.get(i));
		}
		BinaryNode<Symbol> rightChild = null;
		BinaryNode<Symbol> leftChild = null;
		BinaryNode<Symbol> root = null;
		while(minHeap.size() > 1) {
			rightChild = minHeap.remove();
			leftChild = minHeap.remove();
			root = new BinaryNode<Symbol>(new Symbol(leftChild.sym.code + rightChild.sym.code, 
					leftChild.sym.prob + rightChild.sym.prob),
					leftChild, rightChild);
			minHeap.add(root);
		}
		return root;
	}
	
	//assigns bit code to strings
	public static void assignCodes(String code, BinaryNode<Symbol> root) {
		if (root.left == null && root.right == null) {
			root.sym.bitCode = code;
			System.out.println(root.sym.c + ": " + root.sym.bitCode);
			codeBook.add(root.sym);
			return;
		} else {
			assignCodes(code + "1", root.left);
			assignCodes(code + "0", root.right);
		}
	}
	
	public static void inOrderTraversal(BinaryNode<Symbol> root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.println(root.sym.code);
		inOrderTraversal(root.right);
	}
	
	public static void preOrderTraversal(BinaryNode<Symbol> root) {
		if (root == null) {
			return;
		}
		System.out.println(root.sym.code);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	public static Double smallestAverageCodeLength(List<Symbol> symbols) {
		BinaryNode<Symbol> head = createCodeBook(symbols);
		//preOrderTraversal(head);
		assignCodes("", head);
		Double averageCodeLength = 0.;
		for (Symbol sym : codeBook) {
			averageCodeLength += (sym.bitCode.length() * (sym.prob / 100));
		}
		System.out.println();
		return averageCodeLength;
	}
	
	public static void main(String []args) {
		/*List<Symbol> symbols = new ArrayList<Symbol> (Arrays.asList(new Symbol('a', 8.17), 
				new Symbol('b', 1.49), new Symbol('c', 2.78), new Symbol('d', 4.25), new Symbol
				('e', 12.70), new Symbol('f', 50.00)));*/
		List<Symbol> symbols = new ArrayList<Symbol> (Arrays.asList(new Symbol('a', 8.17), 
				new Symbol('b', 1.49), new Symbol('c', 2.78), new Symbol('d', 4.25), new Symbol
				('e', 12.70), new Symbol('f', 2.23), new Symbol('g', 2.02), new Symbol('h', 6.09),
				new Symbol('i', 6.97), new Symbol('j',.15), new Symbol('k', .77), new Symbol('l', 4.03),
				new Symbol('m', 2.41), new Symbol('n', 6.75), new Symbol('o', 7.51), new Symbol('p', 1.93),
				new Symbol('q', .1), new Symbol('r', 5.99), new Symbol('s', 6.33), new Symbol('t', 9.06),
				new Symbol('u', 2.76), new Symbol('v', .98), new Symbol('w', 2.36), new Symbol('x', .15),
				new Symbol('y', 1.97), new Symbol('z', .07)));
		System.out.println(smallestAverageCodeLength(symbols));
	}
	
}
