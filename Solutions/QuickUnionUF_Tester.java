
public class QuickUnionUF_Tester {

	
	public static void main(String[] args) {
		
		QuickUnionUF arrayInitial = new QuickUnionUF(6);
		arrayInitial.connected(0,2);
		arrayInitial.union(0,2);
		arrayInitial.connected(0,2);
		arrayInitial.union(2,5);
		arrayInitial.union(5,4);
		arrayInitial.connected(2,4);
		int[] array = arrayInitial.returnId();
		
		for (int ID : array){
			System.out.println(ID);
		}
		
	}

}
