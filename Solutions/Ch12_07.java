import java.util.*;

public class Ch12_07 {
	
	//searches a 2D array for a given key - takes O(m+n) time complexity and O(1) space complexity
	public static boolean search2D(List<List<Integer>> matrix, int key) {
		// starts at top right of matrix
		int col = matrix.get(0).size() - 1;
		int row = 0;
		while (col >= 0 && row < matrix.size()){
			int curr = matrix.get(row).get(col);
			if (curr > key) {
				col--;
			} else if (curr < key) {
				row++;
			} else {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String []args) {
		int key = 12;
		List<List<Integer>> matrix  = new ArrayList<List<Integer>>();
		matrix.add(new ArrayList<Integer>(Arrays.asList(-1, 2, 4, 4, 6)));
		matrix.add(new ArrayList<Integer>(Arrays.asList(1, 5, 5, 9, 21)));
		matrix.add(new ArrayList<Integer>(Arrays.asList(3, 6, 6, 9, 22)));
		matrix.add(new ArrayList<Integer>(Arrays.asList(3, 6, 8, 10, 24)));
		matrix.add(new ArrayList<Integer>(Arrays.asList(6, 8, 9, 12, 25)));
		matrix.add(new ArrayList<Integer>(Arrays.asList(8, 10, 12, 13, 40)));
		System.out.print(search2D(matrix, key));
	}
	
}
