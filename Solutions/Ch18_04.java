import java.util.*;

public class Ch18_04 {
	
	public static class Task{
		Integer start;
		Integer end;
		
		Task(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}
		
	}
	
	public static class Endpoint implements Comparable<Endpoint> {
		Integer endpoint;
		Boolean leftExtremum;
		Boolean rightExtremum;
		
		Endpoint(Integer endpoint, Boolean leftExtremum, Boolean rightExtremum) {
			this.endpoint = endpoint;
			this.leftExtremum = leftExtremum;
			this.rightExtremum = rightExtremum;
		}
		
		@Override
		public int compareTo(Endpoint e2) {
			if (Integer.compare(endpoint, e2.endpoint) != 0) {
				return Integer.compare(endpoint, e2.endpoint);
			} else {
				if (rightExtremum && e2.leftExtremum) {
					return -1;
				} else if (rightExtremum == e2.rightExtremum && leftExtremum == e2.leftExtremum) {
					return 0;
				} else if (leftExtremum && e2.rightExtremum){
					return 1;
				}
			}
			return 0;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			return compareTo((Endpoint)o) == 0;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(endpoint, leftExtremum, rightExtremum);
		}
	}
	
	public static List<Endpoint> tasksToEndpoints (List<Task> tasks) {
		List<Endpoint> endpoints = new ArrayList<Endpoint>();
		for (int i = 0; i < tasks.size() ; i++) {
			endpoints.add(new Endpoint(tasks.get(i).start, true, false));
			endpoints.add(new Endpoint(tasks.get(i).end, false, true));
		}
		return endpoints;
	}
	
	//time complexity is O(nlogn) and space complexity is O(n)
	public static List<Integer> minSet(List<Task> tasks) {
		List<Endpoint> endpoints = tasksToEndpoints(tasks);
		Collections.sort(endpoints);
		Map<Endpoint, Endpoint> taskHash = new Hashtable<Endpoint, Endpoint>();
		Map<Endpoint, Boolean> visitHash = new Hashtable<Endpoint, Boolean>();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < tasks.size(); i++) {
			Endpoint leftExtremumEndpoint = new Endpoint(tasks.get(i).start, true, false);
			taskHash.put(new Endpoint(tasks.get(i).end, false, true), leftExtremumEndpoint);
			visitHash.put(leftExtremumEndpoint, false);
		}
		Boolean prevSwitch = false;
		Boolean noSwitchUntilEnd = false;
		Boolean cool = false;
		Integer noSwitchStartingValue = 0;
		for (int i = 0; i < endpoints.size(); i++) {
			Endpoint currEndpoint = endpoints.get(i);
			if (currEndpoint.leftExtremum) {
				if (prevSwitch) {
					prevSwitch = false;
					noSwitchUntilEnd = false;
					cool = false;
					result.add(endpoints.get(i - 1).endpoint);
				}
				visitHash.replace(currEndpoint, true);
			} else {
				if(visitHash.get(taskHash.get(currEndpoint)) && !prevSwitch) {
					prevSwitch = true;
				}
				if (!noSwitchUntilEnd) {
					if (endpoints.get(i - 2).endpoint < endpoints.get(i - 1).endpoint) {
						cool = true;
					}
					noSwitchUntilEnd = true;
					noSwitchStartingValue = currEndpoint.endpoint;
				}
			}
		}
		if (noSwitchUntilEnd && (result.size() == 0 || cool)) {
			result.add(noSwitchStartingValue);
		}
		return result;
	}
	
	public static void main(String []args) {
		List<Task> tasks = new ArrayList<Task>(Arrays.asList(new Task(0, 3), new
				Task(2, 6), new Task(3, 4), new Task(7, 9), new Task(9, 11)));
		System.out.println(minSet(tasks));
	}
}
