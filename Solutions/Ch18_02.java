import java.util.*;

public class Ch18_02 {
	
	public static class PairedTasks {
		Integer task1;
		Integer task2;
		
		PairedTasks (Integer task1, Integer task2) {
			this.task1 = task1;
			this.task2 = task2;
		}
	}
	
	public static List<PairedTasks> pairingTasks(List<Integer> tasks) {
		Collections.sort(tasks);
		List<PairedTasks> pairedTasks = new ArrayList<PairedTasks>();
		for (int i = 0; i < tasks.size() / 2; i++) {
			pairedTasks.add(new PairedTasks(tasks.get(i), tasks.get(tasks.size() - 1 - i)));
		}
		return pairedTasks;
	}
	
	public static void main(String []args) {
		List<Integer> tasks = new ArrayList<Integer>(Arrays.asList(5, 2, 1, 6, 4, 4));
		List<PairedTasks> pairedTasks = pairingTasks(tasks);
		for (int i = 0; i < pairedTasks.size(); i++) {
			System.out.println(pairedTasks.get(i).task1 + " " + pairedTasks.get(i).task2);
		}
	}
}
