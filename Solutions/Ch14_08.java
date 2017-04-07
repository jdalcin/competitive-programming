import java.util.*;

public class Ch14_08 {
	
	private static class Person {
		String name;
		int age;
		
		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
	
	private static class Range {
		int startIndex;
		int endIndex;
		
		Range(int startIndex, int endIndex) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}
	}
	//takes a list of people and groups them by age
	//-takes O(n) time complexity and O(m) space complexity, where n is the number of people and m is the
	//distinct ages
	private static void groupAge(List<Person> people) {
		Map<Integer, Integer> ageHash = new HashMap<Integer, Integer>();
		Map<Integer, Range> indexHash = new HashMap<Integer, Range>();
		Integer age;
		for (int i = 0; i < people.size(); i++) {
			age = people.get(i).age;
			if (ageHash.containsKey(age)) {
				ageHash.put(age, ageHash.get(age) + 1);
			} else {
				ageHash.put(age, 1);
			}
		}
		Set<Integer> ages = ageHash.keySet();
		Integer startIndex = 0;
		for (Integer personAge : ages) {
			indexHash.put(personAge, new Range(startIndex, ageHash.get(personAge) + startIndex));
			startIndex = startIndex + ageHash.get(personAge);
		}
		for (int i = 0; i < people.size(); i++) {
			Integer currAge = people.get(i).age;
			Person currPerson = people.get(i);
			Integer sIndex = indexHash.get(currAge).startIndex;
			Integer endIndex = indexHash.get(currAge).endIndex;
			while(people.get(sIndex).age != currAge) {
				endIndex = indexHash.get(currAge).endIndex;
				indexHash.put(currAge,
						new Range(sIndex + 1 >= endIndex ? sIndex : sIndex + 1, endIndex));
				Person nextPerson = people.get(sIndex);
				people.set(sIndex, currPerson);
				currPerson = nextPerson;
				currAge = nextPerson.age;
				sIndex = indexHash.get(currAge).startIndex;
			}
			indexHash.put(currAge,
					new Range(sIndex + 1 >= endIndex ? sIndex : sIndex + 1, endIndex));
		}
		
	}
	public static void main(String []args) {
		List<Person> people = new ArrayList<Person>(Arrays.asList(new Person("Megan", 17), new Person("Bennie",
				25), new Person("Natania", 17), new Person("Jeremy", 25), new Person("Matthew", 23),
				new Person("Andrew", 20), new Person("Andrew2", 20)));
		groupAge(people);
		for (Person person : people) {
			System.out.print(person.name + " ");
		}
	}
}
