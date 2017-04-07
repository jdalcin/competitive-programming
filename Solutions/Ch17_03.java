import java.util.*;

public class Ch17_03 {
	
	private static void printMatrix(List<List<Integer>> matrix) {
		for (List<Integer> row : matrix) {
			for (Integer col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	
	private static Integer paths(List<List<Integer>> matrix) {
		List<List<Integer>> pathMatrix = new ArrayList<List<Integer>>();
		List<List<Integer>> obstructionMatrix = matrix;
		System.out.println("\n");
		obstructionMatrix.get(1).set(2, 1);
		obstructionMatrix.get(2).set(0, 1);
		printMatrix(obstructionMatrix);
		for (int n = 0; n < matrix.size(); n++) {
			pathMatrix.add(new ArrayList<Integer>());
			if (n == 0) {
				if (obstructionMatrix.get(0).get(0) == 0) {
					pathMatrix.get(0).add(1);
				} else {
					pathMatrix.get(0).add(0);
				}
			}
			for (int m = 0; m < matrix.get(0).size(); m++) {
				if (m == 0 && n == 0) {
					continue;
				}
				Integer leftPath = 0;
				Integer upPath = 0;
				if (n - 1 >= 0 && obstructionMatrix.get(n - 1).get(m) == 0) {
					leftPath = pathMatrix.get(n - 1).get(m);
				}
				if (m - 1 >= 0 && obstructionMatrix.get(n).get(m - 1) == 0) {
					upPath = pathMatrix.get(n).get(m - 1);
				}
				if (obstructionMatrix.get(n).get(m) == 0) {
					pathMatrix.get(n).add(leftPath + upPath);
				} else {
					pathMatrix.get(n).add(0);
				}
			}
		} 
		return pathMatrix.get(matrix.size() - 1).get(matrix.get(0).size() - 1);
	}
	
	public static void main(String []args) {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		for (int n = 0; n < 3; n++) {
			matrix.add(new ArrayList<Integer>());
			for (int m = 0; m < 3; m++) {
				matrix.get(n).add(0);
			}
		}
		
		printMatrix(matrix);
		System.out.println();
		System.out.println(paths(matrix));
	}
}
