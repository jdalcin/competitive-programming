
public class tutorial1 
{
	static String randomString = "String to print";
	static final double PINUM = 3.14;
	static final boolean truth = true;
	public static void main(String[] args) 
	{
		// System.out.println(PINUM); // commentforward 
		int integerTwo = 2;
		int integerOne = integerTwo - 1;
		double three = 3.34;
		String lol = "lol";
		String ol = "ol!";
		String lolol = lol + ol;
		char a = 'a';
		String doubleTwo = Integer.toString(integerOne);
		String doubledecimal = Double.toString(three);
		int doubleToInt = (int) three;
		double intToDouble = (double) integerOne;
		int stringToInt = Integer.parseInt("5");
		double stringToDouble = Double.parseDouble("5.5");
		System.out.println("Guess what number I am? \n" + stringToDouble);
		
	}
}