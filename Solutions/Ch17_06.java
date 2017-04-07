import java.util.*;

public class Ch17_06 {
	
	protected static class Item {
		Integer weight;
		Integer value;
		Character name;
		
		Item(Integer value, Integer weight, Character name) {
			this.weight = weight;
			this.value = value;
			this.name = name;
		}
	}
	
	private static Integer maxValue(List<Item> items, Integer maxWeight) {
		List<Integer> values = new ArrayList<Integer>(Collections.nCopies(maxWeight + 1, 0));
		for (Item item : items) {
			for (int j = maxWeight; j >= item.weight; --j) {
				values.set(j, Math.max(values.get(j), values.get(j - item.weight) + item.value));
			}
		}
		return values.get(maxWeight);
	}
	
	public static void main(String []args) {
		Integer maxWeight = 130;
		List<Item> items = Arrays.asList(new Item(65, 20, 'A'), new Item(35, 8, 'B'), new Item(245, 60, 'C'), 
				new Item(195, 55, 'D'), new Item(65, 40, 'E'), new Item(150, 70, 'F'), new Item(275, 85, 'G'),
				new Item(155, 25, 'H'), new Item(120, 30, 'I'), new Item(320, 65, 'J'), new Item(75, 75, 'K'),
				new Item(40, 10, 'L'), new Item(200, 95, 'M'), new Item(100, 50, 'N'), new Item(220, 40, 'O'),
				new Item(99, 10, 'P'));
		System.out.println(maxValue(items, maxWeight));
				
	}
}
