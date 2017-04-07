import java.util.*;

public class Ch13_02 {
	
	// returns if a string can be permutated into a palindrome - takes O(n) time complexity and O(c) space
	// complexity, where n is the number of letters in the string and c is the number of distinct letters
	static boolean isPalindromicPermutation(String s) {
		Map<Character, Integer> charFrequencies = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			if (charFrequencies.containsKey(s.charAt(i))) {
				charFrequencies.remove(s.charAt(i)); 
			} else {
				charFrequencies.put(s.charAt(i), 1);
			}
		}
		if (s.length() % 2 == 0) {
			return (charFrequencies.isEmpty()) ? true : false;
		} else {
			return (charFrequencies.size() == 1) ? true : false;
		}
	}
	
	public static void main(String []args) {
		String s = "edified";
		System.out.println(isPalindromicPermutation(s));
	}
}
