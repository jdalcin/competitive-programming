import java.util.*;

public class Ch19_04 {
	
	public static class Coordinate {
		int x;
		int y;
		
		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			
			Coordinate that = (Coordinate) o;
			if (x == that.x && y == that.y) {
				return true;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
	
	public static enum Color {W, B}
	
	public static void outputMatrix(Color[][] matrix) {
		for (Color[] row : matrix) {
			for (Color col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	public static void encloseRegions(Color[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		Set<Coordinate> whiteBorderSet = new HashSet<Coordinate>();
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (row == 0 || row == matrix.length - 1 || col == 0 || col == matrix[0].length - 1) {
					Coordinate start = new Coordinate(col, row);
					if (isFeasible(matrix, start, whiteBorderSet)) {
						searchRegions(matrix, whiteBorderSet, start);
					}
				}
			}
		}
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				Coordinate curr = new Coordinate(col, row);
				if (matrix[row][col] == Color.W && !whiteBorderSet.contains(curr)) {
					matrix[row][col] = Color.B;
				}
			}
		}
	}
	
	public static void searchRegions(Color[][] matrix, Set<Coordinate> whiteBorderSet, Coordinate start) {
		whiteBorderSet.add(start);
		int[][] shifts = new int[][] {new int[] {0, 1}, new int[] {1, 0}, 
									  new int[] {0, -1}, new int[] {-1, 0}};
		for (int[] shift : shifts) {
			Coordinate increment = new Coordinate(start.x + shift[0], start.y + shift[1]);
			if (isFeasible(matrix, increment, whiteBorderSet)) {
				searchRegions(matrix, whiteBorderSet, increment);
			}
		}
		return;
	}
	
	public static boolean isFeasible(Color[][] matrix, Coordinate point, Set<Coordinate> whiteBorderSet) {
		if (point.x >= 0 && point.x < matrix[0].length && point.y >=0 && point.y < matrix.length && matrix[point.y][point.x] == Color.W && !whiteBorderSet.contains(point)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Color[][] matrix = new Color[4][4];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[row][col] = Color.B;
			}
		}
		matrix[1][0] = Color.W;
		matrix[1][1] = Color.W;
		matrix[1][2] = Color.W;
		matrix[2][1] = Color.W;
		matrix[2][2] = Color.W;
		outputMatrix(matrix);
		System.out.println();
		encloseRegions(matrix);
		outputMatrix(matrix);
	}
}
