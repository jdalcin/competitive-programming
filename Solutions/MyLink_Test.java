
public class MyLink_Test {
	
	public static void main(String[] args){
		
		MyLinkedList bennieFamily = new MyLinkedList();
		
		bennieFamily.insertNewLink("Bennie", 25);
		bennieFamily.insertNewLink("Matthew", 22);
		bennieFamily.insertNewLink("Andrew", 20);
		bennieFamily.insertNewLink("Natania", 17);
		bennieFamily.insertNewLink("Megan", 17);
		bennieFamily.findSpecific(2);
		bennieFamily.findSpecific(3);
		bennieFamily.displayLinkedList();
		
		
	}

}
