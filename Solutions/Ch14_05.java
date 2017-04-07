import java.util.*;

public class Ch14_05 {
	
	public static class Event {
		int startTime;
		int endTime;
		
		Event(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	public  static class Endpoint implements Comparable<Endpoint> {
		public int time;
		public boolean isStart;
		
		public int compareTo(Endpoint e) {
			if (time != e.time) {
				return Integer.compare(time, e.time);
			}
			// if compared times are the same, makes sure a start interval is sorted before an end 
			//interval
			return isStart && !e.isStart ? -1 : !isStart && e.isStart ? 1 : 0;
		}
		
		Endpoint(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}
	}
	
	public static int maxConcurrentEvents(List<Event> events) {
		List<Endpoint> endpoints = new ArrayList<Endpoint>();
		for (int i = 0; i < events.size(); i++) {
			endpoints.add(new Endpoint(events.get(i).startTime, true));
			endpoints.add(new Endpoint(events.get(i).endTime, false));
		}
		Collections.sort(endpoints);
		int count = 0;
		int max = 0;
		for (int i = 0; i < endpoints.size(); i++) {
			count = endpoints.get(i).isStart ? ++count : --count;
			max = count > max ? count : max;
		}
		return max;
	}
	
	public static void main(String []args) {
		List<Event> events = new ArrayList<Event>(Arrays.asList(new Event(1, 5), new Event(2, 7), 
							 new Event(4, 5), new Event(6, 10), new Event(8, 9), new Event(9, 17),
							 new Event(11, 13), new Event(12, 15), new Event(14, 15)));
		System.out.println(maxConcurrentEvents(events));
	}
	
}
