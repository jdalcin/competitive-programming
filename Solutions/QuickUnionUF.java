/*--------------------------------
 * Author: Jeremy Dalcin
 * Class: connects objects in indexes through their parents indices
 * Motivation: quicker algorithm than FindUF for seeing if two points are connected
 *--------------------------------*/
public class QuickUnionUF {
	
	private int[] id;
	
	
	public QuickUnionUF (int N){
		
		id = new int[N];
		
		for (int i = 0; i < N; i++){
			id[i] = i;
		}
		
	}
	
	public QuickUnionUF(){
		
		
	}
	
	//returns the root index of an object
	public int root(int p){
		
		int toRoot = p;
		
		while (id[toRoot] != toRoot){
			toRoot = id[toRoot];
		}
		
		return toRoot;
	}
	
	// connects pathway from index p to index q
	public void union (int p, int q){
		
		int pRoot = root(p);
		int qRoot = root(q);
		
		if(pRoot != qRoot){
			id[p] = qRoot;
		}
		
	}
	
	//checks if indices are connected
	public void connected (int p, int q){
		
		int pRoot = root(p);
		int qRoot = root(q);
		
		if (pRoot == qRoot) {
			System.out.println("connected");
		} else{
			System.out.println("not connected");
		}
	}
	
	public int[] returnId(){
		
		return id;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
