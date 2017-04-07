import java.util.*;

public class Ch18_05 {
	
	public static List<Integer> listMinusNum(List<Integer> A, int num) {
		List<Integer> AMinusNum = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			AMinusNum.add(num - A.get(i));
		}
		return AMinusNum;
	}
	
	//time complexity is O(n^2) and space complexity is O(n)
	public static boolean hasThreeSum(List<Integer> A, int num) {
		Collections.sort(A);
		List<Integer> AMinusNum = listMinusNum(A, num);
		for (int i = 0; i < AMinusNum.size(); i++) {
			Integer twoSum = AMinusNum.get(i);
			for (int n = 0; n < AMinusNum.size(); n++) {
				if (A.get(i) + A.get(n) == twoSum) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String []args) {
		int num = 21;
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11));
		System.out.println(hasThreeSum(A, num));
	}
	
}
