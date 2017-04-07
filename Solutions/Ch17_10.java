import java.util.*;

public class Ch17_10 {
	
	private static int maximumGain(List<Integer> coins) {
		int[][] maximumGains = new int[coins.size()][coins.size()];
		int a = 0; int b = coins.size() - 1; int aPrime = 0; int bPrime = 0;
		int min = Integer.MAX_VALUE;
		maximumGains[0][coins.size() - 1] = Math.max(coins.get(0), coins.get(coins.size() - 1));
		maximumGains[1][coins.size() - 2] = Math.max(coins.get(1), coins.get(coins.size() - 2)) - maximumGains[0][coins.size() - 1];
		maximumGains[2][coins.size() - 1] = Math.max(coins.get(2), coins.get(coins.size() - 1)) - maximumGains[0][coins.size() - 1];
		maximumGains[0][coins.size() - 3] = Math.max(coins.get(0), coins.get(coins.size() - 3)) - maximumGains[0][coins.size() - 1];
		
		if (maximumGains[1][coins.size() - 2] < min) {
			min = maximumGains[1][coins.size() - 2];
		}
		if (maximumGains[2][coins.size() - 1] < min) {
			min = maximumGains[2][coins.size() - 1];
		}
		if (maximumGains[0][coins.size() - 3] < min) {
			min = maximumGains[0][coins.size() - 3];
		}
		
		if (min == maximumGains[1][coins.size() - 2]) {
			a = a + 1; b = b - 1;
		} else if (min == maximumGains[2][coins.size() - 1]) {
			a = a + 2;
		} else if (min == maximumGains[0][coins.size() - 3]) {
			b = b - 2;
		}
		System.out.print(a + " " + b);
		while (a < b) {
				int minMaximum = Integer.MAX_VALUE;
				if (a - 1 >= 0 && b + 1 < coins.size() && maximumGains[a - 1][b + 1] < minMaximum) {
					minMaximum =  maximumGains[a - 1][b + 1];
				}
				if (a - 2 >= 0 && maximumGains[a - 2][b] < minMaximum) {
					minMaximum =  maximumGains[a - 2][b];
					
				}
				if (b + 2 < coins.size() && maximumGains[a][b + 2] < minMaximum) {
					minMaximum =  maximumGains[a][b + 2];
				}
				maximumGains[a][b] = minMaximum == Integer.MAX_VALUE ? (a == 0 && b == coins.size() - 1 ? 
						Math.max(coins.get(a), coins.get(b)) : 0) :
						Math.max(coins.get(a), coins.get(b)) + minMaximum;
				
				aPrime = a; bPrime = b;
				if (b - a <= 2) { 
					break;
				}
				if (a - 1 >= 0 && b + 1 < coins.size() && minMaximum == maximumGains[a - 1][b + 1]) {
					a = a + 1; b = b - 1;
				} else if (a - 2 >= 0 && minMaximum == maximumGains[a - 2][b]) {
					a = a + 2;
				} else if (b + 2 < coins.size() && minMaximum == maximumGains[a][b+2]) {
					b = b - 2;
				}
		}
		for (int[] row : maximumGains) {
			for(int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
		return maximumGains[aPrime][bPrime];
	}
	
	public static void main(String []args) {
		List<Integer> coins = Arrays.asList(1,2,8,4);
		System.out.println(maximumGain(coins));
	}
}
