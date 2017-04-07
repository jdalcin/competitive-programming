/*---------------
 * Author: Jeremy Dalcin
 * Class: Create a Binary Search Tree on my own. Assumes all distinct keys.
 */
public class BinarySearchTree {
	
	Node5 root;
	
	void add(int data){
		Node5 p = new Node5(data);
		
		if(root == null){
			root = p;
		} else{
			Node5 focusNode = root;
			while(true){
				//focuses on nodes left of parent node
				if(data < focusNode.data){
					if(focusNode.leftChild != null){
						/*if(focusNode.leftChild.data > focusNode.data){
							Node5 parent = focusNode;
							focusNode = focusNode.leftChild;
							parent.leftChild = p;
							p.rightChild = focusNode;
							return;
						} else{*/
							focusNode = focusNode.leftChild;
						//}
					} else{
						focusNode.leftChild = p;
						return;
					}
				} else if(data > focusNode.data){//focuses on nodes to right of parent node
					if(focusNode.rightChild != null){
						/*if(focusNode.rightChild.data < focusNode.data){
							Node5 parent = focusNode;
							focusNode = focusNode.rightChild;
							parent.rightChild = p;
							p.leftChild = focusNode;
							return;
						} else{*/
							focusNode = focusNode.rightChild;
						//}
				    } else{
						focusNode.rightChild = p;
						return;
					}
					
			    }
			}
		}
	}
	
	void remove(int data){
		Node5 focusNode = root;
		if(root == null){
			System.out.println("Nothing to remove. Tree is null.");
		} else if(data == root.data && root.leftChild == null && root.rightChild == null){
			root = null;
		} else{
			//creates prev and focusNode pointers to traverse the tree
			Node5 prev = focusNode;
			if(data > focusNode.data && focusNode.rightChild != null){
			focusNode = focusNode.rightChild;
			} else if (data < focusNode.data && focusNode.leftChild != null){
				focusNode = focusNode.leftChild;
			}
			
			while(focusNode != null){
				//traverses tree with both pointers until reaches data point
				if(data < focusNode.data){
					prev = focusNode;
					focusNode = focusNode.leftChild;
				} else if(data > focusNode.data){
					prev = focusNode;
					focusNode = focusNode.rightChild;
				} else{ //this else statement is for when data point is reached
					
					//for 0 child case
					if(focusNode.leftChild == null && focusNode.rightChild == null){
						if(prev.rightChild == focusNode){
							prev.rightChild = null;
						} else{
							prev.leftChild = null;
						}
					} //for one child case
					else if(focusNode.rightChild != null && focusNode.leftChild == null && prev.rightChild == focusNode){
						prev.rightChild = focusNode.rightChild;
					} else if (focusNode.rightChild == null && focusNode.leftChild != null && prev.rightChild == focusNode){
						prev.rightChild = focusNode.leftChild;
					} else if (focusNode.rightChild != null && focusNode.leftChild == null && prev.leftChild == focusNode){
						prev.leftChild = focusNode.rightChild;
					} else if (focusNode.rightChild == null && focusNode.leftChild != null && prev.leftChild == focusNode){
						prev.leftChild = focusNode.leftChild;
					}
					else{//for the two child case
						Node5 deleteNode = focusNode;
						prev = focusNode;
						focusNode = focusNode.rightChild;
						//prev & focusNode pointers traverse to minimum of right subtree
						while(focusNode.leftChild != null){
							prev = focusNode;
							focusNode = focusNode.leftChild;
						}
						deleteNode.data = focusNode.data;
						if(focusNode.rightChild == null){
						   if(prev.rightChild == focusNode){
						   prev.rightChild = null;
						   } else{
							   prev.leftChild = null;
						   }
						} else{
							if(prev.leftChild == focusNode){
								prev.leftChild = focusNode.rightChild;
							} else{
								prev.rightChild = focusNode.rightChild;
							}
						}
					}
					return;
				}
			}
			System.out.println("The data point is not inside this tree.");
		}
	}
	
	public void inOrderTraverseTree(Node5 focusNode){
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			System.out.print(focusNode.data + " ");
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void clear(){
		root = null;
	}
	
	public static void main(String[] args){
		BinarySearchTree BST = new BinarySearchTree();
		
		//BST.clear();
		BST.add(10);
		BST.add(13);
		BST.add(12);
		BST.add(11);
		BST.add(17);
		BST.add(18);
		BST.add(100);
		BST.add(200);
		BST.add(150);
		BST.add(300);
		BST.add(50);
		BST.add(52);
		BST.add(5);
		BST.add(3);
		BST.add(4);
		BST.add(2);
		BST.add(6);
		BST.add(7);
		BST.add(8);
		BST.remove(100);
		BST.inOrderTraverseTree(BST.root);
	}
	
}

class Node5{
	int data;
	Node5 leftChild;
	Node5 rightChild;
	
	Node5(int data){
		this.data = data;
	}
	
}
