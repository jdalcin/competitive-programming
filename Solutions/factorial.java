
public class factorial {
	
	int factoring(int x){
		int z = x - 1;
		if(x == 1 || x == 0){
			return 1;
		} else if(x < 0) {
			return -1;
		}
		int y = factoring(z);
		return (y*x);
	}
	
	void display(int x){
		if (x == -1){
		System.out.println("A negative number does not have a factorial. Try again.");
		} else{
			System.out.println("The factorial is " + x + ".");
		}
	}

	public static void main(String[] args) {
		
		factorial newFactorial = new factorial();
		
		int fact = newFactorial.factoring(5);
		newFactorial.display(fact);
		

	}

}
