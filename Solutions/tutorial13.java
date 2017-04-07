/*-----------------------------
 * Author: Jeremy Dalcin
 * Motivation: learning how to use array lists. 
 * They are like arrays except automatically resize when you delete or add objects to it.
 * Class: uses array lists
 * ----------------------------*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class tutorial13<E> extends ArrayList<E> {

	public static void main(String[] args) {
		
		ArrayList arrayListOne;
		
		arrayListOne = new ArrayList(); //starts at default size of 10, but does not matter as it automatically changes size
		ArrayList arrayListTwo = new ArrayList(); //ArrayList can accept any object unless you specify otherwise
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Jeremy Dalcin");
		names.add("Matthew Dalcin");
		names.add("Andrew Dalcin");
		
		names.add(1, "Jiminy Cricket"); //inserts in position by shifting up index
		
		names.set(2, "Pinocchio"); // replaces object in index
		
		names.remove(3); // removes object
		
		//names.removeRange(1,2);
		
		for (String name : names){
			System.out.println(name);
		}
		
		System.out.println(names); // prints out whole arraylist in brackets
		
		Iterator indivItems = names.iterator(); // how is this notation possible?
		
		while (indivItems.hasNext() ){ // returns a boolean showing if there is a value in next index
			
			System.out.println(indivItems.next() );
		}
		
		ArrayList nameCopy = new ArrayList();
		ArrayList nameBackup = new ArrayList();
		
		nameCopy.addAll(names); // add Array Lists to other Arrays
		
		names.add("Johan");
		
		//names.containsall(arraylist) -> checks if object arraylist contains all values as in another arraylist
		
		if (names.contains("Johan") ){
			
			System.out.println("Johan is in the arraylist!");
		}
		
		// names.clear() -> clears array list, names.isEmpty() -> returns true if ArrayList is empty
		/*---------------------------------------------
		 * Shows how to turn an arraylist into an array
		 * 
		 *---------------------------------------------*/
		
		Object[] array = new Object[4]; // why do we have to make an object array to make an arraylist into an object?
		array = nameCopy.toArray();
		
		System.out.println(Arrays.toString(array));
 
	}

}
