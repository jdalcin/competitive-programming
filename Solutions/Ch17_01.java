import java.util.*;

public class Ch17_01 {
	
	public static int benniePermutations(int score, List<Integer> choices) {
		int[] permutations = new int[score + 1];
		permutations[0] = 1;
		for (int i = 0; i <= score; ++i) {
			for (Integer choice : choices) {
				if (i - choice >= 0) {
					permutations[i] += permutations[i - choice];
				}
			}
		}
		return permutations[score];
	}
	
	public static int bennieCombinations(int score, List<Integer> choices) {
		int[] combinations = new int[score + 1];
		combinations[0] = 1;
		for (Integer choice : choices) {
			for (int n = choice; n <= score; ++n) {
				combinations[n] += combinations[n - choice];
			}
		}
		return combinations[score];
	}
		
	public static void main(String []args) {
		List<Integer> choices = new ArrayList<Integer>(Arrays.asList(2, 3, 7));
		int s = 7;
		System.out.println(benniePermutations(s, choices));
		System.out.println(bennieCombinations(s, choices));
	}
}
