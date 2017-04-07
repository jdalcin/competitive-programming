import java.util.*;

public class Ch17_02 {

	public static int leventheinDistance(String s1, String s2) {
		int a = s1.length() - 1;
		int b = s2.length() - 1;
		int result = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(a) == s2.charAt(b)) {
				--a;
				--b;
			} else {
				++result;
				if (a == b) {
					--a;
					--b;
				} else if (a > b) {
					--a;
				} else {
					--b;
				}
			}
		}
		return result;
	}
	
	public static void main(String []args) {
		String s1 = "Hiella";
		String s2 = "Hello";
		System.out.println(leventheinDistance(s1, s2));
	}
	
}
