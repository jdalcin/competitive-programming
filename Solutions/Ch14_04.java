import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ch14_04 {
	
	public static class Name implements Comparable<Name> {
		String firstName;
		String lastName;
		
		@Override
		public int compareTo(Name name) {
			int cmpFirst = firstName.toLowerCase().compareTo(name.firstName.toLowerCase());
				return cmpFirst;
		}
		
		Name (String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}
	
	// eliminates first name duplicates in a list of names - takes O(nlogn) time complexity and O(1) 
	// space complexity
	public static void eliminateDuplicates(List<Name> A) {
		Collections.sort(A);
		int result = 1;
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i).firstName != A.get(i-1).firstName) {
				A.set(result++, A.get(i));
			}
		}
		A.subList(result, A.size()).clear();
	}
	
	public static void main(String []args) {
		List<Name> A = new ArrayList<Name>(Arrays.asList(new Name("Ian", "Botham"), 
				   new Name("David", "Gower"), new Name("Ian", "Bell"), new Name("Ian", "Chappell"), 
				   new Name("Jeremy", "Dalcin"), new Name("Jaime", "Dalcin")));
		eliminateDuplicates(A);
		for (int i = 0; i < A.size(); i++) {
			System.out.print("(" + A.get(i).firstName + ", " + A.get(i).lastName + ") ");
		}
	}
}
