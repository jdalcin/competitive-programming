import java.util.*;

public class Ch17_09 {
	
	private static int maxGain(List<Integer> coins) {
		return coins.size() != 0 ? maxGainHelper(coins, 0, coins.size() - 1) : 0;
	}
	
	private static int maxGainHelper(List<Integer> coins, int a, int b) {
		//base cases
		if (a >= b) {
			
		}
		//iterative cases
	}
	
	public static void main(String []args) {
		List<Integer> coins = Arrays.asList(1, 5, 10, 20);
		System.out.println(maxGain(coins));
	}
	
}
