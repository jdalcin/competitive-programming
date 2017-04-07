import java.util.Scanner;
public class tutorial5 
{
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		
		String YorN = "Yes";
		int h = 1;
		
		while (YorN.equalsIgnoreCase("yes"))
		{
			System.out.println(h);
			System.out.println("Would you like to see the next number? Type in \"yes\" or \"no\":");
			YorN = userInput.nextLine();
			h++;
		}
		
		int i,z;
		
		for (i = 1, z = 1; i < 5; i++, z+=2)
		{
			System.out.println("Number may be: " + i + z); // if begin with a string, then autoconverts an int to a string ^_^
		}
		System.out.println("But Looks like your number is: " + i + z + " ok....that was a little off :D");
	}
}
