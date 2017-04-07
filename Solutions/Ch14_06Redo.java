import java.util.*;

public class Ch14_06Redo {
	
	private static class Interval {
		int left;
		int right;
		
		Interval(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	
	public static List<Interval> updateList(List<Interval> disjointIntervals, Interval newInterval) {
		List<Interval> disjointIntervalsUpdated = new ArrayList<Interval>();
		int minLeft = newInterval.left;
		int maxRight = newInterval.right;
		int i = 0;
		int currLeft = disjointIntervals.get(i).left;
		int currRight = disjointIntervals.get(i).right;
		if (i != disjointIntervals.size() - 1) {
			int nextLeft = disjointIntervals.get(i+1).left;
			int nexRight = disjointIntervals.get(i+1).right;
			//process intervals up to point where the newInterval is no longer disjoint from the others
			while ((minLeft >= currLeft || minLeft >= currRight)
					&& i != disjointIntervals.size() - 1) {
				currLeft = disjointIntervals.get(i).left;
				currRight = disjointIntervals.get(i).right;
				nextLeft = disjointIntervals.get(i+1).left;
				nexRight = disjointIntervals.get(i+1).right;
				if (minLeft < currRight) {
					minLeft = minLeft > currLeft ? currLeft : minLeft;
					break;
				} else if(minLeft < nextLeft) {
					break;
				}
				disjointIntervalsUpdated.add(disjointIntervals.get(i));
				++i;
			}
			//process intervals where newInterval is not disjoint with the others
			while (maxRight >= currLeft && i != disjointIntervals.size() - 1) {
				currLeft = disjointIntervals.get(i).left;
				currRight = disjointIntervals.get(i).right;
				nextLeft = disjointIntervals.get(i+1).left;
				nexRight = disjointIntervals.get(i+1).right;
				if (minLeft > )
				++i;
			}
			disjointIntervalsUpdated.add(minLeft, minRight);
			//processes rest of interval
		}
	}
	public static void main(String []args) {
		List<Interval> disjointIntervals = new ArrayList<Interval>(Arrays.asList(new Interval(-4, -1),
				new Interval(0, 2), new Interval(3, 6), new Interval(7, 9), new Interval(11, 12),
				new Interval(14, 17)));
		Interval newInterval = new Interval(1, 8);
		List<Interval> disjointIntervalsUpdated = updateList(disjointIntervals, newInterval);
		for (Interval interval : disjointIntervalsUpdated) {
			System.out.print("[" + interval.left + ", " + interval.right + "], ");
		}
	}
}
