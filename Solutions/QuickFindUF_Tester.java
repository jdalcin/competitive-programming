
public class QuickFindUF_Tester {

	public static void main(String[] args){
		
		QuickFindUF arrayinitial = new QuickFindUF(6);
		arrayinitial.union(0, 2);
		arrayinitial.connected(0, 2);
		int[] array1 = arrayinitial.returnId();
		
		for (int d : array1){
			System.out.println(d);
		}
	}
}
