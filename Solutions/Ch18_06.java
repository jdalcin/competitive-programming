import java.util.*;

public class Ch18_06 {
	
	// assumes the invariant that the stream has a majority element of m/n > .5.
	// takes O(n) time complexity and O(1) space complexity instead of O(n) afforded by a 
	// hash table
	public static String majorityElement(String s) {
		Scanner sc = new Scanner(s);
		int count = 0;
		String candidate = "";
		while (sc.hasNext()) {
			String temp = sc.next();
			if (count == 0) {
				++count;
				candidate = temp;
			} else if (candidate.equals(temp)) {
				++count;
			} else {
				--count;
			}
		}
		sc.close();
		return candidate;
	}
	
	public static void main(String []args) {
		String s= "h h h u u d d e h h h";
		System.out.println(majorityElement(s));
	}
	
}
