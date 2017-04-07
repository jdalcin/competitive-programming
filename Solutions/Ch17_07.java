import java.util.*;

/*                     M(A[0,1,...,i -1], B[0,1,...,j-1])
      n                   /                   \ 
                       M(A[0,1,....,i -2],
                       
                       
                       M(i,j) = min[(M(A[i - 1, j), M(i, j - 1)) - A(j)]

*/
public class Ch17_07 {
	
	private static class Item implements Comparable<Item>{
		Integer weight;
		Integer value;
		Character name;
		
		Item(Integer value, Integer weight, Character name) {
			this.weight = weight;
			this.value = value;
			this.name = name;
		}
		

		public int compareTo(Item item2) {
			return -Integer.compare(this.value, item2.value);
		}
	}
	
	private static Integer minimizedSplit (List<Item> items) {
		Collections.sort(items);
		for (int i = 0; i < items.size(); i++) {
			System.out.print(items.get(i).value + ", ");
		}
		System.out.println("\n");
		int[][] minimizedSplits = new int[items.size() + 1][items.size() + 1];
		
		for (int col = 1; col <= items.size(); col++) {
			minimizedSplits[0][col] = items.get(col - 1).value + minimizedSplits[0][col - 1];
		}
		for (int row = 1; row <= items.size(); row++) {
			minimizedSplits[row][0] = items.get(row - 1).value + minimizedSplits[row - 1][0];
		}
			
		for (int row = 1; row <= items.size(); row++) {
			for (int col = 1; row + col <= items.size(); col++) {
				int prevMinimizedDifference = Integer.MAX_VALUE;
					if (minimizedSplits[row][col - 1] < prevMinimizedDifference) {
						prevMinimizedDifference = minimizedSplits[row][col - 1];
					}
					if (minimizedSplits[row - 1][col] < prevMinimizedDifference) {
						prevMinimizedDifference = minimizedSplits[row - 1][col];
					}
			minimizedSplits[row][col] = Math.abs(items.get(row + col - 1).value - prevMinimizedDifference);
			}
		}
		
		for (int[] row : minimizedSplits) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
		List<Integer> minArray = new ArrayList<Integer>();
		for (int i = 0; i < items.size() + 1; i++) {
			minArray.add(minimizedSplits[i][items.size() - i]);
		}
		return minArray(minArray);
	}
	
	private static Integer minArray(List<Integer> array) {
		Collections.sort(array);
		return array.get(0);
	}
	
	public static void main(String[] args) {
		List<Item> items = Arrays.asList(new Item(5, 20, 'A'), new Item(10, 8, 'B'), new Item(15, 60, 'C'), 
				new Item(20, 55, 'D'));
		
		/*List<Item> items = Arrays.asList(new Item(1, 20, 'A'), new Item(5, 8, 'B'), new Item(10, 60, 'C'));*/
		
		/*List<Item> items = Arrays.asList(new Item(65, 20, 'A'), new Item(35, 8, 'B'), new Item(245, 60, 'C'), 
				new Item(195, 55, 'D'), new Item(65, 40, 'E'), new Item(150, 70, 'F'), new Item(275, 85, 'G'),
				new Item(155, 25, 'H'), new Item(120, 30, 'I'), new Item(320, 65, 'J'), new Item(75, 75, 'K'),
				new Item(40, 10, 'L'), new Item(200, 95, 'M'), new Item(100, 50, 'N'), new Item(220, 40, 'O'),
				new Item(99, 10, 'P'));*/
		System.out.println(minimizedSplit(items));
	}
	
}
