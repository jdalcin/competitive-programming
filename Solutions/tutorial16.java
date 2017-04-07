import java.util.Scanner;

public class tutorial16{
	
	public static void main(String[] args){
		
		Scanner N = new Scanner(System.in);
		int n = N.nextInt();
		
		if(n % 2 == 1 || (n % 2 == 0 && n <= 20 && n >= 6) ){
		System.out.println("Weird");
		} else {
			System.out.println("Not Weird");
		}
		
	}

}
