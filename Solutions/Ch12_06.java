public class Ch12_06 {
	
	//returns the square root to a given nonnegative integer
	// - takes O(log(n/s)) time complexity and O(1) space complexity, s stands for the precision tolerance
	public static double realSquareRoot(int num) {
		int L = 0;
		int U = num;
		int mid = -1;
		while (L <= U) {
			mid = L + (U - L) / 2;
				if (mid * mid > num) {
					U = mid - 1;
				} else {
					L = mid + 1;
				}
		}
		return (mid * mid <= num) ? mid : mid - 1;
	}
	
	public static void main(String []args) {
		System.out.println(realSquareRoot(5));
	}
	
}
