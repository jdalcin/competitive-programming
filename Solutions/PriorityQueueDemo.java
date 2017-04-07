import java.util.*;


public class PriorityQueueDemo{
	
	public static class Symbol implements Comparable<Symbol>{
		Double rank;
		Character c;
		
		Symbol(Character c, Double rank) {
			this.rank = rank;
			this.c = c;
		}
		
		@Override
		public int compareTo(Symbol s) {
			return Double.compare(rank, s.rank);
		}
	}
	
	static PriorityQueue<String> minHeap;
	static PriorityQueue<Symbol> minHeap2;
	
	public static void main(String []args) {
		minHeap = new PriorityQueue<String>();
		minHeap2 = new PriorityQueue<Symbol>();
		minHeap.add("abcd"); minHeap.add("abc"); minHeap.add("ab"); minHeap.add("a");
		List<Symbol> symbols = Arrays.asList( new Symbol('a', 8.17), 
				new Symbol('b', 1.49), new Symbol('c', 2.78), new Symbol('d', 4.25));
		minHeap2.addAll(symbols);
		while (!minHeap2.isEmpty()) {
			System.out.println(minHeap2.remove().c);
		}
		System.out.println();
		Iterator<String> i = minHeap.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println();
		while (!minHeap.isEmpty()) {
			System.out.println(minHeap.remove());
		}
	}
	
}
