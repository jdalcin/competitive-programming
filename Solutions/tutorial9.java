import java.io.*;

public class tutorial9 {

	/*
	 * practices error catching with io
	 */
	
	public static void main(String[] args) 
	{
		/*
		 * utilizes catch inside a method
		 */
		
		getAFile(".nofile.java");
		
		/*
		 * throws error from outside a method to the main function
		 */
		
		try
		{
		arithmeticError(2);
		}		
		catch (Exception b)
		{
			System.out.println("Why is your program dividing a number by 0?");
		}
	}

	public static void getAFile(String fileName)
	{
		try
		{
			FileInputStream file = new FileInputStream(fileName);
		}
		
		catch(FileNotFoundException a)
		{
			System.out.println("That file does not exist dude."); 
		}
		
		catch(IOException a)
		{
			System.out.println("This was your error.");
		}
		
		catch(Exception a)
		{
			System.out.println("Lol! Those errors.");
		}
		
		//catch(IOException | ClassNotFoundException a) {} //skips exception while running code
		
		finally
		{
			System.out.println("This last message always runs NO MATTER WHAT!");
		}
	}
	
	public static void arithmeticError(int c) throws ArithmeticException, Exception
	{
		int d = c/0;
	}
}
