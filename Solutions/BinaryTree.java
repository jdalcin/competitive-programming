/*---------------------
Author: Jeremy Dalcin
Class: Binary Search tree which searches through nodes in order, pre order, or post order. 
Finds node based on key. Has O(logn) time complexity if balanced. Also can delete entries from the tree.
---------------------*/

public class BinaryTree{

	Node root;
	
	public void addNode(int key, String name){
		
		Node newNode = new Node(key, name);
		
		if (root == null){
			
			root = newNode;
			
		} else{
			
			Node focusNode = root; //root we begin focusing on
			
			Node parent;
			
			while(true){
				
				parent = focusNode;
				
				if(key < focusNode.key){
					
					focusNode = focusNode.leftChild; // one leaf below parent
					
					if(focusNode == null){
						
						parent.leftChild = newNode;
						return;
					}
				}
				// assume parent key is never equal to its child (what to do when things are equal)
				if(key > focusNode.key){
					
					focusNode = focusNode.rightChild;
					
					if(focusNode == null){
						
						parent.rightChild = newNode;
						return;
					}
				}
			} //end of while loop
		}//end of if
	} // end of addnode
	
	public void inOrderTraverseTree(Node focusNode){
		
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void preOrderTraverseTree(Node focusNode){
		
		if(focusNode != null){
			
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
			
		}
	}
		
	public void postOrderTraverseTree(Node focusNode){
		
		if(focusNode != null){
			
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
			
		}
	}
	
	public Node findNode(int key){
		
		Node focusNode = root; //starts at top of tree
		
		while(focusNode.key != key){
			
			if(key < focusNode.key){
				
				focusNode = focusNode.leftChild;
				
			} else if (key > focusNode.key) {
				
				focusNode = focusNode.rightChild;
				
			}
			
			if (focusNode == null){
				
				return null;
				
			}	
		}
		
		return focusNode;
			
	}
	
	
	public static void main(String[] args) {
		
		BinaryTree Tree = new BinaryTree();
		
		Tree.addNode(10, "Boss");
		Tree.addNode(12, "Vice Pres");
		Tree.addNode(5, "Secretary");
		Tree.addNode(3, "Worker Bee");
		Tree.addNode(4, "Pawn");
		Tree.addNode(11, "Overlord");
		Tree.addNode(2, "Billy");
		Tree.addNode(6, "Gabby");
		Tree.addNode(7, "Nelson");
		Tree.addNode(8, "Raven");
		
		//System.out.println(Tree.root);
		System.out.println("in order traversal of nodes: ");
		System.out.println();
		Tree.inOrderTraverseTree(Tree.root);
		System.out.println("------------------------");
		
		System.out.println("pre order traversal of nodes: ");
		System.out.println();
		Tree.preOrderTraverseTree(Tree.root);
		System.out.println("------------------------");
		
		System.out.println("post order traversal of nodes: ");
		System.out.println();
		Tree.postOrderTraverseTree(Tree.root);
		System.out.println("------------------------");
		System.out.println("Who has 100?");
		Node searched = Tree.findNode(100);
		
		System.out.println(searched.toString() );
		

	}

}


class Node{
	
	int key; //key value for node
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name){
		
		this.key = key;
		this.name = name;
	}
	
	public String toString(){
		
		return name + " has a key " + key;
	}
}