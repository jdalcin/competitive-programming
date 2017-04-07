import java.util.*;

/*
 * checks your age. Asks you to try again if you do not place an int. Utilizes the concept of error catching.
 */

public class tutorial8 {

	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.println("How old are you?");
		
		int age = checkValidAge();
		
		if(age != 0)
		{ 
			System.out.println("You are " + age + " years old.");
		}

	}

	public static int checkValidAge()
	{
		try
		{
			return userInput.nextInt();
		}
		
		catch (InputMismatchException a)
		{
			userInput.next();
			System.out.println("That is not an integer. Try running program again.");
			return 0;
		}
	}
}
