import java.util.*;

public class Ch12_02 {
	
	//searches for the index of the first value greater than a key - takes O(logn) time complexity and O(1) 
	//space complexity
		public static int binarySearchGreater(List<Integer> A, int key) {
			int L = 0;
			int U = A.size() - 1;
			int mid = 0;
			int bestKeyIndex = -1; //current index of key found - everytime a new minimum index of a value
								   //greater than the key is found, this variable overwrites itself 
			                       //with that new value
			while (L <= U) {
				mid = L + (U - L) / 2;
				if (A.get(mid) > key) { //shift left
					if (A.get(mid) > key) {
						bestKeyIndex = mid;
					}
					U = mid - 1;
				} else {
					L = mid + 1;
				}
			}
			return bestKeyIndex;
		}
	
	public static void main(String [] args) {
		int key = 2;
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2, 4, 5, 6, 7));
		System.out.println(binarySearchGreater(A, key));
	}
	
}
