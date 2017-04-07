import java.util.*;


// really question 14 in chapter 17

public class CH17_12 {
	
	//takes O(n^2) time complexity and O(n) space complexity
	private static int longestIncreasingSubsequence(List<Integer> list) {
		int[] longestSubsequenceMatrix = new int[list.size()];
		longestSubsequenceMatrix[0] = 1;
		for (int j = 1; j < list.size(); j++) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < j; i++) {
				if (list.get(i) <= list.get(j)) {
					max = longestSubsequenceMatrix[i] >= max ? longestSubsequenceMatrix[i] + 1 : max;
				}
			}
			longestSubsequenceMatrix[j] = max == Integer.MIN_VALUE ? 1 : max;
		}
		return longestSubsequenceMatrix[list.size() - 1];
	}
	
	public static void main(String []args) {
		List<Integer> list = Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9);
		System.out.println(longestIncreasingSubsequence(list));
	}
}
