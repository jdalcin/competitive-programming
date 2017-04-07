import java.util.*;

public class Ch12_03 {

	//searches for the index of an entry equal to its index - takes O(logn) time complexity and O(1) 
	//space complexity
		public static int binarySearchIndex(List<Integer> A) {
			int L = 0;
			int U = A.size() - 1;
			int mid = 0;
			while (L <= U) {
				mid = L + (U - L) / 2;
				if (A.get(mid) > mid) { //shift left
					U = mid - 1;
				} else if(A.get(mid) < mid) {
					L = mid + 1;
				} else {
					return mid;
				}
			}
			return -1;
		}
	
	public static void main(String [] args) {
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2, 4, 5, 6, 7, 8));
		System.out.println(binarySearchIndex(A));
	}
		
}
