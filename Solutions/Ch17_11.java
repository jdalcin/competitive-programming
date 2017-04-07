
public class Ch17_11 {
		
		private static int maxPaths(int n, int k) {
			int[][] maxPathsMatrix = new int[n + 1][k + 1];
			for (int row = 0; row < 2; row ++) {
				for (int col = 0; col <= k; col++) {
					maxPathsMatrix[row][col] = 1;
				}
			}
			
			for (int col = 2; col <= k; col++) {
				for (int row = 0; row <= n; row++) {
					if (row > col && col != k) {
						break;
					}
					
					if (row < col) {
						maxPathsMatrix[row][col] = maxPathsMatrix[row][col - 1];
					} else {
						for (int i = 1; i <= col; i++) {
							maxPathsMatrix[row][col] = maxPathsMatrix[row][col] + maxPathsMatrix[row - i][col];
						}
					}
				}
			}
			
			for (int i = 0; i < maxPathsMatrix.length; i++) {
				for (int a = 0; a < maxPathsMatrix[0].length; a++) {
					System.out.print(maxPathsMatrix[i][a] + " ");
				}
				System.out.println();
			}
			return maxPathsMatrix[n][k];
		}
		
		public static void main(String []args) {
			int n = 4;
			int k = 2;
			System.out.println(maxPaths(n, k));
		}
}
