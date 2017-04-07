import java.util.*;

public class Ch14_07 {
	
	private static class Endpoint {
		int value;
		boolean isOpen;
		
		Endpoint(int value, boolean isOpen) {
			this.value = value;
			this.isOpen = isOpen;
		}
	}
	
	public static class Interval implements Comparable<Interval> {
		Endpoint left;
		Endpoint right;
		
		Interval(Endpoint left, Endpoint right) {
			this.left = left;
			this.right = right;
		}
		
		@Override
		public int compareTo(Interval i) {
			int cmp = Integer.compare(left.value, i.left.value);
			if (cmp != 0) {return cmp;}
			//if left endpoints of intervals are equal, makes sure the closed endpoint is to left of open
			//endpoint
			return left.isOpen && !i.left.isOpen ? 1 : !left.isOpen && i.left.isOpen ? -1 : 0;
		}
	}
	
	//returns a union of intervals out of a set of disjoint intervals
	//takes O(nlogn) time complexity and O(n) space complexity
	public static List<Interval> unionOfIntervals(List<Interval> disjointIntervals) {
		Collections.sort(disjointIntervals);
		List<Interval> unionIntervals = new ArrayList<Interval>();
		Endpoint minLeft = new Endpoint(disjointIntervals.get(0).left.value, disjointIntervals.get(0).
				left.isOpen);
		Endpoint maxRight = new Endpoint(disjointIntervals.get(0).right.value, disjointIntervals.get(0).
				right.isOpen);
		for (int i = 0; i < disjointIntervals.size() - 1; i++) {
			Endpoint currRight = disjointIntervals.get(i).right;
			Endpoint nextRight = disjointIntervals.get(i+1).right;
			Endpoint currLeft = disjointIntervals.get(i).left;
			Endpoint nextLeft = disjointIntervals.get(i+1).left;
			if (maxRight.value >= nextLeft.value) {
				if (maxRight.value < nextRight.value || maxRight.value == nextRight.value && !nextRight.isOpen) {
					maxRight = nextRight;
				} 
			} else { //end of Interval
				unionIntervals.add(new Interval(minLeft, maxRight));
				minLeft = nextLeft;
				maxRight = nextRight;
			}
			
		}
		unionIntervals.add(new Interval(minLeft, maxRight));
		return unionIntervals;
	}
	
	public static void main(String []args) {
		List<Interval> disjointIntervals = new ArrayList<Interval>(Arrays.asList(new Interval(
				new Endpoint(0, true), new Endpoint(3, true)), new Interval(new Endpoint(1, false),
				new Endpoint(1, false)), new Interval(new Endpoint(3, false), new Endpoint(4, true)),
				new Interval(new Endpoint(2, false), new Endpoint(4, false)),
				new Interval(new Endpoint(5, false), new Endpoint(7, true)),
				new Interval(new Endpoint(7, false), new Endpoint(8, true))));
		List<Interval> unionIntervals = unionOfIntervals(disjointIntervals);
		for (Interval interval : unionIntervals) {
			System.out.print(interval.left.isOpen ? "(" : "[");
			System.out.print(interval.left.value + ", " + interval.right.value);
			System.out.print(interval.right.isOpen ? "), " : "], ");
		}
		
	}
}
