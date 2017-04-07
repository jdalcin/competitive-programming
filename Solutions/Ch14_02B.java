import java.util.*;

public class Ch14_02B {
	
	//takes 2 sorted arrays and merges them in-place with O(m + k) time complexity
	//and O(1) space complexity
	static void mergeSort (List<Integer> A, int m, List<Integer> B, int k) {
		if (A.size() < m + k) {
			return;
		}
		int writeIdx = A.size() - 1;
		int a = m - 1;
		int b = B.size() - 1;
		while (a >= 0 && b >= 0) {
			A.set(writeIdx--, A.get(a) > B.get(b) ? A.get(a--) : B.get(b--));
		}
		while (b >= 0) {
			A.set(writeIdx--, B.get(b--));
		}
	}
	
	public static void main(String []args) {
		
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 13, 17));
		int m = A.size();
		List<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 7, 11, 19));
		for (int i = 0; i < B.size(); i++) {
			A.add(null);
		}
		mergeSort(A, m, B, B.size());
		for (int element : A) {
			System.out.print(element + " ");
		}
	}
	
}
