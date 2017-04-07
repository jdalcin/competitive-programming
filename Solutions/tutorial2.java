import java.util.Scanner;

public class tutorial2 
{
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.print("Your favorite number: ");
		
		if(userInput.hasNextDouble())
		{
			double numberEntered = userInput.nextDouble();
			System.out.println("You wrote the double: " + numberEntered);
			double numberEnteredMultiply = numberEntered * numberEntered;
			double numberEnteredSubtract = numberEntered - numberEntered;
			double numberEnteredAddition = numberEntered + numberEntered;
			double numberEnteredDivision = numberEntered / numberEntered;
			double numberEnteredModulus = numberEntered % numberEntered;
			int numberEnteredDivision2 = (int) Math.sqrt(numberEntered);
			double numberEnteredMultiply2 = Math.random();
			System.out.println(numberEnteredDivision2);
			System.out.println(numberEnteredMultiply2);
			System.out.println(numberEntered + " + " + numberEntered + " = " + numberEnteredAddition);
			System.out.println(numberEntered + " - " + numberEntered + " = " + numberEnteredSubtract);
			System.out.println(numberEntered + " * " + numberEntered + " = " + numberEnteredMultiply);
			System.out.println(numberEntered + " / " + numberEntered + " = " + numberEnteredDivision);
			System.out.println(numberEntered + " % " + numberEntered + " = " + numberEnteredModulus);
		}
		else
		{
			System.out.println("Enter a Double next time.");
		}
		
		
	}
}
