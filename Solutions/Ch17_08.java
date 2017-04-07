import java.util.*;

public class Ch17_08 {
	
	private static Set<String> dictionary = new HashSet<String>();
	private static Map<String, Boolean> isSequence = new Hashtable<String, Boolean>();
	
	private static boolean isDictionarySequence(String s1,List<String> listStrings) {
		dictionary.clear();
		dictionary.addAll(listStrings);
		isSequence.clear();
		return s1 != null ? isDictionarySequenceHelper(s1, "", s1.length() - 1, true) : false;
	}
	
	private static boolean isDictionarySequenceHelper(String fullString, String substring, int n, boolean isPrevSequence) {
		//base cases
		if (n == -1) {
			isPrevSequence = dictionary.contains(substring);
			return isPrevSequence;
		}
		
		if (substring != "" && !dictionary.contains(substring)) {
			return false;
		}
		
		if (isSequence.containsKey(substring)) {
			return isSequence.get(substring);
		}
		//iterative cases
		if(substring != "") {
			isPrevSequence = dictionary.contains(substring);
		}
		boolean concatenationInTreeRow = false;
		for (int i = n; i >= 0; i--) {
			String newSubstring = fullString.substring(i, n + 1);
			Boolean isConcatenated = isDictionarySequenceHelper(fullString, newSubstring, i - 1, isPrevSequence);
			if (isConcatenated) {
				concatenationInTreeRow = true;
			}
		}
		isSequence.put(substring, concatenationInTreeRow);
		return concatenationInTreeRow;
	}
	
	public static void main(String []args) {
		List<String> listStrings = Arrays.asList("bed", "bath", "and", "beyond");
		String testString = "bedbathandbeyond";
		System.out.println(isDictionarySequence(testString, listStrings));
	}
	
}
