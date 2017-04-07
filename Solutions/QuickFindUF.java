/*---------------------------
 * Author: Jeremy Dalcin
 * Class: Creates algorithm which checks if two indices are connected OR connects them together
 * Motivation: to form connected paths
 *---------------------------*/
public class QuickFindUF {
	
	private int[] id;
	
	public QuickFindUF(int N){
		
		id = new int[N];
		for (int i = 0; i < id.length; i++){
			id[i] = i;
		}
	}
	
	public void connected(int p, int q){
		
		if (id[p] == id[q]){
			System.out.println("connected");
		} else{
			System.out.println("not connected");
		}
		
	}
	
	//changes object in p index to object in q index
	public void union (int p, int q){
		
		int pID = id[p];
		int qID = id[q];
		for(int i = 0; i < id.length; i++){
			if (id[i] == pID){
				id[i] = qID;
			}
		}
		
	}
	
	public int[] returnId(){
		
		return id;
	}

	public static void main(String[] args) {
		
		
	}

}
