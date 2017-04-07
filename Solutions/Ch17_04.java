import java.util.*;

public class Ch17_04 {
	
	private static void printMatrix(List<List<Integer>> matrix) {
		for (List<Integer> row : matrix) {
			for (Integer col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	private static Integer maxValue(List<List<Integer>> matrix) {
		List<List<Integer>> maxMatrix = new ArrayList<List<Integer>>();
		for (int n = 0; n < matrix.size(); n++) {
			maxMatrix.add(new ArrayList<Integer>());
			for (int m = 0; m < matrix.get(0).size(); m++) {
				Integer currElement = matrix.get(n).get(m);
				Integer prevMax = 0;
				if (n - 1 >= 0) {
					prevMax = maxMatrix.get(n - 1).get(m);
				}
				if (m - 1 >= 0 && maxMatrix.get(n).get(m - 1) > prevMax) {
					prevMax = maxMatrix.get(n).get(m - 1);
				}
				maxMatrix.get(n).add(currElement + prevMax);
			}
		}
		return maxMatrix.get(matrix.size() - 1).get(matrix.get(0).size() - 1);
	}
	
	public static void main(String []args) {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		for (int n = 0; n < 5; n++) {
			matrix.add(new ArrayList<Integer>());
			for (int m = 0; m < 4; m++) {
				matrix.get(n).add(m + 2*n);
			}
		}
		
		printMatrix(matrix);
		System.out.println();
		System.out.println(maxValue(matrix));
	}
}
