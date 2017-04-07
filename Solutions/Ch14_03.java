import java.util.Arrays;

public class Ch14_03 {
	
	static void charPrint(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		int count = 0;
		System.out.print("(" + c[0] + ", ");
		for (int i = 0; i < c.length; i++) {
			if (i != 0 && c[i] != c[i-1]) {
				System.out.print(count + "), (" + c[i] + ", ");
				count = 0;
			}
			count++;
		}
		System.out.print(count + ")");
	}
	public static void main (String []args) {
		String s = "bcdacebe";
		charPrint(s);
	}
}
