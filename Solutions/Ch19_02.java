import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Ch19_02 {
	
	
	//uses DFS to search maze and returns a viable path. Has O(n^2) complexity.
	public static List<Coordinate> getPath(List<List<Color>> maze, Coordinate start, Coordinate end) {
		List<Coordinate> path = new LinkedList<Coordinate>();
		getPathHelper(path, maze, start, end);
		return path;
	}
	
	public static boolean getPathHelper(List<Coordinate> path, List<List<Color>> maze, Coordinate start, Coordinate end) {
		if (maze.get(start.y).get(start.x) == Color.BLACK) {
			return false;
		}
		path.add(start);
		maze.get(start.y).set(start.x, Color.BLACK);
		if (start.equals(end)) {
			return true;
		}
		List<List<Integer>> shift = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0), Arrays.asList(0, -1),
												  Arrays.asList(-1, 0));
		boolean correctPath = false;
		for (List<Integer> tweak : shift) {
			Coordinate increment = new Coordinate(start.x + tweak.get(0), start.y + tweak.get(1));
			if (increment.x >= 0 && increment.x < maze.get(0).size() && increment.y >= 0 && increment.y < maze.size()) {
				correctPath = getPathHelper(path, maze, increment, end);
				if (correctPath) {
					break;
				}
			}
		}
		if (!correctPath) {
			path.remove(path.size() - 1);
		} 
		return correctPath;
	}
	
	public static void main(String[] args) {
		Coordinate start = new Coordinate(0, 0);
		Coordinate end = new Coordinate(4, 4);
		List<List<Color>> maze = new ArrayList<List<Color>>();
		//sets up maze
		for (int row = 0; row < 5; row++) {
			maze.add(new ArrayList<Color>());
			for (int col = 0; col <= row; col++) {
				maze.get(row).add(Color.WHITE);
			}
			for (int col = row + 1; col < 5; col++) {
				maze.get(row).add(Color.BLACK);
			}
		}
		//retrieves a path from white to black in maze
		List<Coordinate> path = getPath(maze, start, end);
		for(Coordinate coordinate : path) {
			System.out.println("(" + coordinate.x + ", " + coordinate.y + ")");
		}
	}
	
	private static enum Color {BLACK, WHITE}
	
	public static class Coordinate {
		int x;
		int y;
		
		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			
			if (o == null || this.getClass() != o.getClass()) {
				return false;
			}
			
			Coordinate that = (Coordinate) o;
			if (this.x == that.x && this.y == that.y) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.x, this.y);
		}
	}
}
