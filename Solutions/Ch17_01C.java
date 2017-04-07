import java.util.*;

public class Ch17_01C {
	
	public static int longestIncreasingSequence(List<Integer> sequence) {
		if (sequence.size() == 0) {
			return 0;
		}
		int[] longest = new int[sequence.size()];
		longest[0] = 1; //first element must be increasing
		for (int i = 1; i < sequence.size(); i++) {
			int longestValue = Integer.MIN_VALUE;
			for (int j = 0; j <= i; j++) {
				if (sequence.get(j) <= sequence.get(i) && longest[j] > longestValue) {
					longestValue = longest[j];
				}
			}
			longest[i] = longestValue != Integer.MIN_VALUE ? 1 + longestValue : 0;
		}
		return longest[sequence.size() - 1];
	}
	
	public static void main(String []args) {
		List<Integer> sequence = new ArrayList<Integer>(Arrays.asList(5, 3, 4, 6, 8, 6, 7, 8));
		System.out.println(longestIncreasingSequence(sequence));
	}
	
}
