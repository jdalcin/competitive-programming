
public class tutorial4 
{
	public static void main(String[] args)
	{
		double i = 3;
		double pi = 4;
		
		while(i <= 1000)
		{
			pi = pi - (4/i) + (4/(i+2));
			i += 4;
		}
		System.out.println("This is my calculated value of PI: " + pi);
	}
}
  