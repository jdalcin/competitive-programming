import java.util.*;

public class Ch12_04 {
	
	//searches for the index of the smallest element in a cyclically sorted array - takes O(logn) time 
	//complexity and O(1) space complexity
		public static int binarySearchCyclicSort(List<Integer> A) {
			int L = 0;
			int U = A.size() - 1;
			if (A.get(U) - A.get(L) > 0) {
				return -1;
			}
			int mid = -1;
			while (L < U) {
				mid = L + (U - L) / 2;
					if (A.get(mid) - A.get(L) < 0) {
						U = mid;
					} else if (A.get(mid) - A.get(U) > 0) {
						L = mid + 1;
					}
			}
			return mid;
		}
		
		public static void main(String [] args) {
			List<Integer> A = new ArrayList<Integer>(Arrays.asList(378, 478, 550, 631, 700, 1));
			System.out.println(binarySearchCyclicSort(A));
		}
		
}
