import java.util.*;

public class Ch18_03 {
	
	//takes O(nlogn) time complexity and O(1) space complexity
	public static int minimumTotalWaitingTime(List<Integer> serviceTimes) {
		Collections.sort(serviceTimes);
		int totalWaitingTime = 0;
		int waitingTime = 0;
		for (int i = 1; i < serviceTimes.size(); i++) {
			waitingTime += serviceTimes.get(i - 1);
			totalWaitingTime += waitingTime;
		}
		return totalWaitingTime;
	}
	
	public static void main(String []args) {
		List<Integer> serviceTimes = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1));
		System.out.println(minimumTotalWaitingTime(serviceTimes));
	}
}
