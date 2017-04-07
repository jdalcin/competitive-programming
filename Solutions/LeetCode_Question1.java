import java.util.*;

public class LeetCode_Question1 {
	
	//finds median of one sorted array, takes O(1) time complexity
	private static double arrayMedian(List<Integer> array) {
		if (array.size() == 0) {
			return 0;
		}
		
		int middle = array.size() / 2;
		if (array.size() % 2 != 0) {
			return (double) array.get(middle);
		} else {
			return (double) (array.get(middle) + array.get(middle - 1)) / 2;
		}
	}
	
	// finds index of an array where a given value can be placed using binary search, takes O(log(m)) time
	// complexity -- if smaller than arrays smallest value returns -1, if greater returns arrays length, and
	// if inside array returns one index above index of closest element less than or equal to it
	private static int findIndex(List<Integer> array, double value) {
		int LB = 0;
		int UB = array.size() - 1;
		// edge cases
		if (value < array.get(LB)) {
			return -1;
		} else if (value > array.get(UB)) {
			return array.size();
		}
		// other cases
		while (UB - LB > 1) {
			//iterative cases
			int median = (UB + LB) / 2;
			if (array.get(median) == value ) {
				return median + 1;
			} else if (array.get(median) > value) {
				UB = median;
			} else {
				LB = median;
			}
		}
		
		//base case
		if (UB - LB == 1) {
			return LB + 1;
		}
		return -1;
	}
	
	
	//finds the median of two sorted array in log(m + n) time complexity, where m is size of array 1 and
	// n is size of array 2
	public static double findMedian(List<Integer> array1, List<Integer> array2) {
		
	}
	
	public static void main (String []args) {
		List<Integer> array0 = Arrays.asList(1);
		System.out.println(arrayMedian(array0));
		List<Integer> array1 = Arrays.asList(3, 5, 90, 100);
		List<Integer> array2 = Arrays.asList(0, 2, 4, 10, 20, 30, 50, 200);
		//System.out.println(findMedian(array1, array2));
	}
}
