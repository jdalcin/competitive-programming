public class Ch17_02B {
	
	private static int leventhesteinDistance(String s1, String s2) {
		int[][] E = new int[s1.length()][s2.length()];
		int minError;
		for (int a = 0; a < s1.length(); a++) {
			char aChar = s1.charAt(a);
			for (int b = 0; b < s2.length(); b++) {
				minError = Integer.MAX_VALUE;
				char bChar = s2.charAt(b);
				if (a - 1 >= 0 && b - 1 >= 0 && E[a - 1][b - 1] < minError) {
					minError = E[a - 1][b - 1];
				}
				if (aChar != bChar) {
					if (b - 1 >= 0 && E[a][b - 1] < minError) {
						minError = E[a][b - 1];
					}
					if (a - 1 >= 0 && E[a - 1][b] < minError) {
						minError = E[a - 1][b];
					}
				} 
				E[a][b] = minError == Integer.MAX_VALUE ? (aChar == bChar ? 0 : 1) 
						: (aChar != bChar ? minError + 1 : minError);
			}
		}
		return E[s1.length() - 1][s2.length() - 1];
	}
	
	public static void main(String []args) {
		String s1 = "Hello";
		String s2 = "Hilloo";
		System.out.println(leventhesteinDistance(s1, s2));
	}
}
