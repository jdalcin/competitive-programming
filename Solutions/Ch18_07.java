import java.util.*; 

public class Ch18_07 {
	
	public static void main(String []args) {
		List<Integer> gallonsAtCity = new ArrayList<Integer>(Arrays.asList(10, 45, 25, 20, 15, 
				15, 15, 35, 25, 30, 15, 65, 45));
		List<Integer> distances = new ArrayList<Integer>(Arrays.asList(200, 300, 300, 300, 400, 
				1000, 300, 300, 600, 400, 1100, 400, 1000));
		List<Integer> gallonsNecessary = new ArrayList<Integer>();
		for (int i = 0; i < distances.size(); i++) {
			gallonsNecessary.add(distances.get(i) / 20);
		}
		List<Integer> xI = new ArrayList<Integer>();
		for (int i = 0; i < gallonsAtCity.size(); i++) {
			xI.add(gallonsAtCity.get(i) - gallonsNecessary.get(i));
		}
		List<Integer> sI = new ArrayList<Integer>();
		sI.add(xI.get(0));
		for (int i = 1; i < xI.size(); i++) {
			sI.add(sI.get(i - 1) + xI.get(i));
		}
		System.out.println(gallonsAtCity);
		System.out.println(distances);
		System.out.println(gallonsNecessary);
		System.out.println(xI);
		System.out.println(sI);
	}
}
