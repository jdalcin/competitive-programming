

public class tutorial7 
{

	
	public static void main(String[] args) 
	{
		int b = (int) 2.5;
		
		try
		{
			int c = b/0;
			System.out.println(c);
		}
		
		catch(ArithmeticException a)
		{
			System.out.println("Dude you cannot divide by zero! ");
			System.out.println(a.getMessage());
			System.out.println(a.toString());
			a.printStackTrace();
		}
	}
	
	public static void divideByZero(int a)
	{
	
			System.out.println(a/5);
	}
}
