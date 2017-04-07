import java.util.*;

public class Ch14_01 {
	
	//returns an array of the intersecting elements of 2 sorted arrays - takes O(n+m) time and space 
	//complexity
	static List<Integer> intersection(List<Integer> sorted1, List<Integer> sorted2) {
		List<Integer> intersect = new ArrayList<Integer>();
		if (sorted1.size() == 0 || sorted2.size() == 0) {
			return intersect; 
		}
		int p1 = 0;
		int p2 = 0;	
		while (p1 < sorted1.size() && p2 < sorted2.size()) {
			if (sorted1.get(p1) < sorted2.get(p2)) {
				p1++;
			} else if (sorted2.get(p2) < sorted1.get(p1)) {
				p2++;
			} else {
				if (intersect.size() == 0 || intersect.get(intersect.size() - 1) != sorted1.get(p1)) {
					intersect.add(sorted1.get(p1));
				}
				p1++;
				p2++;
			}
		}
		return intersect;
	}
	
	public static void main(String []args) {
		List<Integer> sorted1 = new ArrayList<Integer>(Arrays.asList(2, 3, 3, 5, 5, 6, 7, 7, 8, 12));
		List<Integer> sorted2 = new ArrayList<Integer>(Arrays.asList(5, 5, 6, 8, 8, 9, 10, 10));
		List<Integer> intersection = intersection(sorted1, sorted2);
		for (int col : intersection) {
			System.out.print(col + " ");
		}
	}

}
