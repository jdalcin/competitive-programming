import java.util.*;
import java.io.*;

public class Stack_Question1 {
	 	public static class Building {
	        int height;
	        int numAdjacentBuildings;
	        
	        public Building(int height, int numAdjacentBuildings) {
	            this.height = height;
	            this.numAdjacentBuildings = numAdjacentBuildings;
	        }
	    }
	    
	    //finds greatest k-area rectangle in O(N) time and space complexity
	    public static void main(String[] args) {
	        
	        int max = 0;
	        int numBuildings = 5;
	        Stack<Building> buildings = new Stack<Building>();
	        List<Integer> buildingArray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 2, 4, 1));
	        
	        
	        for (int i = 0; i < numBuildings; i++) {
	            if (buildings.isEmpty() || buildings.peek().height < buildingArray.get(i)) {
	                buildings.add(new Building(buildingArray.get(i), 1));
	                System.out.println(buildings.peek().numAdjacentBuildings);
	            } else if (buildings.peek().height == buildingArray.get(i)) {
	                ++buildings.peek().numAdjacentBuildings;
	            } else {
	                while (buildings.isEmpty() || buildings.peek().height > buildingArray.get(i)) {
	                    int numAdjacentBuilding = buildings.peek().numAdjacentBuildings;
	                    buildings.pop();
	                    if (buildings.isEmpty()) {
	                        buildings.add(new Building(buildingArray.get(i), numAdjacentBuilding));
	                        break;
	                    } else {
	                        if (buildings.peek().height < buildingArray.get(i)) {
	                             buildings.add(new Building(buildingArray.get(i), numAdjacentBuilding));
	                             break;
	                        } else if (buildings.peek().height == buildingArray.get(i)) {
	                            buildings.peek().numAdjacentBuildings += numAdjacentBuilding + 1;
	                            break;
	                        } else {
	                            buildings.peek().numAdjacentBuildings += numAdjacentBuilding;
	                        }
	                    }
	                }
	            }
	            int potentialMax = buildings.peek().height * buildings.peek().numAdjacentBuildings;
	            if (max < potentialMax) {
	                max = potentialMax;
	            }
	        }
	        System.out.println(max);
	    }
}
