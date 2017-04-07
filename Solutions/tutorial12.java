import java.util.Arrays;

public class tutorial12 
{

	public static void main(String[] args) 
	{
		
		int[] randomArray;
		int[] numberArray = new int[10]; // can only have one type of element in an array
		
		randomArray = new int[20];
		randomArray[1] = 2;
		String[] stringArray = {"just", "random", "words"};
		
		/*
		 * uses long for loops
		 */
		
		for (int i = 0; i < numberArray.length; i++)
		{
			numberArray[i] = i;
			// System.out.println(numberArray[i]);
		}
		
		String[][] multiArray = new String[10][10];
		
		/*
		 * creates multiArray
		 */
		
		for(int i = 0; i < multiArray.length; i++)
		{
			
			for(int j = 0; j < multiArray[i].length; j++)
			{
				multiArray[i][j] = (i + 1) + " , " + (j + 1);
			}
			
		}
		
		/*
		 * creates output of multiArray
		 */
		
		for(int i = 0; i < multiArray.length; i++)
		{
			
			for(int j = 0; j < multiArray[i].length; j++)
			{
				
				System.out.print("| " + multiArray[i][j] + " ");
				
			}
			
			System.out.print("|");
			System.out.println("");
			
		}
		
		/*
		 * uses enhanced for loops for 1-dimensional array
		 */
		
		for(int row : numberArray)
		{
			numberArray[row] = 10 + row;
			System.out.println(numberArray[row]);
		}
		
		/*
		 * uses enhanced for loop for multi-dimensional array
		 */
		
		for(String[] rows : multiArray)
		{
			for(String column : rows)
			{
				
				System.out.print("| " + column + " ");
				
			}
			
			System.out.print("|");
			System.out.println("");
			
			
		}
		
		int[] myArray ={1,2,3,4,5,6,7,8,9,10};
		
		
		for (int myValue : myArray) { System.out.print(myValue);}
		System.out.println("");
		
		int[] myArray2 = Arrays.copyOf(myArray, 5); // method indexes from 1
		myArray2 = Arrays.copyOfRange(myArray, 1,3);//indexes starting at index 0 from [initial inclusive, final exclusive]
		
		for (int myValue2 : myArray2) {System.out.print(myValue2);};
		System.out.println("");
		
		int[] myArray3 = new int[50];
		Arrays.fill(myArray3, 2);// fills 1-dimensional array
		
		/*
		 * code to fill and output a 2-dimensional array of characters
		 */
		
		for (int myValue3 : myArray3) { System.out.print(myValue3);}
		
		char[][] multiArray2 = new char[10][10];
		
		for(int i = 0; i < multiArray2.length ; i++)
		{
			Arrays.fill(multiArray2[i],'A');
		}
		
		for(char[] myValue4 : multiArray2)
		{
			for(char columns : myValue4)
			{
				System.out.print("| " + columns + " ");
			}
			
			System.out.print("|");
			System.out.println("");
		}
		
		/*
		 * sorts a random array
		 */
		
		int[] myArray4 = new int[10];
		for (int i = 0; i < myArray4.length; i++)
		{
			myArray4[i] = (int) (Math.random() * 100);
		}
		
		Arrays.sort(myArray4);
		System.out.println("");
		
		for(int myValue5 : myArray4){ System.out.print(myValue5 + " ");}
		
	}
}
