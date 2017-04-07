import java.util.*;

public class BinarySearchJeremy {
	
	// finds the lower bound of a binary search
	static Integer binarySearch(List<Integer> array, int key) {
		if (array.size() == 0) {
			return null;
		}
		int L = 0;
		int U = array.size() - 1;
		int mid = 0;
		Integer currKeyIndex = null;
		while (L <= U) {
			mid = L + (U - L) / 2;
			if (array.get(mid) >= key) {
				if (array.get(mid) == key) {
					currKeyIndex = mid;
				}
				U = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return currKeyIndex;
	}
	
	public static void main(String []args) {
		int key = 1;
		List<Integer> array = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1));
		System.out.print(binarySearch(array, key));
	}
	
}
