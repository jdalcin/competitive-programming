import java.util.*;

public class Ch17_05 {
	
	private static class Index {
		int x;
		int y;
		
		Index(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean containsArray(List<List<Integer>> matrix, List<Integer> array) {
		List<Index> prevPotentialElements = new ArrayList<Index>();
		//initial case
		for (int row = 0; row < matrix.size(); row++){
			for (int col = 0; col < matrix.get(0).size(); col++) {
				if (matrix.get(row).get(col) == array.get(0)) {
					prevPotentialElements.add(new Index(row, col));
				}
			}
		}
		if (prevPotentialElements.isEmpty()) {
			return false;
		}
		// dynamically programmed iterative steps
		List<Index> nextPotentialElements = prevPotentialElements; 
		for (int i = 1; i < array.size(); i++) {
			prevPotentialElements = nextPotentialElements;
			nextPotentialElements = new ArrayList<Index>();
			for (int n = 0; n < prevPotentialElements.size(); n++) {
				int x = prevPotentialElements.get(n).x;
				int y = prevPotentialElements.get(n).y;
				if (x - 1 >= 0) {
					if (matrix.get(x - 1).get(y) == array.get(i)) {
						nextPotentialElements.add(new Index(x - 1, y));
					}
				}
				if (y - 1 >= 0) {
					if (matrix.get(x).get(y - 1) == array.get(i)) {
						nextPotentialElements.add(new Index(x, y - 1));
					}
				}
				if (x + 1 < matrix.size()) {
					if (matrix.get(x + 1).get(y) == array.get(i)) {
						nextPotentialElements.add(new Index(x + 1, y));
					}
				}
				if (y + 1 < matrix.get(0).size()) {
					if (matrix.get(x).get(y + 1) == array.get(i)) {
						nextPotentialElements.add(new Index(x, y + 1));
					}
				}
			}
			if (nextPotentialElements.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String []args) {
		List<Integer> array = Arrays.asList(1, 3, 4, 6);
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		matrix.add(Arrays.asList(1, 2, 3)); matrix.add(Arrays.asList(3, 4, 5)); matrix.add(Arrays.asList(5, 6, 7));
		System.out.println(containsArray(matrix, array));
	}
}
