import java.util.Scanner;

public class tutorial6 
{
	static double myPi = 3.14159; // accesible from any point from class
	
	static Scanner userInput = new Scanner(System.in);
	
	public static double addThem(double a, double b)
	{
		double myPi = 3;
		myPi = 3 + 2;
		double added = a + b;
		return myPi;
	}
	
	public static int randomness(int f) //returns a random number
	{
		int random = (int) (Math.random()*f);
		return random;
	}
	public static void main(String[] args) 
	{
		/*
		 * the next five steps show the difference between class and local variables
		 */
		double added = addThem(myPi,myPi + 2);
		System.out.println(added);
		System.out.println(myPi);
		myPi = myPi + 2;
		System.out.println(myPi); 
		
		/*
		 * making code that creates a random number from a previously created method/function and then allows the user to keep guessing until he gets it right
		 */
		
		int randomNumber = randomness(100);
		int c = 500;
		System.out.println(randomNumber);
		
		while(c != randomNumber)
		{
		System.out.println("Guess an integer between 0 and 100: ");
		c = userInput.nextInt();
		} 
		
		System.out.println("Correct! " + randomNumber + " is the right number ^_^");
	}
}
