import java.util.Scanner;

public class tutorial3 
{
	public static void main (String[] args)
	{
		int randomnumber = (int) (Math.random() * 50);
		
		if (randomnumber < 25)
		{
			System.out.println("The random number is less than 25 because it is " + randomnumber);
		}
		else
		{
			System.out.println("The random number is not less than 25 because it is " + randomnumber);
		}
		
		if (true && true)
		{
			System.out.println("\nGuess someone is telling the truth!");
		}
		if (true || false)
		{
			System.out.println("c'mon man! We know you are telling the truth!!!");
			
		}
		if (false ^ true)
		{
			System.out.println("Ain't no party like a Nick Cannon Party cuz a Nick Cannon party don't stop ^_^");
		}
		
		int value1 = 800;
		int value2 = 700;
		
		int smallerValue = (value1 < value2) ? value1 : value2;
		
		System.out.println(smallerValue);
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Type in your grade: ");
		
		String grade = userInput.next();
		char Grade = grade.charAt(0);      
		
		switch(Grade)
		{
			case 'A':
			case 'a':
				System.out.println("Great!");
				break;
			case 'B':
			case 'b':
				System.out.println("Good!");
				break;
			case 'C':
			case 'c':
				System.out.println("Ok...");
				break;
			case 'D':
			case 'd':
				System.out.println("Man you suck.......");
				break;
			default:
				System.out.println("Just Quit NOW");
		}
		
		switch (Grade)
		{
		case 'A':
		case 'a':
		case 'B':
		case 'b':
			boolean happiness = true;
			String happy = (happiness) ? "happy" : "sad";
			System.out.println(happy);
			break;
		default:
			happiness = false;
			happy = (happiness) ? "happy" : "sad";
			System.out.println(happy);
		}
		
	}
}
