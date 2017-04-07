public class Ch12_05 {
	//returns the largest integer whose square is less than or equal to a given nonnegative integer
	// - takes O(logn) time complexity and O(1) space complexity
		public static int integerSquareRoot(int num) {
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
		
		public static void main(String [] args) {
			System.out.println(integerSquareRoot(4));
		}
}
