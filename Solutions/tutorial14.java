/*--------------------------
 * Author: Jeremy Dalcin
 * Motivation: linked lists are efficient when you have a collection that you plan on adding and deleting
 * from a lot. Arrays and ArrayLists , however, are preferred when you care more about accessing objects.
 * Class: uses linked lists
 *--------------------------*/

import java.util.Arrays;
import java.util.LinkedList;

public class tutorial14 {

	public static void main(String[] args) {
		
		LinkedList linkedListOne = new LinkedList(); //unrestricted linkedlist
		
		LinkedList<String> names = new LinkedList<String>(); //restricted by strings
		
		/*
		 * methods are pretty much the same as an array list (i.e contains, containsall
		 */
		
		names.add("Getting Jiggy");
		names.add("Jiggy Man");
		
		names.addLast("The Jigster");
		names.addFirst("Jigster Jr.");
		names.add(0,"YALL");
		
		LinkedList<String> nameCopy = new LinkedList<String>(names); // makes a linkedlist out of object -> names
		
		for (String name: names){
			System.out.println(name);
		}
		
		/*
		 * some LinkedList methods
		 */
		
		System.out.println("Last name: " + nameCopy.getLast() );
		System.out.println("Position of: " + nameCopy.indexOf("Jiggy Man") );
		System.out.println("Is the array \"name copy\" empty: " + nameCopy.isEmpty() );
		System.out.println("The size of \"name copy\" is: " + nameCopy.size() );
		System.out.println("First object in the array: " + nameCopy.peek() );
		System.out.println("Removing 1st object from list whose name is: " + nameCopy.poll() ); // I think you can only delete/insert first or last element in a linkedlist
		
		/*
		 * turn LinkedList into array
		 */
		
		Object[] array = new Object[4];
		
		array = nameCopy.toArray();
		
		System.out.println(Arrays.toString(array));
		

	}

}
