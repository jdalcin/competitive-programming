
public class Ch17_01E {
	
	//uses dynamic programming to find the max amount of apples in an apple farm - takes O(nm) time and space complexity
	public static int maxApples(int[][] appleFarm) {
		int[][] maxApples = new int[appleFarm.length][appleFarm[0].length];
		for (int row = 0; row < maxApples.length; row++) {
			for (int col = 0; col < maxApples[row].length; col++) {
				int prevMax = Integer.MIN_VALUE;
				for (int choice = 0; choice < 2; choice++) {
					if (col - 1 >= 0 && choice == 0) {
						if (maxApples[row][col-1] > prevMax) {
							prevMax = maxApples[row][col-1];
						}
					} else if (row - 1 >= 0 && choice == 1) {
						if (maxApples[row - 1][col] > prevMax) {
							prevMax = maxApples[row - 1][col];
						}
					}
				}
				maxApples[row][col] = prevMax != Integer.MIN_VALUE ? appleFarm[row][col] + prevMax : appleFarm[0][0];
			}
		}
		return maxApples[appleFarm.length - 1][appleFarm[0].length - 1];
	}
	
	
	public static void main(String []args) {
		int[][] multiDimensional = new int[3][3];
		for (int row = 0; row < multiDimensional.length; row++) {
			for (int col = 0; col < multiDimensional[row].length; col++) {
				multiDimensional[row][col] = 2* row + col;
			}
		}
		
		for (int[] row : multiDimensional) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
		System.out.println("-------\n" + maxApples(multiDimensional));
	}
}
