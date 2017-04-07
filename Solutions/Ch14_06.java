import java.util.*;

public class Ch14_06 {
	
	public static class Event {
		int startTime;
		int endTime;
		
		Event(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	public static class Endpoint {
		int time;
		boolean isStart;
		
		Endpoint(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}
	}
	
	// updates a list of disjoint intervals to include a new input interval
	// takes O(n) time and space complexity - where n is the the number of start and end times
	public static List<Event> updateList(List<Event> events, Event event) {
		List<Endpoint> endpoints = new ArrayList<Endpoint>();
		for (int i = 0; i < events.size(); i++) {
			endpoints.add(new Endpoint(events.get(i).startTime, true));
			endpoints.add(new Endpoint(events.get(i).endTime, false));
		}
		List<Endpoint> endpointsUpdated = new ArrayList<Endpoint>();
		for (int i = 0; i < endpoints.size(); i++) {
			if (endpoints.get(0).time > event.startTime) {
				endpointsUpdated.add(new Endpoint(event.startTime, true));
			}
			if (i == endpoints.size() - 1 && endpoints.get(i).time < event.startTime) {
				endpointsUpdated.add(new Endpoint(event.startTime, true));
				endpointsUpdated.add(new Endpoint(event.endTime, true));
			}
			if (endpoints.get(i).time < event.startTime && endpoints.get(i+1).time > event.startTime) {
				if (!endpoints.get(i).isStart) {
					endpointsUpdated.add(new Endpoint(event.startTime, true));
				} else {
					endpointsUpdated.add(new Endpoint(endpoints.get(i).time, endpoints.get(i).isStart));
				}
				while (endpoints.get(i).time < event.endTime  && i != endpoints.size()) {
					++i;
				}
				if (endpoints.get(i).isStart) {
					endpointsUpdated.add(new Endpoint(event.endTime, false));
				} else {
					endpointsUpdated.add(new Endpoint(endpoints.get(i).time, endpoints.get(i).isStart));
				}
			} else {
				endpointsUpdated.add(new Endpoint(endpoints.get(i).time, endpoints.get(i).isStart));
			}
		}
		List<Event> eventsUpdated = new ArrayList<Event>();
		for (int i = 0; i < endpointsUpdated.size(); i += 2) {
			eventsUpdated.add(new Event(endpointsUpdated.get(i).time, endpointsUpdated.get(i+1).time));
		}
		return eventsUpdated;
	}
	
	public static void main(String []args) {
		List<Event> events = new ArrayList<Event>(Arrays.asList(new Event(-4, -1), new Event(0, 2),
				             new Event(3, 6), new Event(7, 9), new Event(11, 12), new Event(14, 17)));
		Event event = new Event(1, 8);
		List<Event> updatedEvents = updateList(events, event);
		for (Event eventUpdate: updatedEvents) {
			System.out.print("[" + eventUpdate.startTime + ", " + eventUpdate.endTime + "], ");
		}
	}
	
}
