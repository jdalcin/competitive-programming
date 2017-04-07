import java.util.*;

public class Ch19_03 {
	
	public static class Coordinate {
		int x;
		int y;
		
		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void outputMatrix(List<List<Boolean>> matrix) {
		for (List<Boolean> row : matrix) {
			for (Boolean col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	//uses BFS
	public static void paintMatrix(List<List<Boolean>> maze, Coordinate start) {
		if (maze == null || maze.size() == 0 || start == null || start.x > maze.get(0).size() || start.y > maze.size() || start.x < 0 || start.y < 0) {
			return;
		}
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		Boolean initBool = maze.get(start.y).get(start.x);
		maze.get(start.y).set(start.x, !initBool);
		queue.add(start);
		List<List<Integer>> shifts = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0),
												  Arrays.asList(0, -1), Arrays.asList(-1, 0));
		while (!queue.isEmpty()) {
			Coordinate current = queue.poll();
			maze.get(current.y).set(current.x, !initBool);
			for (List<Integer> shift : shifts) {
				Coordinate increment = new Coordinate(current.x + shift.get(0), current.y + shift.get(1));
				if (isFeasible(maze, increment, initBool)) {
					queue.add(increment);
				}
			}
		}
	}
	
	public static boolean isFeasible(List<List<Boolean>> maze, Coordinate point, Boolean compareBool) {
		if (point.x >= 0 && point.x < maze.get(0).size() && point.y >= 0 && point.y < maze.size()) {
			boolean pointBool = maze.get(point.y).get(point.x);
			if (pointBool == compareBool) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Coordinate start = new Coordinate(0, 0);
		List<List<Boolean>> maze = new ArrayList<List<Boolean>>();
		//create maze of type Boolean
		for (int row = 0; row < 5; row++) {
			maze.add(new ArrayList<Boolean>());
			for (int col = 0; col < 5; col++) {
				if (col == 0) {	
					maze.get(row).add(false);
				} else {
					maze.get(row).add(true);
				}
			}
		}
		maze.get(4).set(4, false);
		//paint and output the maze
		outputMatrix(maze);
		paintMatrix(maze, start);
		System.out.println();
		outputMatrix(maze);
	}
}
