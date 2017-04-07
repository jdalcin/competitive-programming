import java.util.*;

public class Ch17_01B {
	
	public static Map<Integer, Integer> sums = new Hashtable<Integer, Integer>();
	
	public static int minimumCoins(int totalPrice, List<Integer> values) {
		int[] minimums = new int[totalPrice + 1];
		minimums[0] = 0;
		int minCoins = 0;
		boolean hasCoin; // if 0, means no coin amount can reach sum, if 1 then it can
		for (int price = 1; price <= totalPrice; price++) {
			minCoins = 0; 
			hasCoin = false;
			for (Integer value : values) { 
				if (price - value >= 0) {
					if (!hasCoin) {
						hasCoin = true;
						minCoins = minimums[price - value];
					} else {
						if (minimums[price - value] < minCoins) {
							minCoins = minimums[price - value];
						}
					}
				}
			}
			minimums[price] = hasCoin ? 1 + minCoins : 0;
		}
		return minimums[totalPrice];
	}
	
	public static int minimumCoinsRecursion(int totalPrice, List<Integer> values) {
		sums.clear();
		return minimumCoinsRecursions(totalPrice, values).value;
	}
	
	public static class minimum{
		int value;
		boolean hasCoin;
		
		minimum(int value, boolean hasCoin) {
			this.value = value;
			this.hasCoin = hasCoin;
		}
	}
	
	public static minimum minimumCoinsRecursions(int currPrice, List<Integer> values) {
		boolean hasCoin = false;
		//base case
		if(sums.containsKey(currPrice)) {
			return new minimum(sums.get(currPrice) + 1, true);
		}
		
		if (currPrice <= 0) {
			if (currPrice == 0) {
				hasCoin = true;
			}
			return new minimum(currPrice, hasCoin);
		}
		
		//recursive case
		int futureMinimum = 0;
		for (int i = 0; i < values.size(); i++) {
			minimum currMinimum = minimumCoinsRecursions(currPrice - values.get(i), values);
			if (!currMinimum.hasCoin) {
				continue;
			}
			if (!hasCoin) {
				hasCoin = true;
				futureMinimum = currMinimum.value;
				sums.put(currPrice, futureMinimum);
			} else {
				if (currMinimum.value < futureMinimum ) {
					futureMinimum = currMinimum.value;
					sums.put(currPrice, futureMinimum);
				}
			}
		}
		return hasCoin ? new minimum(++futureMinimum, hasCoin) : new minimum(futureMinimum, hasCoin);
	}
	
	public static void main(String []args) {
		List<Integer> values = new ArrayList<Integer>(Arrays.asList(1, 3, 7));
		int totalPrice = 13;
		System.out.println(minimumCoins(totalPrice, values));
		System.out.println(minimumCoinsRecursion(totalPrice, values));
	}
}
